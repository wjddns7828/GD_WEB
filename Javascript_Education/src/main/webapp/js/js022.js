function createImg(){
	var rdoBtn = document.getElementsByName("rdoBtn");
	var rdoValue="";
	
	for(let i =0; i < rdoBtn.length; i++){
		if(rdoBtn[i].checked){
			rdoValue="./img/"+rdoBtn[i].value;
		}
	}
	console.log(rdoValue);
	
	//1)img tag생성 : img tag생성하여 src속성을 작성한다
	var img = document.createElement("img");
	img.setAttribute("src",rdoValue);
	
	//2) 생성된 img를 붙여 위치
	var div = document.getElementById("imgView");
	//div.appendChild(img); //이렇게하면 뒤에 계속 붙음
	
	//div에 자식 노드가 있다면 삭제하거나 replace하여 새로운 img를 붙혀넣음
	//부모 Node에서 자식 Element만을 선택하는건 childeren을 사용하면 element갯수만큼 가져옴
	// firstChild는 전체 Node중 첫번째를 찾아준다
	// 삭제 혹은 교체를  하기 위해서 정확한 Element를 찾아줘야한다
	
	//Ex 1) childNodes 방법을 사용해서 증명
	/*console.log(div.childNodes.length);//3
	if(div.childNodes.length!=0){
		var divImg = div.firstChild; //div가 가지고 있는 첫번째 Node
		console.log(divImg);
		div.removeChild(divImg);
	}*/
	
	//Ex 2) children, firstElementChild 방법을 사용해서 증명
	console.log(div.children.length);//3
	if(div.children.length!=0){
		var divImg = div.firstElementChild; //div가 가지고 있는 첫번째 Node
		console.log(divImg);
		div.removeChild(divImg);
	}
	
	var oldImg= document.querySelector("#imgView>img");
	div.replaceChildren(img,oldImg);
			
}