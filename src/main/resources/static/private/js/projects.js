function fillContent() {
    $.ajax({
        url: "/api/projects",
        type: "GET",
        async: false,
        success: function(projects) {
            let count = 0;
            let docVar = '';
            $.each(projects, function (key, value) {
                docVar += '<div class="col-2">' +
                    '                <div class="eco-column-header-extras">' +
                    '                    <h6>Шаг ' + (count+1) + '</h6>' +
                    '                </div>' +
                    '            <div class="eco-col card" id="col_' + count + '" style="height:47rem;overflow:auto;background-color: #F5F5F5">';
                $.each(value, function (i, project) {
                    docVar += '<div class="eco-card card m-2" style="height: 20%;box-shadow: 0px 5px 9px -8px #000000;">' +
                        '                            <div class="card-header" style="font-size: small">' + project.title + '</div>' +
                        '                            <div class="card-body">' +
                        '                            <div class="house-area">' + project.petition.houseArea + '</div>' +
                        '                            </div>' +
                        '     </div>'
                });
                docVar += '</div> </div>';
                count++;
            });
            $("#projectsTable").html(docVar);
        }
    });
}
