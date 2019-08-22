function getUser(id) {
    $.ajax({
        url: "/api/user/" + id,
        type: "GET",
        async: false,
        success: function (user) {
            $("#name").text(user.name);
            $("#surname").text(user.surname);
            $("#userId").text(user.id);
            $("#patronymic").text(user.patronymic);
            $("#email").text(user.email);
            $("#vk").text(user.link);
            $("#profession").text(user.profession);
            $("#status").text(user.status);
            $("#notToDo").text(user.notToDo);
            if (user.enabled) {
                $("#enabled").text("Доступен");
            } else {
                $("#enabled").text("Не доступен");
            }

            getProjects(id);
        }
    });

}


function getProjects(id) {
    $.ajax({
        url: "/api/user/projects/" + id,
        type: "GET",
        async: false,
        success: function (projects) {
            $("#projects").html("");
            $.each(projects, function(index) {
                //$("#projects").text(value.title);
                $('#projects').append("<p><a>" + projects[index].title + "</a></p>");
                console.log(index.title);
            });
        }
    });
}

function blockUser() {
    var userId = $('#userId').text();
    //var bt = document.getElementById('exampleModal');
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