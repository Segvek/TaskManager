var accountUserPage = function (){
    var contenta = document.getElementById("content");
    var viewAccountPage = new View("ViewAccountPag.html");
    contenta.innerHTML = viewAccountPage.getHTML();
}

var ClickLinkAddNewAccountOnPageViewAccount = function(){
    addNewAccount(accountUserPage);
}