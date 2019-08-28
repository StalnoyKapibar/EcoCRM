// function addUserToPetition(id) {
//     $.ajax({
//         type: 'put',
//         url: '/api/petition/addPetitionUser?id='+id,
//         async: false,
//         success:function () {
//             alert("ВЫ ДОБАВИЛИ ЧТО ТО ТАМ")
//             $('#'+id+'_remove_btn').remove("");
//             },
//     });
// }

petition = {
        test: $('form input[name="email"]').val(),
        userName: $('form input[name="userName"]').val(),
        contactInformation: $('form input[name="contactInfo"]').val(),
        petitionerType: $('form input[name=statusHome]:checked').val(),
        activityType: $('form input[name=activityType]:checked').val(),
        typeOfRawMaterial: $('form input[name=typeOfRawMaterial]:checked'),
        addressHome: $('form input[name=addressHome]:checked').val(),
        houseDistrict: $('form select[name=houseDistrict] option:selected').val(),
        flatsCount: $('form input[name=flatsCount]').text(),
        managementCompanyType: $('form input[name=manag_comp_type]:checked').val(),
        availableCouncil: $('form input[name=availableCouncil]:checked').val(),
        managementOrganizationRelation: $('form input[name=managementOrganizationRelation]:checked').val(),
        managementCompanyContacts: $('form input[name=managementCompanyContacts]').val(),
        additionalInformation: $('form input[name=additionalInformation]').val(),
        containerAvailable: $('form input[name=containerAvailable]').val(),
        containerSize: $('form input[name=containerSize]').val(),
        containerOwner: $('form input[name=containerOwner]').val(),
        garbageAvailable: $('form input[name=garbageAvailable]').val(),
        exportGarbage: $('form input[name=exportGarbage]').val(),
        agreement: $('form input[name=agreement]').val()
};



let sendPetition = function() {
    console.log('asds');
    let header = $("meta[name='_csrf_header']").attr("content");
    let token = $("meta[name='_csrf']").attr("content");

    $.ajax({
        type: 'POST',
        url: '/api/petition',
        data: JSON.stringify(petition),
        contentType: 'application/json; charset:utf-8',
        dataType: 'json',
        async: false,
        beforeSend: function (request) {
            return request.setRequestHeader(header, token);
        }
    })
};


$('#petition_form').on('submit',function () {
    console.log('sdfsdf');
});


