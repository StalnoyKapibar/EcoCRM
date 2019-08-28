const statusInfo = 'alert_header';

let scrollTop = function() {
    $("body,html").animate({
        scrollTop:0
    }, 800);
    return false;
};

let alertInfo = function(state) {
    let form = $('#petition_form');
    if(form.children('#'+statusInfo).length > 0) {
        $('#'+statusInfo).detach();
    }
    switch (state) {
        case 'success':
            $(form).prepend('<div class="alert alert-success" role="alert" id="'+statusInfo+
                '">\n' +
                '  Заявка отправлена!\n' +
                '</div>');
            break;
        case 'wait':
            $(form).prepend('<div class="alert alert-warning" role="alert" id="'+statusInfo+
                '">\n' +
                '  Ваша заявка обрабатывается. Пожалуйста, подождите.\n' +
                '</div>');
            break;
        case 'error':
            $(form).prepend('<div class="alert alert-danger" role="alert" id="alert_header' +
                '">\n' +
                '  При обработке заявки произошла ошибка!\n' +
                '</div>');
            break;
    }
    if(state === 'success') {

    }
}

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
            success: function (response) {
                console.log(response.status);
                alertInfo('success');
            },
            error: function (response) {
                alertInfo('error');
            }
        });
        event.preventDefault();
        $('input').attr('disabled', true);
        alertInfo('wait');
        scrollTop();
    });
});


