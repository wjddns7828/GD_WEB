/**
 * 아코디언 메뉴 
 	1. 구성 : 상위 단계의 h3에 대한 p구성되도록 묶어줌
 			초기화면 첫번째 메뉴 목록의 하위 만 보이고
 			화살표 모양이 이미를 위로 만듬 나머지는 아래로 감춤
 	2. 기능 : h3의 오른쪽 이미지를 클릭하면 하위의 P가 슬라이드로 보여지게 한다
 			이때 화살표 방은 이로 포기못한다
 */
 $(function(){
	$("div>p").eq(0).show();
	$("div>p").eq(0).siblings("p").hide();
	$("div>h3").eq(0).addClass("active");
	
	$("h3").click(function(){
		$(this).next().stop().slideToggle();
		$(this).next().siblings("p").stop().slideUp();
		$(this).toggleClass("active");
		
		$(this).siblings("h3").each(function(){
			if($(this).hasClass("active")){
				$(this).removeClass("active");
			}
		});
	});
});
 