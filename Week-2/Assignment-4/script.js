document.addEventListener('DOMContentLoaded', function () {
    var welcomeMessage = document.getElementById('welcome-message');
    welcomeMessage.addEventListener('click', function () {
        welcomeMessage.textContent = 'Have a Good Time!';
    });

    var showMoreButton = document.getElementById('show-more');
    showMoreButton.addEventListener('click', function () {
        var hiddenBoxes = document.querySelector('.content-boxes.hidden');
        hiddenBoxes.classList.remove('hidden');
    });
});
