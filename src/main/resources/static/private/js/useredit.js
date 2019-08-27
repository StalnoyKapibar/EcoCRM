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
    $("#vk").val(currentUser.link);
    $("#profession").val(currentUser.profession);
    var helpTag = document.getElementById('photo');
    helpTag.insertAdjacentHTML('afterend','<img src="data:image/png;base64,' + currentUser.photo + '" class="img-rounded" alt="profile image" id = "profile_avatar" >');
    $("#notToDo").val(currentUser.notToDo);
    //$('#photo').attr("src","/api/user/photo/" + user.id);
}
function updateUser() {
    var user = {
    'id' : $('#userId').val(),
    'name' : $('#name').val(),
    'password' : $('#password').val(),
    'surname' : $('#surname').val(),
    'patronymic' : $('#patronymic').val(),
    'email' : $('#email').val(),
    'phone' : $('#phone').val(),
    'link' : $('#vk').val(),
    'profession' : $('#profession').val(),
    'notToDo' : $('#notToDo').val(),
    'photo' : $('#photo').val()
    };
    $.ajax({
        url: '/api/user/update',
        type: 'PUT',
        data:JSON.stringify(user),
        contentType: 'application/json; charset=utf-8',
        success: function (){
            alert('Данные обновлены');
            window.location.href = '/userinfo'
        },
        error: function (e) {
            alert(e.responseText);
        }
    })
}


