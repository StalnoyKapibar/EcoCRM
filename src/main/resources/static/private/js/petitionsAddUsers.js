function addUserToPetition(id) {
    $.ajax({
        type: 'put',
        url: '/api/petition/addPetitionUser?id='+id,
        async: false,
        success:function () {
            $('#'+id+'_remove_btn').remove("");
            },
    });

}