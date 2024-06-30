document.addEventListener('DOMContentLoaded', function () {
    var welcomeMessage = document.getElementById('welcome-message');
    welcomeMessage.addEventListener('click', function () {
        welcomeMessage.textContent = 'Have a Good Time!';
    });
});
