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
            
            petition.forEach(petition => {
                petition.userList.forEach(user=>{
                     name = user.name;


                });

               template+='<div class="col-sm-4">' +
                   '<div class="card shadow bg-white rounded" style="margin-top: 15px">' +
                   '<div class="card-header">Заявка</div>' +
                '<div class="card-body">Дата поступления заявки:' +
                   '<h5 id="2">'+ petition.data +'' +
                   '</h5>Адрес:<h5 id="3">'+ petition.adress + '' +
                   '</h5> Район:<h5 id="4">' + petition.area + '' +
                   '</h5>Имя юзера<h5 id="5">' + name + '' +
                   '</h5> <button>Подать заявку</button> </div></div></div>'
                $("#cardes").html(template);
            });
        }
    })};