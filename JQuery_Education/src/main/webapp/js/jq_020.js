$(function(){
	//앞에 붙히기
	$("button").eq(0).click(function(){
		//<p></p> //<p class="prepend"></p> //<p class="prepend">prepend생성</p>
		$("div").prepend($("<p>").addClass("prepend").text("prepend생성"));
	});
	$("button").eq(1).click(function(){
//		$("div").append($("<p>").addClass("append").text("append생성"));
		$("body").append($("div p:first"));
	});
	$("button").eq(2).click(function(){
		//선택된 Element의 콘텐츠의 선택은 두가지 방법
		// 1) innerHTML HTML로 선택됨
		// 2) textContent 문자로만 선택됨
		var divhtml = $("div").html();
		console.log(divhtml);
		
		$("div").html("<b>innerHTML로 변경했다</b>");
		
	});
	$("button").eq(3).click(function(){
		$("div").text("<b>innerHTML로 변경했다</b>");
	});
});