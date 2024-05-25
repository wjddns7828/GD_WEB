function showFood(){
	var food = document.getElementsByName("food")[0];
	
	//선택된 option의 index를 가지고 온다
	var foodIdx = food.selectedIndex;
	console.log(foodIdx);
	
	//선택된 index를 통해서 값을 가져오기
	console.log(food[foodIdx].value);
	
	var choiceFood= food.options[foodIdx];
	console.log(choiceFood);
	console.log(choiceFood.value);
}

function showFoodMulti(){
	var food = document.getElementsByName("food")[1];
	
	var foodChoice="";
	for(let i = 0; i<food.length; i++){
		if(food.options[i].selected){
			foodChoice += food.options[i].textContent+"\n";
		}
	}
	console.log(foodChoice);
	
	//\n으로 되어있는 값을 innerHTML으로 출력
	var printFood 	=	document.getElementById("printFood");
	printFood.innerHTML=foodChoice;
	
	//\n으로 되어있는 값을 textarea영역에 출력
	var areaFood 	= 	document.getElementById("areaFood");
	areaFood.value=foodChoice;
	
	//\n으로 되어있는 값을 replace와 regEx를 통해서 <br>출력 [xss(Cross-Site Scripting):]
	var divFood 	= 	document.getElementById("divFood");
	var newFoodChoice = foodChoice.replace(/(?:\r\n|\n\r|\r|\n)/g,"<br>");
	divFood.innerHTML=newFoodChoice;
}