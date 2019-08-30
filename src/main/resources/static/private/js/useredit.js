var currentUser;
$(document).ready(function () {
    currentUser = getCurrentUser();
    initTextArea();
});
function getCurrentUser() {
    let currUser;
    $.ajax({
        url: "/api/user/get_current_user",
        type: "GET",
        async: false,
        success: function (user) {
            currUser = user;
        }
    });
    return currUser;
}
function initTextArea() {
    $("#name").val(currentUser.name);
    $("#surname").val(currentUser.surname);
    $("#userId").val(currentUser.id);
    $("#patronymic").val(currentUser.patronymic);
    $("#password").val(currentUser.password);
    $("#email").val(currentUser.email);
    $("#phone").val(currentUser.phone);
    // $("#status").val(currentUser.status);
    $('#status_list input[value="'+currentUser.status+'"]').attr("checked", true);
    $("#vk").val(currentUser.link);
    $("#profession").val(currentUser.profession);
    var helpTag = document.getElementById('photo');
    helpTag.insertAdjacentHTML('afterend','<img src="data:image/png;base64,' + currentUser.photo + '" class="img-rounded  mb-3"   height="400"  width="400px" align="left" alt="profile image" id = "profile_avatar" >');
    $("#notToDo").val(currentUser.notToDo);
    //$('#photo').attr("src","/api/user/photo/" + user.id);
}
function updateUser() {
    var user = {
        'id' : $('#userId').val(),
        'name' : $('#name').val(),
        'surname' : $('#surname').val(),
        'patronymic' : $('#patronymic').val(),
        'email' : $('#email').val(),
        'phone' : $('#phone').val(),
        'link' : $('#vk').val(),
        'status' : $('#status_list input:checked').val(),
        'profession' : $('#profession').val(),
        'notToDo' : $('#notToDo').val(),
    };
    var email =  $("#email").val();
    var form = $('#imageUploadForm')[0];
    var data = new FormData(form);
    data.append("email", email);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/api/registration/update_image",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        complete: function () {
            /*
            $('#profile_img').html('<img src="data:image/png;base64,' + image + '" class="img-rounded"' +

                '                                     alt="profile image">');

            */
        },
        error: function (e) {
            console.log("ERROR : ", e.responseText);
        }
    });
    $.ajax({
        url: '/api/user/update',
        type: 'PUT',
        data:JSON.stringify(user),
        contentType: 'application/json; charset=utf-8',
        success: function (){
            // alert('Данные обновлены');
            window.location.href = '/userinfo'
        },
        error: function (e) {
            console.log(e.responseText);
        }
    })
}


$(function() {
    function readURL(input) {
        $(input.files).each(function(i, el) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('<img height="400px" width="400px" align="left"> ').attr('src', e.target.result).appendTo('#photo');
            };
            reader.readAsDataURL(input.files[i]);
        });
    }
    $("#customFile").change(function() {
        var photoWas = document.getElementById('profile_avatar');
        photoWas.style.display = 'none';
        readURL(this);


    });
});