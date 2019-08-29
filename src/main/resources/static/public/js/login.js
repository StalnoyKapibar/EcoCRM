function auth() {
    var email = $('#email-place').val();
    var pass = $('#password-place').val();
    var dataForLogin = "email"  +"="+email +"&" + "password" + "=" + pass;
    var response = $.ajax({
        type: 'POST',
        url: '/authenticateTheUser',
        //url: 'http://localhost:8080/test',
        data: dataForLogin,
        complete: function (resp) {
            var goTo = resp.getResponseHeader("redirect");
            if(goTo != null) {
                window.location.href = goTo;
            }
        },
        error: function (error) {
            if(document.getElementById('error-message') === null && error.status != 200) {
                var d1 = document.getElementById('password-place');
                d1.insertAdjacentHTML('afterend', '<p id="error-message">Неверный логин или пароль</p>'+
                '<p><a href="/recovery">Забыли пароль?</a></p>');
            }
        },
        dataType: 'application/x-www-form-urlencoded'
    });
}

addEventListener("load", function() {
    setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){
    window.scrollTo(0,1);
}