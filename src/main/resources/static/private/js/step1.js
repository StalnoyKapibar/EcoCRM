
function step1(stepDto) {

    let petititon = stepDto.petition;
     $('#fio_petitioner').val(petititon.userName);
     $('#email_petitioner').val(petititon.email);
     $('#contacts_petitioner').val(petititon.contactInformation);
     $('#status_petitioner input[value = "'+petititon.petitionerType+'"]').prop('checked', true);
     $('#activity_petitioner input [value = "'+petititon.activityType+'"]').prop('checked', true);
     for(let i = 0; i<petititon.typeOfRawMaterial.length; i++){
         $('#row_type input [value = "'+petititon.typeOfRawMaterial[i]+'"]').prop('checked', true);
     }
     $('#home_adres').val(petititon.addressHome);
     $('#home_district option [value="'+petititon.houseDistrict+'"]').prop('selected', true);
     $('#apartments_count').val(petititon.flatsCount);
     $('#home_management_form input[value="'+petititon.managementCompanyType+'"]').prop('checked', true);
     $('#home_sovet input [value = "'+petititon.availableCouncil+'"]').prop('checked', true);
     $('#menegement_org_relate input [value = "'+petititon.managementOrganizationRelation+'"]').prop('checked', true);
     $('#contact_management').val(petititon.managementCompanyContacts);
     $('#additional_information').val(petititon.additionalInformation);
     $('#container_place input [value = "'+petititon.containerAvailable+'"]').prop('checked', true);
     $('#container_area').val(petititon.containerSize);
     $('#container_area_owner input [value = "'+petititon.containerOwner+'"]').prop('checked', true);
     $('#chute_form input [value = "'+petititon.garbageAvailable+'"]').prop('checked', true);
     $('#garbage_disposal_company').val(petititon.exportGarbage);

    $('#uploaded_old_container_photo').append('<img src="data:image/png;base64,' + images[i].photo + '" alt="profile image"  height="200px">');
}

 function save_task_1(projectId) {
     var row_types = $('#row_type input:checkbox:checked').map(function () {
         return this.value;
     }).get();
     let petition = {
         'id': id,
         'email': $('#email_petitioner').val(),
         'userName': $('#fio_petitioner').val(),
         'contactInformation': $('#contacts_petitioner').val(),
         'petitionerType': $('input[name="status"]:checked').val(),
         'activityType': $('input[name="activity_petitioner"]:checked').val(),
         'typeOfRawMaterial': row_types,
         'addressHome': $('#home_adres').val(),
         'houseDistrict': $("#home_district option:selected").val(),
         'flatsCount': $('#apartments_count').val(),
         'managementCompanyType': $('input[name="management_form"]:checked').val(),
         'availableCouncil': $('input[name="home_sovet"]:checked').val() ,
         'managementOrganizationRelation': $('input[name="menegement_org_relate"]:checked').val(),
         'managementCompanyContacts': $('#contact_management').val(),
         'additionalInformation': $('#additional_information').val(),
         'containerAvailable': $('input[name="container_place"]:checked').val(),
         'containerSize': $('#container_area').val(),
         'containerOwner': $('input[name="container_area_owner"]:checked').val(),
         'garbageAvailable': $('input[name="chute"]:checked').val(),
         'exportGarbage': $('#garbage_disposal_company').val(),
     };
     $.ajax({
         type: 'post',
         url: "/api/petition/update?projectId="+projectId,
         data: JSON.stringify(petition),
         dataType: "json",
         contentType: 'application/json; charset=utf-8',
         success: function (profile) {
             alert("Изменения успешно внесены")
         },
         error: function (error) {
             console.log(error);
             alert(error.responseText);
         }
     })

 }

 function save_old_container_photo(projectId) {

     let img = $('#old_container_image_form')[0];
     let data = new FormData(img);
     $.ajax({
         url: "/api/project/add_old_container_photo?projectid=" + projectId,
         type: "POST",
         data: data,
         processData: false,
         contentType: false,
         success: function (images) {
             for(let i = 0; i<images.length; i++){
                 $('#uploaded_old_container_photo').append('<img src="data:image/png;base64,' + images[i].photo + '" alt="profile image"  height="200px">');
             }

         },
         error: function(request) {
             console.error("insert information about container FAILED!" + request.responseText);
         }
     });
 }