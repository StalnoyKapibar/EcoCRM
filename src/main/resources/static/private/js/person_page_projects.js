// $(function () {
//     getPhoto();
// }
// function getPhoto() {
//     $.ajax({
//         url: "/api/user/photos",
//         type: "GET",
//         async: false,
//         success: function (photos) {
//             $.each(photos, function (key, value) {
//                 $("#profile_avatar").remove();
//                 var helpTag = document.getElementById('photo');
//                 helpTag.insertAdjacentHTML('afterbegin','<img src="data:image/png;base64,' + value + '" class="img-rounded" alt="profile image" id = "profile_avatar" >');
//             })
//         },
//         error: function(error) {
//             console.error('problem with load photo', error);
//         }
//     });
// }
