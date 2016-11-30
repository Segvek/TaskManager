var goalUserPage = function (){
    let content = document.getElementById("content");
    let viewGoalsPage = new View("ViewGoalsPage.html");
    
    let request = "<request><userGoals><sessionId>" + getCookie("sessionID") + "</sessionId></userGoals></request>";
    requestSender("API", request, function (xmlResponce) {
        let xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            page.innerHTML += xml.getElementsByTagName('error')[0].innerHTML;
            return;
        }
        let htmltext = "";
        for (let i = 0; i < xml.getElementsByTagName('goal').length; i++) {
            let mess = xml.getElementsByTagName('goal')[i];
            let viewItemUserGoal = new View("IncludeView/ViewItemUserGoals.html");
            viewItemUserGoal.setAttribut("nomber",i+1);
            viewItemUserGoal.setAttribut("name",$(mess).find('name').text());
            viewItemUserGoal.setAttribut("anotation",$(mess).find('annotation').text());
            viewItemUserGoal.setAttribut("beginDate",$(mess).find('beginDate').text());
            viewItemUserGoal.setAttribut("endDate",$(mess).find('endDate').text());
            viewItemUserGoal.setAttribut("state",$(mess).find('state').text());
            htmltext += viewItemUserGoal.getHTML();
        }
        viewGoalsPage.setAttribut("items",htmltext);
        content.innerHTML = viewGoalsPage.getHTML();
    });
    content.innerHTML = viewGoalsPage.getHTML();
}

var ClickLinkAddNewGoalOnPageViewGoals = function(){
    addNewGoal(goalUserPage);
}