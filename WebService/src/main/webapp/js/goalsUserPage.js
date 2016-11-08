var goalUserPage = function (){
    var content = document.getElementById("content");
    var viewGoalsPage = new View("ViewGoalsPage.html");
    content.innerHTML=viewGoalsPage.getHTML();
}

var ClickLinkAddNewGoalOnPageViewGoals = function(){
    addNewGoal(goalUserPage);
}