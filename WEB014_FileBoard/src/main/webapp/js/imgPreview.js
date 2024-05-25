$(function() {
	console.log("jQuery부르기 성공");
	$("input:file").change(function() {
		console.log("파일 첨부 시 함수 실행");
		console.log($("input:file"));
		var filename = ($("#imgFile").val().split("\\")[2]);

		var file = $("input:file");
		var fileSize = file[0].files[0].size;
		console.log(fileSize);
		var fileForm = /(.*?)\.(jpg|jpeg|png|bmp)$/;
		var maxSize = 5 * 1024 * 1024; // 5MB

		var isc = fileForm.test(filename);
		console.log(file[0].files[0]);
		var formData = new FormData(); // FormData 객체 생성
		formData.append("image",file[0].files[0])
		console.log(formData);
		
		if (!(fileForm.test(filename))) {
			alert("이미지만 업로드 가능합니다.");
			file.val("");
		} else if (file > maxSize) {
			alert("파일 사이즈는 5MB까지만 가능합니다.");
			file.val("");
		} else {
			console.log("$$$$$$$");
			$.ajax({
		        url: "./imgPreview.do", //주소
		        enctype: "multipart/form-data", //form data 설정
		        type: "POST", //전송 타입
		        processData: false, //프로세스 데이터 설정 : false 값을 해야 form data로 인식합니다
		        contentType: false, //헤더의 Content-Type을 설정 : false 값을 해야 form data로 인식합니다
		        data:formData, //전송 데이터
				success: function(suc) {
					console.log(suc);
					$(".imgPreview").append(suc);
				},
				error: function() {
					console.log("$$$$$$");
				}
			});
		}
	});
});