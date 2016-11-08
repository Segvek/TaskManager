//athor - Yuri Panasenco
var userPageCarcas = function () {
    var page = document.getElementById("page");
    var viewsi = new View("ViewPageCarcas.html");

    var request = "<request><userState><sessionId>" + getCookie("sessionID") + "</sessionId></userState></request>";
    requestSender("API", request, function (xmlResponce) {
        var xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            page.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        var $login = $(xml).find('login');
        var $countMessage = $(xml).find('countMessage');
        var $dataRegistration = $(xml).find('dataRegistration');
        viewsi.setAttribut("userlogin",$login.text());
        viewsi.setAttribut("countMessage",$countMessage.text());
        viewsi.setAttribut("dateregistration",$dataRegistration.text());
        page.innerHTML = viewsi.getHTML();
        mainUserPage();
    });
}

var userExit = function () {
    request = "<request><closeSession> <sessionId>" + getCookie("sessionID") + "</sessionId></closeSession></request>";
    requestSender("API", request, function (xmlResponce) {
        var xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            content.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
    });
    deleteCookie("sessionID");
    welcomePage();
}

var clickItemMenuGoals = function(){
    goalUserPage();
}
var clickItemMenuMain = function (){
    mainUserPage();
}