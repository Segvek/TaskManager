//athor - Yuri Panasenco

var welcomePage = function () {
    let page = document.getElementById("page");
    //проводиться проверка авторизирован ли пользователь
    if (getCookie("sessionID") == undefined) {
        var viewWelcome = new View("ViewWelcomePage.html");
        page.innerHTML = viewWelcome.getHTML();
        disigneWelcomPage();
           
        
        
    } else {
        isAuthorization();
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


function disigneWelcomPage() {
    //header slider
    console.log('dwad');
    var Slide = ['/img/1.jpg', '/img/2.jpg', '/img/3.jpg', '/img/4.jpg', '/img/5.jpg'];
    var FirstSlide = 0;
    var Temp = 0;
    var LastSlide = 4;
    $('header').css('background', 'url('+ Slide[Temp] +'), #607d8b');
    $('header').css('background-size', 'cover');
    $('header').css('background-position', 'centr');
    function ForwardSlide(){
            if(Temp == LastSlide){
                    Temp = FirstSlide;
            }else(Temp++)

            $('header').animate({opacity: 'toggle'}, 600);
            $('header').animate({opacity: 'toggle'}, 600);

            $('header').css('background', 'url('+ Slide[Temp] +'), #607d8b');
            $('header').css('background-size', 'cover');
            $('header').css('background-position', 'centr');
    }

    setInterval(function(){
            ForwardSlide();
    },10000);


    //		Открытие формы Входа
    $('#but1').click(function(){
            $('#in').css('display', 'block');
    });
    //		Закрытие формы Входа
    $('#in p').click(function(){
            $('#in').css('display', 'none');
    });


    //		Открытие формы Регистрации
    $('#but2, #s1').click(function(){
            $('#out').css('display', 'block');
    });
    //		Закрытие формы Регистрации
    $('#out p').click(function(){
            $('#out').css('display', 'none');
    });


    // dich kakayato
    $('#but1').click(function(){
            //location.href = '/home.html';
    });

}
