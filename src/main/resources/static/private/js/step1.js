
function step1(stepDto) {

    let petititon = stepDto.petition;
     $('#fio_petitioner').val(petititon.userName);
     $('#email_petitioner').val(petititon.email);
     $('#contacts_petitioner').val(petititon.contactInformation);
     $('#status_petitioner input [value = '+petititon.statusHome+']').prop('checked', true);
     $('#activity_petitioner input [value = '+petititon.separateCollection+']').prop('checked', true);
     for(let i = 0; i<petititon.typeOfRawMaterial.length; i++){
         $('#row_type input [value = '+petititon.typeOfRawMaterial[i]+']').prop('checked', true);
     }
     $('#home_adres').val(petititon.adresHome);
     $('#home_district option [value='+petititon.houseArea+']').prop('selected', true);
     $('#apartments_count').val(petititon.countOfApartments);
     $('#home_management_form input[value='+petititon.homeControlForm+']').prop('checked', true);
     $('#home_sovet input [value = '+petititon.houseCouncil+']').prop('checked', true);
     $('#menegement_org_relate input [value = '+petititon.managementOrganization+']').prop('checked', true);
     $('#contact_management').val(petititon.boardHouseContactInformation);
     $('#additional_information').val(petititon.additionalInformation);
     $('#container_place input [value = '+petititon.containerSite+']').prop('checked', true);
     $('#container_area').val(petititon.containerSize);
     $('#container_area_owner input [value = '+petititon.containerOwner+']').prop('checked', true);
     $('#chute_form input [value = '+petititon.garbage+']').prop('checked', true);
     $('#garbage_disposal_company').val(petititon.exportGarbage);


}

 function save_task_1() {
     var row_types = $('#row_type input:checkbox:checked').map(function () {
         return this.value;
     }).get();
     let petition = {
         'id': id,
         'email': $('#email_petitioner').val(),
         'userName': $('#fio_petitioner').val(),
         'contactInformation': $('#contacts_petitioner').val(),
         'statusHome': $('input[name="status"]:checked').val(),
         'separateCollection': $('input[name="activity_petitioner"]:checked').val(),
         'typeOfRawMaterial': row_types,
         'adresHome': $('#home_adres').val(),
         'houseArea': $("#home_district option:selected").val(),
         'countOfApartments': $('#apartments_count').val(),
         'homeControlForm': $('input[name="management_form"]:checked').val(),
         'houseCouncil': $('input[name="home_sovet"]:checked').val() ,
         'managementOrganization': $('input[name="menegement_org_relate"]:checked').val(),
         'boardHouseContactInformation': $('#contact_management').val(),
         'additionalInformation': $('#additional_information').val(),
         'containerSite': $('input[name="container_place"]:checked').val(),
         'containerSize': $('#container_area').val(),
         'containerOwner': $('input[name="container_area_owner"]:checked').val(),
         'garbage': $('input[name="chute"]:checked').val(),
         'exportGarbage': $('#garbage_disposal_company').val(),
     };
     $.ajax({
         type: 'post',
         url: "/api/seekerprofiles/update",
         data: JSON.stringify(petition),
         dataType: "json",
         contentType: 'application/json; charset=utf-8',
         beforeSend: function (request) {
             request.setRequestHeader(header, token);
         },
         success: function (profile) {
             alert("Изменения успешно внесены")
         },
         error: function (error) {
             console.log(error);
             alert(error.toString());
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