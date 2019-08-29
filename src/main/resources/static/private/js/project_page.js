let id;
let stepId;
$(function () {
    id = $('#projectId').val();
    let stepCurrentNumber = $('#stepNumber').val();
    getStep(stepCurrentNumber);
    initStaticToggles();
    switchToggles();
    fillToggles();
});

function getStep(stepNumber) {
    $.ajax({
        url: "/api/project/" + id + "/stepdto?stepnumber=" + stepNumber,
        type: "GET",
        success: function (stepDto) {
            $('#' + stepNumber + '_link').addClass('active');
            if(stepDto.status === 'IN_PROGRESS'){
                $('#' + stepNumber + '_link').nextAll('.nav-link').css({'background-color': '#d2d2d2', 'color': '#a49f9f', 'border': '1px solid', 'border-color':'#8d8787'});
                $('#' + stepNumber + '_link').prevAll('.nav-link').css({'background-color': '#e0f3df', 'color': '#8fb78d', 'border': '1px solid ', 'border-color':'#7e8c78'});
                $('#' + stepNumber + '_link').nextAll('.nav-link').addClass('disabled');
            }
            if(stepDto.status === 'DONE'){
                $('#' + stepNumber + '_togle').bootstrapToggle('on');
            }
            $('#' + stepNumber).addClass('show');
            $('#' + stepNumber).addClass('active');
            stepId = stepDto.id;
            getCurrentStep(stepNumber, stepDto);
        }
    });
}

// function disabledSteps(stepNumber) {
//     if()
// }

function getCurrentStep(StepNumber, StepDto) {
    var stn = StepNumber;
    var stDTO = StepDto;
    if (stn == 'STEP_1') {
        step1(stDTO);
    }
    if (stn == 'STEP_2') {
        step2(stDTO);
    }
    if (stn == 'STEP_3') {
        step3(stDTO, id);
    }
    if (stn == 'STEP_4') {

    }
    if (stn == 'STEP_5') {
        step5(stDTO);
    }
    if (stn == 'STEP_6') {
        step6(stDTO);
    }
    if (stn == 'STEP_7') {
        step7(stDTO);
    }
    if (stn == 'STEP_8') {

    }
}


function getStepType(stepNumber, stepDto) {
    let tabList = $('#tabList_' + stepNumber + '');
    let tabContent = $('#tabContent_' + stepNumber + '');
    tabList.html('');
    tabContent.html('');

    $.each(stepDto.tasks, function (key, value) {
            if (value.name !== null) {
                tabList.append(
                    '<a class="nav-link" data-toggle="pill" href="#task3_' + value.id + '" role="tab" aria-controls="v-pills-home" aria-selected="true">\n' +
                    value.name + '<input type="checkbox" id="t_toggle_' + value.id + '"' +
                    '                                       data-toggle="toggle" data-size="xs" data-on=" " data-off=" "' +
                    '                                       data-onstyle="success" data-offstyle="light" data-style="ios"></a>');
                if (value.taskStatus == 'DONE') {
                    $('#t_toggle_' + value.id).bootstrapToggle('on');
                } else {
                    $('#t_toggle_' + value.id).bootstrapToggle('of');
                }
                tabContent.append(
                    ' <div class="tab-pane fade" id="task3_' + value.id + '_" role="tabpanel" aria-labelledby="v-pills-home-tab">\n' +
                    '<h5>Описание:</h5><h5>\n' + value.description + '</h5><br></div>');
                if (stepNumber == 'STEP_1') {
                    step1(stepDto);
                }
                if (stepNumber == 'STEP_2') {
                    step2(stepDto);
                }
                if (stepNumber == 'STEP_3') {
                    step3(stepDto);
                }
                if (stepNumber == 'STEP_4') {

                }
                if (stepNumber == 'STEP_5') {

                }
                if (stepNumber == 'STEP_6') {

                }
                if (stepNumber == 'STEP_7') {
                    step7(stepDto);
                }
                if (stepNumber == 'STEP_8') {

                }

                $('#task3_' + value.id + '_').append(
                    '<label for="comment" id="commentId" data-comment="' + value.id + '" class="h6">Комментарий:</label>\n' +
                    '<textarea class="form-control" id="commentArea' + value.id + '_" rows="5"></textarea>' +
                    '<a class="btn btn-warning" onclick="saveComment()">Отправить</a>'
                );
            }
        }
    );
    tabList.append(
        '<a class="nav-link" id="nav-link-step3" data-toggle="pill" onclick="show_add_task_modal()" role="tab" aria-controls="v-pills-home" aria-selected="true">Добавить задачу</a>');
    fillToggles();
}


function show_add_task_modal() {
    $('#add_task_modal').modal('show');
}

function add_task() {
    let name = $('#name_of_task').val();
    let desc = $('#description_of_task').val();
    var taskVal = {
        'name': name,
        'description': desc
    };

    $.ajax({
        type: 'POST',
        url: "/api/tasks/add?step_id=" + stepId,
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(taskVal),
        success: function (task) {
            alert("Задача добавлена");

            $('#nav-link-step3').html('');

            $('#tabListStep3').append(
                '<a class="nav-link" data-toggle="pill" href="#task3_' + task.id + '" role="tab" aria-controls="v-pills-home" aria-selected="false">\n' +
                task.name + '<input type="checkbox" id="t_toggle_' + value.id + '"' +
                '                                                       data-toggle="toggle" data-size="xs" data-on=" " data-off=" "' +
                '                                                       data-onstyle="success" data-offstyle="light" data-style="ios"></a>');

            $('#tabListStep3').append(
                '<a class="nav-link" id="nav-link-step3" data-toggle="pill" onclick="show_add_task_modal()" role="tab" aria-controls="v-pills-home" aria-selected="true">Добавить задачу</a>');

            $('#tabContentStep3').append(
                ' <div class="tab-pane fade" id="task3_' + task.id + '" role="tabpanel" aria-labelledby="v-pills-home-tab">\n' +
                '<h5>Описание:</h5><h5>\n' + task.description + '</h5><br></div>');
        },
        error: function () {
            alert("Задача не добавлена");
        }
    });
}

function saveComment() {
    let com = document.getElementById('commentId');
    let comId = com.dataset.comment;
    let comment = $('#commentArea' + comId).val();
    $.ajax({
        type: 'POST',
        url: "/api/tasks/" + comId + "/comment",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(comment),
        success: function (task) {

        }
    });
}
