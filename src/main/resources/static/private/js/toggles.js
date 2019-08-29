function switchToggles() {
    $('[id ^= \"t_toggle_\"]').each(function (i, el) {
        let task = getTaskById(el.id.substring(el.id.lastIndexOf("_") + 1));
        if(task.taskStatus === 'DONE') {
            $('#'+el.id).bootstrapToggle('on');
        }
    });
}

function fillToggles() {
    $('[id ^= \"t_toggle_\"]').change(function (e) {
        let taskId = e.target.id.substr(e.target.id.lastIndexOf('_') + 1);
        $.ajax({
            url: "/api/tasks/change_status/",
            type: "POST",
            async: false,
            data: ({id: taskId}),
            success: {
            }
        });
    });
}

function initStaticToggles() {
    let prefixToggle = 't_toggle_';
    let projectId = $("#projectId").val();
    let t_1_1 = getStaticTask(projectId, 'STEP_1', 'PETITIONER_INFO');
    let t_1_2 = getStaticTask(projectId, 'STEP_1', 'OLD_CONTAINER_PHOTO');
    let t_2_1 = getStaticTask(projectId, 'STEP_2', 'MANAGING_ORGANIZATION_INFO');
    let t_3_1 = getStaticTask(projectId, 'STEP_3', 'CONTRACTOR_INFO');
    let t_4_1 = getStaticTask(projectId, 'STEP_4', 'OFFER');
    let t_5_1 = getStaticTask(projectId, 'STEP_5', 'NEW_CONTAINER_INFO');
    let t_6_1 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_DESIGN');
    let t_6_2 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_PRINT');
    let t_6_3 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_PUBLICATION');
    let t_6_4 = getStaticTask(projectId, 'STEP_6', 'RESIDENTS_ACTIVITIES');
    let t_7_1 = getStaticTask(projectId, 'STEP_7', 'CASE_DESCRIPTION');
    // let t_7_1 = getStaticTask(projectId, 'STEP_7', 'CASE_DESCRIPTION'); //TODO 8 STEP

    $("#task_1_1_toggle").attr('id', prefixToggle + t_1_1.id);
    $("#task_1_2_toggle").attr('id', prefixToggle + t_1_2.id);
    $("#task_2_1_toggle").attr('id', prefixToggle + t_2_1.id);
    $("#task_3_1_toggle").attr('id', prefixToggle + t_3_1.id);
    $("#task_4_1_toggle").attr('id', prefixToggle + t_4_1.id);
    $("#task_5_1_toggle").attr('id', prefixToggle + t_5_1.id);
    $("#task_6_1_toggle").attr('id', prefixToggle + t_6_1.id);
    $("#task_6_2_toggle").attr('id', prefixToggle + t_6_2.id);
    $("#task_6_3_toggle").attr('id', prefixToggle + t_6_3.id);
    $("#task_6_4_toggle").attr('id', prefixToggle + t_6_4.id);
    $("#task_7_1_toggle").attr('id', prefixToggle + t_7_1.id);
    // $("#task_6_4_toggle").attr('id', prefixToggle + t_6_4.id); //TODO 8 STEP
}

function getTaskById(id) {
    let task;
    $.ajax({
        url: "/api/tasks/get/",
        type: "POST",
        async: false,
        data: ({id: id}),
        success: function (t) {
            task = t;
        }
    });
    return task;
}

function getStaticTask(projectId, stepNumber, taskType) {
    let task;
    $.ajax({
        url: "/api/tasks/distinct/",
        type: "POST",
        async: false,
        data: ({projectId: projectId, stepNumber: stepNumber, taskType: taskType}),
        success: function (t) {
            task = t;
        }
    });
    return task;
}