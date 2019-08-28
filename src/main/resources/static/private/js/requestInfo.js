$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "/api/request/getMy",
        success: function (requestList) {

            //forRequest
            var helpTag = document.getElementById('forRequest');
            for (let i = 0; i < requestList.length; i++) { // выведет 0, затем 1, затем 2
                helpTag.insertAdjacentHTML('afterend',
                    '<div class="alert alert-primary" role="alert">\n' +
                    '            Запрос на участие в проекте по адресу:\n'+requestList[i].projectName+' от '+ requestList[i].personName +
                    '            <p></p>\n' +
                    '            <a type="button" class="btn btn-success" onclick="accept('+requestList[i].id+')" >Принять</a>\n' +
                    '            <a type="button" class="btn btn-danger" onclick="decline('+requestList[i].id+')" >Отклонить</a>\n' +
                    '        </div>'
                );
            }
        }
    });


});
function accept(id) {
    //href="/api/request/accept"
    $.ajax({
        type: 'GET',
        url: "/api/request/accept/" + id,
        success: function (redirect) {
            window.location.href = redirect;
        }
    });
}
function decline() {
    //href="/api/request/decline"
    $.ajax({
        type: 'GET',
        url: "/api/request/decline/" + id,
        success: function (redirect) {
            window.location.href = redirect;
        }
    });
}

