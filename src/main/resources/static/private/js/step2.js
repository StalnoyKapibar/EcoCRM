// var projectId;
$(document).ready(function () {
    projectId = $('#projectId').val();
    $('#datepicker').datepicker({
        format: 'yyyy-mm-dd',
        uiLibrary: 'bootstrap4'
    });
});

function step2(stepDto) {
    if (stepDto.company !== null) {
        addCompany(stepDto.company);
    }
}

function saveManagCompInfo(projectId) {
    var managComp = {
        'name': $('#management_org_title').val(),
        'inn': $('#management_org_inn').val(),
        'link': $('#management_org_link').val(),
        'managerName': $('#management_org_surname').val(),
        'managerSurname': $('#management_org_name').val(),
        'managerPatronymic': $('#management_org_patronymic').val(),
        'phoneNumber': $('#management_org_tel').val(),
        'email': $('#management_org_email').val(),
        'clock': $('#management_org_clock').val(),
        'nextContactDate': $('#datepicker').val(),
        'description': $('#comment').val()
    };
    $.ajax({
        url: "/manage_company/add?projectid=" + projectId,
        type: "POST",
        data: JSON.stringify(managComp),
        contentType: 'application/json; charset=utf-8',
        success: function (id) {
            console.log("information about " + id + " company insert");
        },
        error: function (e) {
            console.error("insert information about " + id + " company FAILED!");
        }
    });
}

function addCompany(manageCompany) {
        $('#management_org_name').text(manageCompany.name);
        $('#management_org_inn').val(manageCompany.inn);
        $('#management_org_fio').val(manageCompany.managerName);

        // $('#management_org_link').val(manageCompany.link);

        // $('#management_org_name').val(manageCompany.managerName);
        $('#management_org_patronymic').val(manageCompany.managerPatronymic);
        $('#management_org_tel').val(manageCompany.phoneNumber);
        $('#management_org_email').val(manageCompany.email);
        $('#management_org_clock').val(manageCompany.clock);
        $('#datepicker').val(manageCompany.nextContactDate);
        $('#comment').val(manageCompany.description);
}