var mainUserPage = function(){
    var content = document.getElementById("content");
    var viewsi = new View("ViewMainUserPage.html");
    /*загрузка плана на сегодня и его отображение*/
    var request = "<request><palnToDay><sessionId>"+getCookie("sessionID")+"</sessionId></palnToDay></request>";
    requestSender("API", request, function (xmlResponce) {
        var xml = $.parseXML(xmlResponce);
        
        xmlResponce="<responce><palnToDay><item><id>1</id><name>fererb</name><idGlobalItemPLan>345</idGlobalItemPLan><nameGlobalItemPlan>rfegthyrtehj5yr</nameGlobalItemPlan><state>2</state></item>\n\
<item><id>2</id><name>тввенте</name><idGlobalItemPLan>545</idGlobalItemPLan><nameGlobalItemPlan>упкурруеы</nameGlobalItemPlan><state>1</state></item></palnToDay></responce>";
        var xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            content.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        var listItemplanHTML="";
        for(var i=0; i<xml.getElementsByTagName("item").length; i++){
            var temp = xml.getElementsByTagName("item")[i];
            var viewItem = new View("IncludeView/ViewItemPlanToDay.html");
            viewItem.setAttribut("nomer",i+1);
            viewItem.setAttribut("idplanToDay",$(temp).find('id').text());
            viewItem.setAttribut("name",$(temp).find('name').text());
            viewItem.setAttribut("idplangoal",$(temp).find('idGlobalItemPLan').text());
            viewItem.setAttribut("plangoal",$(temp).find('nameGlobalItemPlan').text());            
            viewItem.setAttribut("active"+$(temp).find('state').text(),"active");            
            listItemplanHTML+=viewItem.getHTML();
        }
        viewsi.setAttribut("planToDay", listItemplanHTML);
        content.innerHTML = viewsi.getHTML();
    });
    
    
}


var clickLinkMain = function (){
    mainUserPage();
}