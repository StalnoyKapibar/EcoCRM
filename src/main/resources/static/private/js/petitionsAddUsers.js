function addUserToPetition(id) {
    $.ajax({
        type: 'put',
        url: '/api/petition/addPetitionUser?id='+id,
        success:function () {
            alert("ВЫ ДОБАВИЛИ ЧТО ТО ТАМ")
            $('#'+id+'_remove_btn').remove();

        },

        });

}