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
            $('#form-autorithation [type="text"], #form-autorithation [type="password"]').css('boxShadow', '0px 0px 10px red');
            return;
        }
        document.cookie = "sessionID=" + $(xml).find('sessionId').text();
        isAuthorization();
    });
}

//Функция обработчи события нажатия кнопки регистрация
var registration = function () {
    let page = document.getElementById("page");
    let login = document.getElementById("login-registration").value;
    let mail = document.getElementById("mail-registration").value;
    let password = document.getElementById("password-registration").value;
    let repeatPassword = document.getElementById("repeat-password-registration").value;
    
    if(password != repeatPassword){
        $('#form-registration [type="password"]').css('boxShadow', '0px 0px 10px red');
        return;
    }
    
    let request = 
        "<request>\
            <registration>\
                <name>" + login + "</name>\
                <mail>" + mail + "</mail>\
                <hashPass>" + password + "</hashPass>\
            </registration>\
        </request>";
    
    requestSender("API", request, function (xmlResponce) {
        let xml = $.parseXML(xmlResponce);
        if (xml.getElementsByTagName('error').length != 0) {
            $('#form-autorithation [type="text"], #form-autorithation [type="password"]').css('boxShadow', '0px 0px 10px red');
            return;
        }
        document.cookie = "sessionID=" + $(xml).find('sessionId').text();
        isAuthorization();
    });
}
//функция выполняется в случае если пользователь авторизирован 
function isAuthorization() {
    userPageCarcas();
}


function disigneWelcomPage() {
    //header slider
    var Slide = ['img/1.jpg', 'img/2.jpg', 'img/3.jpg', 'img/4.jpg', 'img/5.jpg'];
    var FirstSlide = 0;
    var Temp = 0;
    var LastSlide = 4;
    $('header').css('background', 'url('+ Slide[Temp] +'), #607d8b');
    $('header').css('backgroundSize', 'cover');
    function ForwardSlide(){
            if(Temp == LastSlide){
                    Temp = FirstSlide;
            }else(Temp++)

            $('.welcome-page header').animate({opacity: 'toggle'}, 500);
            $('header').css('background', 'url('+ Slide[Temp] +'), #607d8b');
            $('header').css('backgroundSize', 'cover');
            $('.welcome-page header').animate({opacity: 'toggle'}, 500);
    }

    setInterval(function(){
            ForwardSlide();
    },6000);


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
            

//    $('#form-registration [type="submit"]').click(function(){
//        let login = $('#form-out .name').val();
//        let email = $('#form-out .email').val();
//        let password = $('#form-out .password').val();
//        let errorRegister = [];
//        //alert(login);
//        if(login == ''){
//            errorRegister += 'Заполните поле логине';
//        }
//        if(email == ''){
//            errorRegister += 'Заполните поле почты';
//        }
//        if(password == ''){
//            errorRegister += 'Заполните поле пароль';
//        }
//        alert(errorRegister);
//    });

    

}
