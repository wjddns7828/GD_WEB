$(function(){
	$("#empSearch").click(function(){
		var empId = $("#empId").val();
		console.log(empId);
		if(!isNaN(empId)&&(empId.length==3)){
			$.ajax({
				url:"EMPLOYEES_202307181239.xml",
				method:"post",
				async:true,
				dataType:"xml",
				success:function(data){
//					console.log(data,typeof data);
//					alert($(data).find("DATAP_RECODRD").ep.childern.eq(1).text);
					var empInfo= $(data).find("EMPLOYEE_ID:contains("+empId+")").parent();
					console.log(empInfo);
					
					if($(empInfo).is("DATA_RECORD")){
						$("table input").each(function(i){
							$(this).val($(empInfo).children().eq(i).text());
						});
					}else{
						alert("해당사원은 존재하지 않습니다.");
					}
				},
				error:function(request, status, error){
					alert("code"+request.status+"\n" +"massage : "+request.sesponseText+"\"에러",error )
				}
			});
		}else{
			alert("부적합한 사원번호 입니다.");
		}
	});
});