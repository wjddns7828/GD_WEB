<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<script
  src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript" src="./smarteditor2/js/HuskyEZCreator.js" charset="UTF-8"></script>
</head>
<body>
	<form>
     <textarea rows="10" cols="30" id="ir1" name="ir1" id="ir1"></textarea>
     </form>
     <!-- [D] HTML5인 경우 pop_container 클래스와 하위 HTML 적용
	    	 그밖의 경우 pop_container2 클래스와 하위 HTML 적용      -->
	<div id="pop_container2" class="pop_container2">
	  <!-- content -->
		<form id="editor_upimage" name="editor_upimage" method="post" enctype="multipart/form-data" onSubmit="return false;">
      <div id="pop_content2">
				<input type="file" class="upload" id="uploadInputBox" name="Filedata">
	      <p class="dsc" id="info"><strong>10MB</strong>이하의 이미지 파일만 등록할 수 있습니다.<br>(JPG, GIF, PNG, BMP)</p>
      </div>
		</form>
    <!-- //content -->
  </div>
</body>
<script type="text/javascript">
$(function(){
	var oEditor =[];

	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors,
		elPlaceHolder :"ir1",
		sSkinURI : "/smarteditor2/SmartEditor2Skin.html",
		fCreator : "createSEditor2"
	});	
})
</script>
</html>
