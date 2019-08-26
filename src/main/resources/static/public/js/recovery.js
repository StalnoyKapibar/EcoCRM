function recovery() {
    var email = $('#email-place').val();
    var dataForRecovery = "email"  +"="+email;
    var response = $.ajax({
        type: 'POST',
        url: '/recovery',
        data: dataForRecovery,
        complete: function (resp) {
            // var goTo = resp.getResponseHeader("redirect");
            // if(goTo != null) {
            //     window.location.href = goTo;
            // }
            if(resp.responseText === 'recovered'){
                if(document.getElementById('succes-message') === null) {
                    var button = document.getElementById('accept-button');
                    button.style.display = 'none';

                    var d1 = document.getElementById('email-place');
                    d1.insertAdjacentHTML('afterend', '<p id="succes-message">Ищите новый пароль на почте</p>'+
                        '<p><a id="enter-button" href="/">Войти</a></p>');
                }
            }
            if(resp.responseText === 'error'){
                if(document.getElementById('error-message') === null) {
                    var d1 = document.getElementById('email-place');
                    d1.insertAdjacentHTML('afterend', '<p id="error-message">Введите email, зарегистрированный в системе</p>');
                }
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