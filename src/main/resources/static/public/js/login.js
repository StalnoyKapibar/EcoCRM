function auth() {
    var dataForLogin =
        "email"  +"="+$('#email-place').val() +"&" + "password" + "=" +$('#password-place').val();
    var response = $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/authenticateTheUser',
        //url: 'http://localhost:8080/test',
        data: dataForLogin,
        complete: function (resp) {
            var goTo = resp.getResponseHeader("redirect");
            if(goTo != null) {
                window.location.href = goTo;
            }
        },
        error: function (error) {
            if(document.getElementById('error-message') === null) {
                var d1 = document.getElementById('password-place');
                d1.insertAdjacentHTML('afterend', '<p id="error-message">Неверный логин или пароль</p>');
            }
        },
        dataType: 'application/x-www-form-urlencoded'
    });
}