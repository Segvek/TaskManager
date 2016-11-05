var welcomePage = function () {
    var content = document.getElementById("content");
    //проводиться проверка авторизирован ли пользователь
    if (getCookie("sessionID") == undefined) {
        var viewWelcome = new View("ViewWelcomePage.html");
        content.innerHTML = viewWelcome.getHTML();
    } else {
        isAuthorization()
    }
}

//Функция обработчи события нажатия кнопки авторизация
var authorization = function () {
    var login = document.getElementById("login").value;
    var pass = document.getElementById("pass").value;
    var request = "<request><authorization><name>" + login + "</name><hashPass>" + pass + "</hashPass></authorization></request>";
    requestSender("API", request, function (xmlResponce) {
        var xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            content.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        var $test = $(xml).find('sessionId');
        document.cookie = "sessionID=" + $test.text();
        isAuthorization();
    });
}

//функция выполняется в случае если пользователь авторизирован 
function isAuthorization() {
    userPageCarcas();
}