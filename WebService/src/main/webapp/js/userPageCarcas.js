var userPageCarcas = function(){
    var viewsi = new View("ViewPageCarcas.html");
    viewsi.setAttribut("sessionID", getCookie("sessionID"));
    content.innerHTML = viewsi.getHTML();
}

var userExit = function(){  
    request="<request><closeSession> <sessionId>"+getCookie("sessionID")+"</sessionId></closeSession></request>";
    requestSender("API", request, function (xmlResponce) {
        var xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            content.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        var $test = $(xml).find('closeSession');
        alert($test.text());
    });
    
    deleteCookie("sessionID");
    welcomePage();
}