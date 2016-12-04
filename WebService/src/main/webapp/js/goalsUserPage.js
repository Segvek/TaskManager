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
            let goal = xml.getElementsByTagName('goal')[i];
            let viewItemUserGoal = new View("IncludeView/ViewItemUserGoals.html");
            viewItemUserGoal.setAttribut("nomber",i+1);
            viewItemUserGoal.setAttribut("name",$(goal).find('name').text());
            viewItemUserGoal.setAttribut("anotation",$(goal).find('annotation').text());
            viewItemUserGoal.setAttribut("beginDate",$(goal).find('beginDate').text());
            viewItemUserGoal.setAttribut("endDate",$(goal).find('endDate').text());
            viewItemUserGoal.setAttribut("state",$(goal).find('state').text());
            viewItemUserGoal.setAttribut("idGoal",$(goal).find('id').text());
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

var showDetaliesGoal = function(idGoal){
    let request = "<request><goalInfo><sessionId>" +getCookie("sessionID") + "</sessionId><golaID>"+idGoal+"</golaID></goalInfo></request>";
    console.log(request);
    requestSender("API", request, function (xmlResponce) {
            console.log(xmlResponce);
    });
}