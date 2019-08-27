$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const emailParam = urlParams.get('email');
    //alert(myParam);
    $('#vk-button').attr('href','https://oauth.vk.com/authorize?client_id=7104443&display=page&redirect_uri=http://localhost:8080/registration/usercode?email='+emailParam+'&response_type=code&v=5.101');

});