function step6(stepDto) {
    let tasks = stepDto.tasks;
    for(let i = 0; i<tasks.length; i++){
        let type = tasks[i].type;
        if (tasks[i].type === 'LEAFLETS_DESIGN'){
            $('#design_leflets_textarea').val(tasks[i].description);
            $('#task_6_1').append('<input type="hidden" id = "task_id_6_1" value="'+tasks[i].id+'">');
        }    if (tasks[i].type === 'LEAFLETS_PRINT'){
            $('#print_leflets_textarea').val(tasks[i].description);
            $('#task_6_2').append('<input type="hidden" id = "task_id_6_2" value="'+tasks[i].id+'">');
        }    if (tasks[i].type === 'LEAFLETS_PUBLICATION'){
            $('#publication_leflets_textarea').val(tasks[i].description);
            $('#task_6_3').append('<input type="hidden" id = "task_id_6_3" value="'+tasks[i].id+'">');
        }    if (tasks[i].type === 'RESIDENTS_ACTIVITIES'){
            $('#residents_activities_textarea').val(tasks[i].description);
            $('#task_6_4').append('<input type="hidden" id = "task_id_6_4" value="'+tasks[i].id+'">');
        }
    }
}

function save_task_6_1() {
    let taskId = $('#task_id_6_1').val();
    let taskDeskr = $('#design_leflets_textarea').val();
    let task = {
        'id': taskId,
        'description': taskDeskr
    };
    $.ajax({
        type: 'post',
        url: "/api/project/update_task",
        data: JSON.stringify(task),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (profile) {
            alert("Изменения успешно внесены")
        },
        error: function (error) {
            console.log(error);
            alert(error.responseText);
        }
    })
}

function save_task_6_2() {
    let taskId = $('#task_id_6_2').val();
    let taskDeskr = $('#print_leflets_textarea').val();
    let task = {
        'id': taskId,
        'description': taskDeskr
    };
    $.ajax({
        type: 'post',
        url: "/api/project/update_task",
        data: JSON.stringify(task),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (profile) {
            alert("Изменения успешно внесены")
        },
        error: function (error) {
            console.log(error);
            alert(error.responseText);
        }
    })
}

function save_task_6_3() {
    let taskId = $('#task_id_6_3').val();
    let taskDeskr = $('#publication_leflets_textarea').val();
    let task = {
        'id': taskId,
        'description': taskDeskr
    };
    $.ajax({
        type: 'post',
        url: "/api/project/update_task",
        data: JSON.stringify(task),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (profile) {
            alert("Изменения успешно внесены")
        },
        error: function (error) {
            console.log(error);
            alert(error.responseText);
        }
    })
}

function save_task_6_4() {
    let taskId = $('#task_id_6_4').val();
    let taskDeskr = $('#residents_activities_textarea').val();
    let task = {
        'id': taskId,
        'description': taskDeskr
    };
    $.ajax({
        type: 'post',
        url: "/api/project/update_task",
        data: JSON.stringify(task),
        dataType: "json",
        contentType: 'application/json; charset=utf-8',
        success: function (profile) {
            alert("Изменения успешно внесены")
        },
        error: function (error) {
            console.log(error);
            alert(error.responseText);
        }
    })
}