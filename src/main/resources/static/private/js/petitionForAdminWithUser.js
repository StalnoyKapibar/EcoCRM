$( document ).ready(function() {
    f();
})

function f() {
    $.ajax({
        url: "/api/petition/getAllAdminPetitionWithUserRest",
        type: "GET",
        async: false,
        success: function (petition) {
            var template = '';
            var name;
            var surname;
            var email;
            var  phone;
            var id;


            petition.forEach(petition => {
                petition.userList.forEach(user=>{
                     name = user.name;
                     surname = user.surname;
                     email = user.email;
                     phone = user.phone;
                     id = user.id;
                });

                template+='<div class="col-sm-4">' +
                   '<div class="card shadow bg-white rounded" style="margin-top: 15px">' +
                   '<div class="card-header">Заявка</div>' +
                   '<div class="card-body">Дата поступления заявки:' +
                   '<h5 id="2">'+ petition.data +'' +
                   '</h5>Адрес:<h5 id="3">'+ petition.adress + '' +
                   '</h5> Район:<h5 id="4">' + petition.area + '' +
                   '</h5>Имя юзера<h5 id="5">' + name + '' +
                   '</h5>Фамилия<h5 id="6">' + surname + '' +
                   '</h5>Емаил<h5 id="7">' + email + ''+
                   '</h5>Номер телефона<h5 id="8">' + phone + ''+
                   '<button class="button_b" onclick="approvedByAdministrator('+id+', '+petition.id+')" style="float: right">Одобрить заявку</button> </div></div></div>'
                $("#cardes").html(template);
            });
        }
    })};

function approvedByAdministrator(id,idp) {

    $.ajax({
        url: '/api/petition/approvedByAdministrator?id='+id +'&idp='+idp,
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        success: function (){

        },
        error: function (e) {
            alert(e.responseText);

        }

})}

