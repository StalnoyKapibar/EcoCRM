let id;
$(function () {
    id = $('#projectId').val();
    let stepCurrentNumber = $('#stepNumber').val();
    getStep(stepCurrentNumber);
});

function getStep(stepNumber) {
    $.ajax({
        url: "/api/project/" + id + "/stepdto?stepnumber=" + stepNumber,
        type: "GET",
        success: function (stepDto) {
            $('#' + stepNumber+'_link').addClass('active');
            $('#' + stepNumber).addClass('show');
            $('#' + stepNumber).addClass('active');

            if(stepNumber =='STEP_1'){

            }
            if(stepNumber =='STEP_2'){
                step2(stepDto);
            }
            if(stepNumber =='STEP_3'){
                step3(stepDto);
            }
            if(stepNumber =='STEP_4'){

            }
            if(stepNumber =='STEP_5'){

            }
            if(stepNumber =='STEP_6'){

            }
            if(stepNumber =='STEP_7'){
                step7(stepDto);
            }
            if(stepNumber =='STEP_8'){

            }
        }
    });
}

function step3(stepDto) {
    let stepId = stepDto.id;
    $.each(stepDto.tasks, function (key, value) {
        if (value.name !== null) {
            $('#tabListStep3').append(
                '<a class="nav-link" data-toggle="pill" href="#task3_' + value.id + '" role="tab" aria-controls="v-pills-home" aria-selected="true">\n' +
                value.name + '</a>');

            $('#tabContentStep3').append(
                ' <div class="tab-pane fade show active" id="task3_' + value.id + '" role="tabpanel" aria-labelledby="v-pills-home-tab">\n' +
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

    $.each(stepDto.contractors, function (key, company) {
        $('#tableCompany').append(
            '<tr><td data-toggle="modal" data-target="#contractor_modal">'+ company.name +'</td>' +
            '<td><a class="btn btn-warning" onclick="showContractor(' + company + ')">Данные</a></td><td><div class="dropdown"><input id="datepicker3" width="276" />' +
            '<button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id="1" onclick="getData(this.id)">Назначить встречу' +
            '</button><div class="dropdown-menu" aria-labelledby="dropdownMenuButton"><input id="1_datapiker" placeholder="назначить встречу">' +
            '<button class="btn btn-success" type="button" onclick="appoint(1)">назначить</button></div></div></td></tr>');
    });
    // $('#tabListStep3').on('click', show_add_task_modal());
    $('#tabListStep3').append(
        '<a class="nav-link" onclick="show_add_task_modal()">Добавить задачу</a>');
}

function show_add_task_modal() {
    // $('#step_number_create_task').val("");
    // $('#step_number_create_task').val(stepnumber);
    $('#add_task_modal').modal('show');
}

function add_task(){
    let name = $('#name_of_task').val();
    let desc = $('#description_of_task').val();
    var taskVal = {
        'name': name,
        'description': desc };

    $.ajax({
        type: 'POST',
        url: "/api/tasks/add?step_id=" + stepId,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(taskVal),
        success: function (task) {
            alert("Задача добавлена");

            $('#tabListStep3').append(
                '<a class="nav-link" data-toggle="pill" href="#task3_' + task.id + '" role="tab" aria-controls="v-pills-home" aria-selected="false">\n' +
                task.name + '</a>');

            $('#tabContentStep3').append(
                ' <div class="tab-pane fade" id="task3_' + task.id + '" role="tabpanel" aria-labelledby="v-pills-home-tab">\n' +
                '<h5>Описание:</h5><h5>\n' + task.description + '</h5><br></div>');
        },
        error: function () {
            alert("Задача не добавлена");
        }
    });
}