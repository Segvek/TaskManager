var tomorrowUserPage = function (){
    var content = document.getElementById("content");
    var viewTomorrowPage = new View("ViewTomorrowPage.html");
    content.innerHTML=viewTomorrowPage.getHTML();
}
