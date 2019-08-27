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

 function save_task_1(id) {
     let petition = {
         'id': id,
         'email': ,
         'userName': ,
         'contactInformation': ,
         'statusHome': ,
         'separateCollection': ,
         'typeOfRawMaterial': ,
         'separateCollection': ,
         'separateCollection': ,
         'separateCollection': ,
         'separateCollection': ,
         'separateCollection': ,
         'separateCollection': ,
     };
     $.ajax({
         type: 'post',
         url: "/api/seekerprofiles/update",
         data: JSON.stringify(profile),
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