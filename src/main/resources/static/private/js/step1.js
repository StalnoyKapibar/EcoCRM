function step1(stepDto) {
    let nav_pils = $('#step_1_nav_pils');
    let tab_content = $('#step_1_tabContent');
    nav_pils.html('');
    tab_content.html('');
    stepId = stepDto.id;
    $.each(stepDto.tasks, function (key, value) {
        if (value.name !== null) {
            nav_pils.append(
                '<a class="nav-link" data-toggle="pill" href="#task1_' + value.id + '" role="tab" aria-controls="v-pills-home" aria-selected="true">' +
                value.name + '</a>');

            tab_content.append(
                ' <div class="tab-pane fade show active" id="task1_' + value.id + '" role="tabpanel" aria-labelledby="v-pills-home-tab">' +
                '<h5>Описание:</h5><h5>\n' + value.description + '</h5><br></div>');

            if (value.type === 'CONTRACTOR_INFO') {
                $('#task3_' + value.id).append(
                    '<div id="task_3_1"><table class="table table-hover">\n' +
                    '<tbody id="tableCompany"></tbody></table>\n' +
                    '<button type="button" class="btn btn-outline-primary">Добавить заготовителя +</button></div>')
            }

            $('#task3_' + value.id).append(
                '<label for="comment" class="h6">Комментарий:</label>\n' +
                '<textarea class="form-control" rows="5"></textarea></div>');
        }
    });

}