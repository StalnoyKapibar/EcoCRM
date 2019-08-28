$(document).ready(function () {
    $('#container_installation_date').datepicker({
        format: 'yyyy-mm-dd',
        uiLibrary: 'bootstrap4'
    });
});

function step5(stepDto) {
let project = stepDto.project;
let images = project.newContainerPhoto;
    $("#container_comment").val('');
    $("#container_comment").val(project.newContainerComment);
    $("#container_installation_date").val('');
    $("#container_installation_date").val(project.newContainerDate);
    $('#new_container_photos').html('');
    for(let i = 0; i<images.length; i++){
        $('#new_container_photos').append('<img src="data:image/png;base64,' + images[i].photo + '" alt="profile image"  height="200px">');
    }
}

function saveContainerInfo(projectId) {
    let comment = $("#container_comment").val();
    let date =  $("#container_installation_date").val();
    //var datestr = (new Date(date)).toUTCString();
    $.ajax({
        url: "/api/project/add_container_comment?projectid=" + projectId+
        '&newContainerComment='+comment+
        '&newContainerDate='+date,
        type: "POST",
        processData: false,
        contentType: 'application/json; charset=utf-8',
        success: function (request) {
            alert("information about container insert");
        },
        error: function(request) {
            alert("insert information about container FAILED!" + request.responseText);
        }
    });
}

function save_new_container_photo(projectId) {
    let img = $('#imgForm')[0];
    let data = new FormData(img);
    $.ajax({
        url: "/api/project/add_new_container_photo?projectid=" + projectId,
        type: "POST",
        data: data,
        processData: false,
        contentType: false,
        success: function (images) {
            for(let i = 0; i<images.length; i++){
                $('#new_container_photos').append('<img src="data:image/png;base64,' + images[i].photo + '" alt="profile image"  height="200px">');
            }
        },
        error: function(request) {
            alert(request.responseText);
            console.error("insert information about container FAILED!" + request.responseText);
        }
    });
}

