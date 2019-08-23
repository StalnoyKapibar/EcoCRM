function getProjects() {
    $.ajax({
        url: "/api/projects",
        type: "GET",
        async: false,
        success: function (projects) {
            let count = 0;
            let docVar = '';
            $.each(projects, function (key, value) {
                count++;
                // docVar+='<div class="col card ml-1 mr-1 eco-column">' +
                //     '            <div class="card-body eco-column-body">' +
                //     '                <div class="card-title">' +
                //     '                    <h6>Шаг ' + count + '</h6>' +
                //     '                </div>'
                docVar+='<div class="eco eco-column">' +
                    '            <div class="eco eco-column-body">' +
                    '                <div class="eco-card-title">' +
                    '                    <h6>Шаг ' + count + '</h6>' +
                    '                </div>';
                $.each(value, function (i, project) {
                    // docVar+='<div class="card eco-card">' +
                    //     '                        <div class="card-body">' +
                    //     '                            <div class="card-title eco-card-title">' +
                    //     '                                <p>' + project.title +'</p>' +
                    //     '                            </div>' +
                    //     '                        </div>' +
                    //     '     </div>'
                    docVar+='<div class="eco eco-card">' +
                        '                            <div class="eco-card-title">' +
                        '                                <p>' + project.title +'</p>' +
                        '                            </div>' +
                        '     </div>'
                });
                docVar+='</div> </div>';
        });
            $("#projectsTable").html(docVar);
        }
    });
}