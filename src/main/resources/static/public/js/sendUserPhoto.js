function send(){
    var person_name = $("#person-name").val();
    var person_surnam = $("#person-surname").val();
    var email =  $("#emailHelp").val();
    var password = $("#password").val();
    var phone = $("#phone").val();
    var vk_link = $("#vk_link").val();
    var job = $("#job").val();
    var notToDo = $("#notToDo").val();
    var jsonObj = {'name':person_name,'surname':person_surnam,
        'phone':phone,'email':email,'link':vk_link,
        'profession':job,'password':password,'notToDo':notToDo};
    $.ajax({
        type: 'POST',
        url: "/api/registration/new",
        data: JSON.stringify(jsonObj),
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        complete: function(json) {
            var form = $('#imageUploadForm')[0];
            var data = new FormData(form);
            data.append("email", email);
            $.ajax({
                type: "POST",
                enctype: 'multipart/form-data',
                url: "/api/registration/update_image",
                data: data,
                processData: false,
                contentType: false,
                beforeSend: function (request) {
                    //request.setRequestHeader(header, token);
                },
                cache: false,
                timeout: 600000,
                complete: function (redirectUrl) {
                    window.location.href = redirectUrl.responseText;
                    /*
                    $('#profile_img').html('<img src="data:image/png;base64,' + image + '" class="img-rounded"' +

                        '                                     alt="profile image">');

                    */

                },
                error: function (e) {
                    console.log("ERROR : ", e.responseText);
                }
            });
        },

    });
}