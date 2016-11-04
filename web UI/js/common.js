// $(window).scroll(function() {
// 	var st=$(this).scrollTop();
// 	$(".navb").css({
// 		'background': 'rgba(0, 0, 0, .5)'
// 	});
// 	if(0==st>100){
// 		$(".navb").css({
// 		'background': 'rgba(0, 0, 0, .5)'
// 		});
// 	}
// });

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

	$('.list-tomorrow button').click(function(){
		sizeLi = 0;
		//var sizeLi = $('.task-input-tomorrow').size();
		var lastLi = $('.task-input-tomorrow:last').val();
		var err = "input last task";

		console.log(lastLi);

		if(lastLi == ''){
			
			$('#error-tomorrow').html(err);
		}
		else{
			$('.ui-state-default:last').after('<li class="ui-state-default"> task<input type="text" class="task-input-tomorrow" placeholder="Task"><input type="text" class="Target-item-input-tomorrow" placeholder="Target-item"></li>');
			//$('.task-input-tomorrow:last').parents().removeClass('ui-state-default');
			$('#error-tomorrow').html('');

		}
	});

	$('.save').click(function(){

	}
});
