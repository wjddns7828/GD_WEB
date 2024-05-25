$(function(){
	$("button").eq(0).click(function(){
		$("#base").after("<div>새로운 ElementAfter</div>");
	});
	$("button").eq(1).click(function(){
		$("<div>").html("<b>새로운 Element insertAfter</b>").insertAfter("#base");
	});
	$("button").eq(2).click(function(){
		$("#base").before("<div>새로운 Elementbefore</div>");
	});
	$("button").eq(3).click(function(){
		$("<div>").html("<b>새로운 Element insertBefore</b>").insertBefore("#base");
	});
});