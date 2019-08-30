function fillPage(apiUrl){
    jQuery.noConflict();
    var currentUser = getCurrentUser();
    var allSteps = ["1. Заявитель", "2. Управляющая компания", "3. Заготовители", "4. Заключение договора","5. Установка контейнера","6. Работа с жителями","7. Описание кейса","8. Контроль"];
    $.ajax({
        url: apiUrl,
        type: "GET",
        async: false,
        success: function (projects) {
            let listRequest;
            $.ajax({
                url: "/api/request/getAll",
                type: "GET",
                async: false,
                success: function (list) {
                    listRequest = list;
                }
            });

            let count = 0;
            let docVar = '';
            let rgbaColor = .1;
            $.each(projects, function (key, value) {
                docVar += '<div class="col-12 col-sm-6 col-md-6 col-lg-3 col-xl-2">' +
                    '                <div class="eco-column-header-extras">' +
                    '                    <p class="text-justify" style="margin-left: 3px;font-weight: bold">'+allSteps[count] + '</p>' +
                    '                </div>' +
                    '            <div class="eco-col card" id="col_' + count + '" style="max-height:33rem;min-height:4rem;overflow:auto;background-color: #F5F5F5">';
                $.each(value, function (i, project) {
                    docVar += '<div class="eco-card card m-2" style="min-height:210px;box-shadow:0px 5px 9px -8px #000000;">' +
                        '                            <div class="card-header" style="background-color:rgba(84,182,137,' + rgbaColor + ');font-size:medium">' + project.petition.addressHome + '</div>' +
                        '                            <div class="card-body">' +
                        '                            <div class="card-text house-area">' + project.petition.houseDistrict + '</div>';
                    var memberFlag = false;
                    for(let i = 0; i < project.users.length;i++){
                        if(project.users[i].id === currentUser.id){
                            memberFlag = true;
                        }
                    }

                    if(currentUser.id != project.manager.id && memberFlag === false){
                            var flag = false;
                            for (let i = 0; i < listRequest.length; i++) { // выведет 0, затем 1, затем 2
                                if(listRequest[i].personId === currentUser.id && listRequest[i].projectId === project.id){
                                    flag = true;
                                }
                            }
                            if(flag === false){
                                docVar+='                            <div class="card-text accept-button"><button type="button" class="btn yellow-btn btn-sm" onclick="sendRequest('+project.id+')" style="margin: 10px;">Участвовать</button></div>';
                            } else {
                                docVar+='                            <div class="card-text accept-button"><button type="button" class="btn btn-secondary btn-sm" style="margin: 10px;">Отправлено</button></div>';
                            }

                        }

                        docVar += '                            </div>' +
                            '<div style="display: inline">' +
                        '<button type="button" class="member" style="background-color: rgba(84,182,137,0.74);" data-toggle="popover" data-placement="bottom" title="Менеджер" data-content="'+project.manager.name+' ' + project.manager.surname +'">' + project.manager.name.charAt(0) + project.manager.surname.charAt(0) + '</button>';
                        if(project.users.length > 0){
                            docVar+='<button type="button" class="member" data-toggle="popover" data-placement="bottom" title="Участники" data-content="';
                            for(let i = 0; i < project.users.length;i++){
                                docVar+= project.users[i].name + ' ' +project.users[i].surname + '\n';
                            }

                            docVar+='">+' + project.users.length + '</button>';
                        }

                        docVar+='     </div>'+
                        '</div>';
                });
                rgbaColor += .1;
                docVar += '</div> </div>';
                count++;
            });
            $("#projectsTable").html(docVar);        }
    });
    $('[data-toggle="tooltip"]').tooltip();
    $('[data-toggle="popover"]').popover();
}

function sortByArea(areaName) {
    let list = document.getElementsByClassName('house-area');
    Array.prototype.forEach.call(list, function (el) {
        el.parentElement.parentElement.style.display='none';
        if(el.textContent === areaName || areaName === "Все районы") {
            el.parentElement.parentElement.style.display='inline';
        }
    });

}
function getCurrentUser() {
    let currUser;
    $.ajax({
        url: "/api/user/get_current_user",
        type: "GET",
        async: false,
        success: function (user) {
            currUser = user;
        }
    });
    return currUser;
}
function sendRequest(project_id) {
    $.ajax({
        url: "/api/request/add/"+project_id,
        type: "GET",
        async: false,
        success: function (redirect) {
            window.location.href = redirect;
        }
    });
}

//
// $(document).ready(function() {
//     document.body.style.overflow = 'hidden';
// });
