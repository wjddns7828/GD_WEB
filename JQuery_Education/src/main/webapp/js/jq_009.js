$(function(){
	$("div>p").eq(0).click(function(){
		$("pre b").eq(0).toggle();
	});
	$("div>p").eq(1).click(function(){
		//시작 index, 끝index == -1
		$("pre b").slice(1,3).slideToggle();
	});
	$("div>p").eq(2).click(function(){
		$("pre b").first().css("color","cornflowerblue").end().eq(3).toggle().text("계속연결");
	});
	$("div>p").eq(3).click(function(){
		$("pre b").last().toggle();
	});
});