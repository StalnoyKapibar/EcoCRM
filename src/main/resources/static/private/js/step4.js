$(document).ready(function () {
    $('#STEP_4_togle').change(function () {
        if($(this).prop('checked')===true){
            $('#STEP_5_link').removeClass('disabled');
            $('#STEP_5_link').removeAttr('style');
            $('#STEP_4_link').css({'background-color': '#e0f3df', 'color': '#8fb78d', 'border': '1px solid ', 'border-color':'#7e8c78'});
        }
        if($(this).prop('checked')===false){
            $('#STEP_4_link').nextAll('.nav-link').css({'background-color': '#d2d2d2', 'color': '#a49f9f', 'border': '1px solid', 'border-color':'#8d8787'});
            $('#STEP_4_link').nextAll('.nav-link').addClass('disabled');
            $('#STEP_4_link').removeAttr('style');
        }
    })
});