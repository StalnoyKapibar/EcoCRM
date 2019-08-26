function step7(stepDTO) {
    let report = stepDTO.report;
    $("#description").val(report.description);
    $('#case_link_list').html('');
    for (var i = 0; i < report.link.length; i++) {
        $('#case_link_list').append('<div class="input-group mb-3">' +
            '<div class="input-group-prepend">' +
            '            <span class="input-group-text" id="basic-addon1">@</span>' +
            '            </div>' +
            '            <input type="text" class="form-control" name="link" placeholder="link" value=' + report.link[i] + ' aria-label="link" aria-describedby="basic-addon1">' +
            '            </div>');
    };

    report.for(link => {
        report.link.forEach(link => {$("#link").val(link.val())})
});
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
        'description':$('#description').val(),
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


