$(document).ready(function () {
    $('#appoint_meeting_peeker').datepicker({
        uiLibrary: 'bootstrap4',
        format: "dd/mm/yyyy"
    });

    $('#STEP_3_togle').change(function () {
        if($(this).prop('checked')===true){
            $('#STEP_4_link').removeClass('disabled');
            $('#STEP_4_link').removeAttr('style');
            $('#STEP_3_link').css({'background-color': '#e0f3df', 'color': '#8fb78d', 'border': '1px solid ', 'border-color':'#7e8c78'});        }
        if($(this).prop('checked')===false){
            $('#STEP_3_link').nextAll('.nav-link').css('.nav-link').css({'background-color': '#d2d2d2', 'color': '#a49f9f', 'border': '1px solid', 'border-color':'#8d8787'});
            $('#STEP_3_link').nextAll('.nav-link').addClass('disabled');
            $('#STEP_3_link').removeAttr('style');
        }
    })
});


function addContractor() {
    let name = $("#name").val();
    let row = $("#rowType").val();
    let link = $("#link").val();
    let contact = $("#contactPerson").val();
    let phone = $("#phoneNumber").val();
    let person = $("#linkByPerson").val();
    let collector = $("#collectorType").val();
    let description = $("#description").val();


    var contractor = {
        'name': name,
        'rowType': row,
        'link': link,
        'contactPerson': contact,
        'phoneNumber': phone,
        'linkByPerson': person,
        'collectorType': collector,
        'description': description
    };

    $.ajax({
        type: 'POST',
        url: "/api/contractor/new",
        data: JSON.stringify(contractor),
        contentType: "application/json; charset=utf-8",
        success: function () {
            alert("Заготовитель добавлен");
            $('#buttonModal').click();
        }
    })
}

function step3(stepDto, projectId) {
    addMeetings(projectId);
            $.each(stepDto.contractors, function (key, company) {
                $('#tableCompany').append(
                    '<div class="accordion" id="accordionExample">\n' +
                    '  <div class="card">\n' +
                    '    <div class="card-header" id="headingOne">\n' +
                    '      <h2 class="mb-0">\n' +
                    '        <button style="color: black" class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse'+company.id+'" aria-expanded="true" aria-controls="collapseOne">\n' +
                    company.name + '<button style="float: right; margin-right: 5px" class="btn btn-warning" data-toggle="modal" data-target="#show_contractor_modal" onclick="getInfo(' + company.id + ')">Info</button>' +
                    '        </button>\n' +
                    '<button style="float: right; margin-right: 5px" class="btn btn-warning" data-toggle="modal" data-target="#add_data" onclick="addData(' + company.id + ')" id="date_meet_' + company.id + '">Назначить встречу</button>' +
                    '<span id="data_' + company.id + '"></span>' +
                    '      </h2>\n' +
                    '    </div>\n' +
                    '    <div id="collapse'+company.id+'" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">\n' +
                    '      <div class="card-body">\n' +
                    '<div class="row"> ' +
                    '<div class="col-6"> ' +
                    '<h6>Комментарии:</h6>' +
                    '        <div id="commentText'+company.id+'"></div>' +
                    '        <div id="commentTextArea'+company.id+'"></div>' +
                    '</div> ' +
                    '<div class="col-6"> ' +
                    '<div id="meet_new_' + company.id + '"></div>' +
                    '</div> ' +
                    '    </div> ' +
                    '      </div>\n' +
                    '    </div>\n' +
                    '  </div>\n' +
                    '</div>')

                $.each(company.comments, function (key, comment) {
                    $('#commentText' + company.id + '').append(
                        '<h6>' + comment.message + '</h6>'
                    )
                });
                $('#commentTextArea' + company.id + '').append(
                    '<textarea class="form-control" type="text" placeholder="Оставить комментарий" id="textComment' + company.id + '"></textarea><br/>' +
                    '<a class="btn btn-secondary" onclick="saveComment(' + company.id + ')">Отправить</a>'
                )
            });

}

function saveComment(id) {
    let comment = $("#textComment"+id+"").val();
    $.ajax({
        type: 'POST',
        url: "/api/contractor/"+id+"/comment",
        data: JSON.stringify(comment),
        contentType: "application/json; charset=utf-8",
        success: function () {
            alert("Комментарий добавлен");
            $('#commentText' + id + '').append(
                '<h6>' + comment + '</h6>'
            )
            $("#textComment"+id+"").val('');
        }
    })
}


function getInfo(id) {
    $.ajax({
        url: "/api/contractor/" + id,
        type: "GET",
        async: false,
        success: function (data) {
            $("#show_name").text(data.name);
            $("#show_rowType").text(data.rowType);
            $("#show_link").text(data.link);
            $("#show_contactPerson").text(data.contactPerson);
            $("#show_phoneNumber").text(data.phoneNumber);
            $("#show_linkByPerson").text(data.linkByPerson);
            $("#show_collectorType").text(data.collectorType);
            $("#show_description").text(data.description);
        }
    });
}

function addData(id) {
    $('#date_id_modal').val(id);
}

function saveData( ) {
    let id = $('#date_id_modal').val();
    let data = $('#appoint_meeting_peeker').val();
    $.ajax({
        type: 'POST',
        url: "/api/meeting/"+id+"/data/"+projectId,
        data: data,
        contentType: "application/json; charset=utf-8",
        success: function (meeting) {
            $('#data_' + id +'').append(
                '<h6>Встреча назначена на:</h6><h6>' + meeting.dateTime + '</h6>'
            );
            alert("Встреча добавленa : "  + meeting.dateTime);
            $('#add_buttonModal').click();
        }
    })
}

function addMeetings(projectId) {
    $.ajax({
        url: "/api/meeting/contractor/" + projectId,
        type: "GET",
        async: false,
        success: function (meetings) {
            console.log(meetings);
            $.each(meetings, function (key, meet) {
                document.getElementById('meet_new_' + meet.contractor.id).insertAdjacentHTML("beforeend",
                    '<h6>Встреча назначена на:</h6><h6 style="color: #f71752;">' + meet.dateTime + '</h6>'
                );
                $('#date_meet_' + meet.contractor.id +'').remove();
            })
        }
    });
}
