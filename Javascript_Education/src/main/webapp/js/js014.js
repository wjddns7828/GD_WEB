/**
 * 
 */
 onload =function(){
	document.getElementsByTagName("button")[0].onclick = testDate01;
	document.getElementsByTagName("button")[1].onclick = testDate02;
	document.getElementsByTagName("button")[2].onclick = testDate03;
	document.getElementsByTagName("button")[3].onclick = testDate04;
	document.getElementsByTagName("button")[4].onclick = testDate05;
	
}

function testDate01(event){
	console.log("testDate01","오늘날짜 구하기");
	var today = document.getElementById("today");
	var date = new Date();
	//java에서 java.util.Date의 문자 출력 형태 simpleDateFormat
	//DataBase에서 TO_CHAR(date컬럼,pattern)
//	today.innerHTML=date;
//	today.innerHTML=date.toDateString();
	//today.innerHTML=date.toLocaleDateString();
	today.innerHTML=date.toLocaleTimeString();
}
function testDate02(){	
	//날짜는 month가 array 입력 할 땐 -1 출력할 땐 +1
	console.log("testDate02");
	//pattern
	var date = new Date('2023-05-27');
	console.log(date.toLocaleDateString());
	
	var dayOfWeek=["일","월","화","수","목","금","토"];
	var date = new Date();
	var year = date.getFullYear();
	var month =date.getMonth()+1 +"";
	var date1 =date.getDate() +"";
	var day = date.getDay();
	
	var monthWord= month.length ==2? month:"0"+month;
	var date1Word= date1.length ==2? date1:"0"+date1;
	
	
	console.log(year,month,date1,dayOfWeek[day],monthWord);
	
	document.getElementById("dates").value=`${year}-${month}-${date1Word}`;
}
function testDate03(){
	console.log("testDate03");	
	var date1= new Date('2023-06-27');
	var date2= new Date('2023',6-1,'27');
	
	console.log(date1.toLocaleString())	;
	console.log(date2.toLocaleString());	
}
function testDate04(){
	console.log("testDate04");	
	var dates=document.getElementById('dates').value;
	console.log(typeof dates);		
	var inputDate = document.getElementById("inputDate").value;
	console.log(typeof inputDate);		
	
	var date = new Date(dates);
	date.setDate(date.getDate()+parseInt(inputDate));
	document.getElementById('result').value = date.toLocaleDateString();
}
function testDate05(){
	console.log("testDate05");	
	var dates1= document.getElementById("dates1").value;		
	var inputDates1= document.getElementById("inputDates1").value;
	var startDate = new Date(dates1);
	var endDate = new Date(inputDates1);
	
	//날짜(date)를 통해서 계산의 결과는 밀리세컨드
	var resultDate = (endDate.getTime()- startDate.getTime())/(1000*60*60*24);
	document.getElementById(result1).value=resultDate;
}