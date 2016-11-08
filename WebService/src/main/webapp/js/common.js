
$(document).ready(function(){
	//header slider

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

	$('#but1').click(function(){
		//location.href = '/home.html';
	});

	

});
