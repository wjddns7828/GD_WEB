/**
 * 
 */

$(function(){
	$("#reply").click(function(){
		reply();
	})
});

function reply(){
	$.ajax({
		url:"./replyWrite.do",
		type:"post",
		async:true,
		dataType:"json",
		data:{"reply":$("#replyTxt").val(),
			"seq":$("#seq").val(),
			"writer":$("#writer").val()},
		success:function(data){
			$("tfoot").append("<tr>"+
									"<th>"+
										data.writer+"<br>"+
										data.regdate+
									"</th>"+
									"<td>"+
										data.content+
									"</td>"+
								"</tr>");
			$("replyTxt").text("");
		},
		error:function(){
			alert("잘못된 요청");
		}
	})
}