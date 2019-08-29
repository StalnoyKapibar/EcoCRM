$(document).ready(function () {
    $('#STEP_6_togle').change(function () {
        if($(this).prop('checked')===true){
            $('#STEP_7_link').removeClass('disabled');
            $('#STEP_7_link').removeAttr('style');
            $('#STEP_6_link').css({'background-color': '#e0f3df', 'color': '#8fb78d', 'border': '1px solid ', 'border-color':'#7e8c78'});
        }
        if($(this).prop('checked')===false){
            $('#STEP_6_link').nextAll('.nav-link').css({'background-color': '#d2d2d2', 'color': '#a49f9f', 'border': '1px solid', 'border-color':'#8d8787'});
            $('#STEP_6_link').nextAll('.nav-link').addClass('disabled');
            $('#STEP_6_link').removeAttr('style');
        }
    })
});

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