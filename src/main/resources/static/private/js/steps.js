function initToggles() {
    initStaticToggles();
}

function fillToggles() {
    let toggles = $('[id ^= "t_toggle_"]');
    toggles.each(function (i, el) {
        let task = getTaskById(el.id.substring(el.id.lastIndexOf("_") + 1));
        if(task.taskStatus == 'DONE') {
            $('#'+el.id).bootstrapToggle('on');
        }
    });

    toggles.change(function (e) {
        let prefix = 't_toggle_';
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
    let t_6_1 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_DESIGN');
    let t_6_2 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_PRINT');
    let t_6_3 = getStaticTask(projectId, 'STEP_6', 'LEAFLETS_PUBLICATION');
    let t_6_4 = getStaticTask(projectId, 'STEP_6', 'RESIDENTS_ACTIVITIES');

    $("#task_6_1_toggle").attr('id', prefixToggle + t_6_1.id);
    $("#task_6_2_toggle").attr('id', prefixToggle + t_6_2.id);
    $("#task_6_3_toggle").attr('id', prefixToggle + t_6_3.id);
    $("#task_6_4_toggle").attr('id', prefixToggle + t_6_4.id);
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
