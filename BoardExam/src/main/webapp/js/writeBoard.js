$fileForm = /(.*?)\.(?!exe)[^\.]*$/i;

$(function(){
	
	//파일 업로드 유효값 검사
	$("#fileupload").change(function(){
	console.log("$$$$$");
	console.log($("#fileupload").val());
	console.log($fileForm.test($("#fileupload").val().split("\\")[2]));
	
	
	if(!$fileForm.test($("#fileupload").val().split("\\")[2])){
		alert("exe파일은 업로드 할 수 없습니다.");
		$("#fileupload").val("");
	}else{
		console.log("####");
		$filename=$("#fileupload").val().split("\\")[2];
		$("#filename").text($filename);
		}
	});
});

