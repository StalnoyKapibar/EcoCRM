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
    $("#name").text(currentUser.name);
    $("#surname").text(currentUser.surname);
    $("#userId").text(currentUser.id);
    $("#patronymic").text(currentUser.patronymic);
    $("#email").text(currentUser.email);
    $("#phone").text(currentUser.phone);
    $("#vk").text(currentUser.link);
    $("#profession").text(currentUser.profession);
    $("#status").text(currentUser.status);
    $("#notToDo").text(currentUser.notToDo);
    var helpTag = document.getElementById('photo');
    helpTag.insertAdjacentHTML('afterend','<img src="data:image/png;base64,' + currentUser.photo + '" style="margin: 20px;" height="300" alt="profile image" id = "profile_avatar" >');
    getProjectsManager(id);
    getProjectsVolunteer(id);
    getPhoto(id);
    //$('#photo').attr("src","/api/user/photo/" + user.id);
}
