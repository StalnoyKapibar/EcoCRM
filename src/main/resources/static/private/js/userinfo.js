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
    $("#password").text(currentUser.password);
    $("#patronymic").text(currentUser.patronymic);
    $("#email").text(currentUser.email);
    $("#phone").text(currentUser.phone);
    $("#vk").text(currentUser.link);
    $("#profession").text(currentUser.profession);
    $("#status").text(currentUser.status);
    $("#notToDo").text(currentUser.notToDo);
    getProjectsManager(id);
    getProjectsVolunteer(id);
    getPhoto(id);
    //$('#photo').attr("src","/api/user/photo/" + user.id);
}
