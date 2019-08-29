var projectId = [[${projectid}]];

$('#check_point_date').datepicker({
    format: 'yyyy-mm-dd',
    uiLibrary: 'bootstrap4'
});

$( document ).ready(function () {


    function saveCheckPointInfo() {
        var checkPoint = {
            'name': $('#check_point_name').val(),
            'description': $('#check_point_description').val(),
            'date': $('#check_point_date').val(),
        };
        $.ajax({
            url: "/manage/add_check_point?projectid=" + projectId,
            type: "POST",
            data: checkPoint,
            dataType: false,
            contentType: false,
            success: function () {
                console.log("");
            },
            error: function (e) {
                console.error("");

            }
        });

    }});

    // function saveCheckPointComment() {
    //
    // }


