/**
	달력의 일 숫자에 마우스를 enter/leave시 글 갯수를 알려주는 이벤트
 */
 
 var broken;//이벤트를 종료 시킬 때 사용

$(document).ready(function(){
	console.log("calendar.js onload이벤트 실행");
	$(".countView")
	.on("mouseenter",function(){
		var v = $(this);
		broken = setTimeout(function(){
		console.log("마우스 입장",$(v).text());
		//현재 화면에 있는 값을yyyymmdd로 바꿔주기
		var yyyymmdd;
		var yyyy= $(".y").text();
		var mm=$(".m").text();
		var cDate =v.text().trim().length==2?v.text().trim():"0"+v.text().trim();
		yyyymmdd = yyyy+mm+cDate;
		console.log(yyyymmdd);
		ajaxCnt(v,yyyymmdd);
		},3000)	;
	})
	.on("mouseleave",function(){
		console.log("마우스 퇴장",$(this).text());
		clearTimeout(broken);
		$(".cPreview").remove();
	});
	
	$("#submitbtn").on("click",function(event){
		var chk = $("input:checkbox");
		console.log(chk);
		if($("input[name=chk]:checked").length==0){
			alert("반드시 하나 이상은 체크해주세요")
			event.preventDefault();
		}
	});
});
	
	
function ajaxCnt(pos, yyyymmdd){
	console.log("DOM의 위치 : ",pos);
	console.log("선택된 년월일 : ", yyyymmdd);
	$.ajax({
		url:"./CalListAjax.do",
		type:"post",
		async:true,
		data:{"yyyymmdd":yyyymmdd},
		dataType:"JSON",
		success: function(resp){
         console.log(typeof resp, resp);
         pos.after("<div class='cPreview'>"+resp.calCount+"</div>")
      },
      beforeSend: function() {
         console.log("동작전");
         $(".warp_loding").css("display", "block");
      },
      complete: function() {
         console.log("동작완료");
         $(".warp_loding").css("display", "none");
      },
      error: function(){
         alert("통신 실패!!!!!!!!!!!!!!!");
      }
	});
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	