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


let sendPetition = function(event) {

};

// var header = $("meta[name='_csrf_header']").attr("content");
// var token = $("meta[name='_csrf']").attr("content");
$(document).ready(function() {
    $('#petition_form').submit(function (event) {
        let row_types = $('form input[name=typeOfRawMaterial]:checked').map(function () {
            return this.value;
        }).get();
        let petition = {
            'email': $('form input[name="email"]').val(),
            'userName': $('form input[name="userName"]').val(),
            'contactInformation': $('form input[name="contactInformation"]').val(),
            'petitionerType': $('form input[name=statusHome]:checked').val(),
            'activityType': $('form input[name=activityType]:checked').val(),
            'typeOfRawMaterial': row_types,
            'addressHome': $('form input[name=addressHome]').val(),
            'houseDistrict': $('form select[name=houseDistrict] option:selected').val(),
            'flatsCount': $('form input[name=flatsCount]').val(),
            'managementCompanyType': $('form input[name=manag_comp_type]:checked').val(),
            'availableCouncil': $('form input[name=availableCouncil]:checked').val(),
            'managementOrganizationRelation': $('form input[name=managementOrganizationRelation]:checked').val(),
            'managementCompanyContacts': $('form input[name=managementCompanyContacts]').val(),
            'additionalInformation': $('form input[name=additionalInformation]').val(),
            'containerAvailable': $('form input[name=containerAvailable]').val(),
            'containerSize': $('form input[name=containerSize]').val(),
            'containerOwner': $('form input[name=containerOwner]').val(),
            'garbageAvailable': $('form input[name=garbageAvailable]').val(),
            'exportGarbage': $('form input[name=exportGarbage]').val(),
            'agreement': $('form input[name=agreement]').val()
        };
        $.ajax({
            url: '/api/petition',
            type: 'post',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(petition),
            success: function () {
                console.log('asdasd');
            },
            error: function (e) {
                console.log(e);
            }
        });
        event.preventDefault();
    });
});


