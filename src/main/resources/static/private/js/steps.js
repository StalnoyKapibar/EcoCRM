function addListeners() {
    $("input").change(function (e) {
        let prefix = 't_toggle_';
        let test = $('[id ^= "t_toggle_"]');
        if(e.target.id.startsWith(prefix)) {
            let taskId = e.target.id.substr(e.target.id.lastIndexOf('_') + 1);
            $.ajax({
                url: "/api/tasks/change_status/",
                type: "POST",
                async: false,
                data: ({id: taskId}),
                success: function () {
                }
            });
        }
    })
}

function get_static_task(projectId, stepNumber, taskType) {
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

function step_6_fill_toggles() {
    let t_6_1 = get_static_task(projectId, 'STEP_6', 'LEAFLETS_DESIGN');
    let t_6_2 = get_static_task(projectId, 'STEP_6', 'LEAFLETS_PRINT');
    let t_6_3 = get_static_task(projectId, 'STEP_6', 'LEAFLETS_PUBLICATION');
    let t_6_4 = get_static_task(projectId, 'STEP_6', 'RESIDENTS_ACTIVITIES');

    if (t_6_1.taskStatus == 'DONE') {
        $("#task_6_1_toggle").bootstrapToggle('on');
    }
    if (t_6_2.taskStatus == 'DONE') {
        $("#task_6_2_toggle").bootstrapToggle('on');
    }
    if (t_6_3.taskStatus == 'DONE') {
        $("#task_6_3_toggle").bootstrapToggle('on');
    }
    if (t_6_4.taskStatus == 'DONE') {
        $("#task_6_4_toggle").bootstrapToggle('on');
    }
    let prefix = 't_toggle_';
    $("#task_6_1_toggle").attr('id', prefix + t_6_1.id);
    $("#task_6_2_toggle").attr('id', prefix + t_6_2.id);
    $("#task_6_3_toggle").attr('id', prefix + t_6_3.id);
    $("#task_6_4_toggle").attr('id', prefix + t_6_4.id);
    addListeners();
}
