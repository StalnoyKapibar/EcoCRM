function step7(stepDTO) {
    let tasks = stepDTO.tasks;
    for(let i = 0; i<tasks.length; i++){
        if(tasks[i].type === 'CASE_DESCRIPTION'){
            $('#task_7_1_textarea').val(stepDTO.report.description);
            let links = stepDTO.report.link;
            for(let b = 0; b<links.length; b++){
                $('#case_link_list').append('<div class="input-group mb-3">' +
                    '<div class="input-group-prepend">' +
                    '<span class="input-group-text" id="basic-addon1">@</span>' +
                    '</div>' +
                    '<input type="text" class="form-control" name="link" placeholder="link" aria-label="link" value="'+links[i]+'" aria-describedby="basic-addon1">' +
                '</div>');
            }

        }

    }
}

function addlink() {
    $('#case_link_list').append('<div class="input-group mb-3">' +
        '<div class="input-group-prepend">' +
        '<span class="input-group-text" id="basic-addon1">@</span>' +
        '</div>' +
        '<input type="text" class="form-control" name="link" placeholder="link" aria-label="link" aria-describedby="basic-addon1">' +
        '</div>');
}

function saveReport() {
    var links = [];
    $('#case_link_list input').each(function () {
        links.push(this.value);
    });
    var report = {
        'description':$('#task_7_1_textarea').val(),
        'link':links
    };
    $.ajax({
        url: "/report/add/" + projectId,
        type:"POST",
        async: false,
        data: JSON.stringify(report),
        contentType: 'application/json; charset=utf-8',
        success: function () {
            console.log("");
        },
        error: function(e) {
            console.error(e);
        }
    });
}


