//athor - Yuri Panasenco

var welcomePage = function () {
    let page = document.getElementById("page");
    //проводиться проверка авторизирован ли пользователь
    if (getCookie("sessionID") == undefined) {
        var viewWelcome = new View("ViewWelcomePage.html");
        page.innerHTML = viewWelcome.getHTML();
    } else {
        isAuthorization()
    }
}

//Функция обработчи события нажатия кнопки авторизация
var authorization = function () {
    let page = document.getElementById("page");
    let login = document.getElementById("login").value;
    let pass = document.getElementById("pass").value;
    let request = "<request><authorization><name>" + login + "</name><hashPass>" + pass + "</hashPass></authorization></request>";
    requestSender("API", request, function (xmlResponce) {
        let xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            page.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        let $test = $(xml).find('sessionId');
        document.cookie = "sessionID=" + $test.text();
        isAuthorization();
    });
}

//функция выполняется в случае если пользователь авторизирован 
function isAuthorization() {
    userPageCarcas();
}