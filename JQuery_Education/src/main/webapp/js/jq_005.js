$(function(){
	//1. input 태그 중 text인 앨리먼트를 선택하여 배경색 추가하기
	$("input:text").css("backgroundColor","violet");
	// 2. input 태그중 타입이 password인 엘리먼트를 선택하여 배경 추가하기
	$("input:password").css("backgroundColor","red");
	//3. select태그의 name속성이 email인 앨리먼트의 change이벤트가 발생했다면
	//선택한 목록의 value를 alert하기
	$("select[name=email]").change(function(){
		alert($("select option:selected").val());
	});
	//4. checkbox를 check하면 check된 목록을 alert로 출력하기
	//체크된 목록이 모두 alert함수에 출력되어야함
	$("input:checkbox").click(function(){
		var str ="";
		$("input:checked").each(function(i){
			str +=$("input:checked").eq(i).val();
		});
		alert(str);
	});
});