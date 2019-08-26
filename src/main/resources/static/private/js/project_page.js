let id;
let stepId;
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

            getStepType(stepNumber, stepDto);

        }
    });
};

function getStepType(stepNumber, stepDto) {
    let tabList =  $('#tabList_'+stepNumber+'');
    let tabContent = $('#tabContent_'+stepNumber+'');
    tabList.html('');
    tabContent.html('');

    $.each(stepDto.tasks, function (key, value) {
        if (value.name !== null) {
            tabList.append(
                '<a class="nav-link" data-toggle="pill" href="#task3_' + value.id + '" role="tab" aria-controls="v-pills-home" aria-selected="true">\n' +
                value.name + '<input type="checkbox" id="t_toggle_"' + value.id + '\n' +
                '                                       data-toggle="toggle" data-size="xs" data-on=" " data-off=" "\n' +
                '                                       data-onstyle="success" data-offstyle="light" data-style="ios"></a>');

            tabContent.append(
                ' <div class="tab-pane fade" id="task3_' + value.id + '" role="tabpanel" aria-labelledby="v-pills-home-tab">\n' +
                '<h5>Описание:</h5><h5>\n' + value.description + '</h5><br></div>');
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
    }
)
    $('#tabListStep3').append(
        '<a class="nav-link" id="nav-link-step3" data-toggle="pill" onclick="show_add_task_modal()" role="tab" aria-controls="v-pills-home" aria-selected="true">Добавить задачу</a>');
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
                task.name + '<input type="checkbox" id="t_toggle_"' + value.id +
                '                                                       data-toggle="toggle" data-size="xs" data-on=" " data-off=" "' +
                '                                                       data-onstyle="success" data-offstyle="light" data-style="ios"</a>');

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
