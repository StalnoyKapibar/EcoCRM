$(document).ready(function () {
    $.ajax({
        url: "/api/user/get_current_user",
        type: "POST",
        async: false,
        success: function (user) {
            //$('#photo').attr("src","/api/user/photo/" + user.id);
            $("#name").text(user.name);
            $("#surname").text(user.surname);
            $("#userId").text(user.id);
            $("#patronymic").text(user.patronymic);
            $("#email").text(user.email);
            $("#phone").text(user.phone);
            $("#vk").text(user.link);
            $("#profession").text(user.profession);
            $("#status").text(user.status);
            $("#notToDo").text(user.notToDo);
            getProjectsManager(id);
            getProjectsVolunteer(id);
            getPhoto(id);
        }
    });
});


function getUser(id) {
    $.ajax({
        url: "/api/user/" + id,
        type: "GET",
        async: false,
        success: function (user) {
            //$('#photo').attr("src","/api/user/photo/" + user.id);
            $("#name").text(user.name);
            $("#surname").text(user.surname);
            $("#userId").text(user.id);
            $("#patronymic").text(user.patronymic);
            $("#email").text(user.email);
            $("#phone").text(user.phone);
            $("#vk").text(user.link);
            $("#profession").text(user.profession);
            $("#status").text(user.status);
            $("#notToDo").text(user.notToDo);
            getProjectsManager(id);
            getProjectsVolunteer(id);
            getPhoto(id);
        }
    });
}

function getPhoto(id) {
    $.ajax({
        url: "/api/user/photo/" + id,
        type: "GET",
        async: false,

        success: function (photo) {
            $("#profile_avatar").remove();
            var helpTag = document.getElementById('photo');
            helpTag.insertAdjacentHTML('afterbegin','<img src="data:image/png;base64,' + photo + '" class="img-rounded" alt="profile image" id = "profile_avatar" >');
        },
        error: function(error) {
            console.error('problem with load photo', error);
        }
    });
}

function getProjectsManager(id) {
    $.ajax({
        url: "/api/user/projects/manager/" + id,
        type: "GET",
        async: false,
        success: function (project) {
            $("#projManager").html("");
            $.each(project, function(index) {
                $('#projManager').append("<p><a href='/steps/" + project[index].id + "'>" + project[index].petition.adresHome + "</a></p>");
                console.log(index.title);
            });

        }
    });
}

function getProjectsVolunteer(id) {
    $.ajax({
        url: "/api/user/projects/volunteer/" + id,
        type: "GET",
        async: false,
        success: function (project) {
            $("#projVolunteer").html("");
            $.each(project, function(index) {
                $('#projVolunteer').append("<p><a href='/steps/" + project[index].id + "'>" + project[index].petition.adresHome + "</a></p>");
                console.log(index.title);
            });
        }
    });
}

function blockUser() {
    var userId = $('#userId').text();
    $.ajax({
        url: "/api/user/block?id=" + userId,
        type: "POST",
        async: false,
        success: function (address) {
            window.location.href = address;
            //$("#unblock-btn").prop('disabled', false);
            //$("#block-btn").prop('disabled', true);
        },
        error: function(error) {
            console.error('problem with blocking', error);
        }
    });
}

function unblockUser() {
    var userId = $('#userId').text();
    $.ajax({
        url: "/api/user/unblock?id=" + userId,
        type: "POST",
        async: false,
        success: function (address) {
            window.location.href = address;
            //$('#block-btn').prop('disabled', false);
            //$('#unblock-btn').prop('disabled', true);
        },
        error: function(error) {
            console.error('problem with unblocking', error);
        }
    });
}

function sendReg() {
    var email = $('#email_input').val();
    $.ajax({
        url: "/processSendForm?userEmail=" + email,
        type: "GET",
        async: false,
        success: function() {
            console.log("Mail was sent.");
        },
        error: function() {
            console.error("Error: mail wasn't sent!");
        }
});
}