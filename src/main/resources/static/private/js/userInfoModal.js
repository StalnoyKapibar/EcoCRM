// var modal = document.getElementById('myModal');
// var btn = document.getElementById("myBtn");
// var span = document.getElementsByClassName("close")[0];
//
// btn.onclick = function() {
//     modal.style.display = "block";
// }
//
// span.onclick = function() {
//     modal.style.display = "none";
// }
//
// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }

document.addEventListener('DOMContentLoaded', function() {
    var modalButtons = document.querySelectorAll('.js-open-modal'),
        overlay      = document.querySelector('#overlay-modal'),
        closeButtons = document.querySelector('.js-modal-close');


    modalButtons.forEach(function(item){

        item.addEventListener('click', function(e) {

            e.preventDefault();
            var modalId = this.getAttribute('data-modal'),
                modalElem = document.querySelector('.modal[data-modal="' + modalId + '"]');

            modalElem.classList.add('active');
            overlay.classList.add('active');
        }); // end click
    }); // end foreach
}); // end ready