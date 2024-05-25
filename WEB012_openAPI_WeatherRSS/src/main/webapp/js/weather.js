$(function(){
	$("#weaView").click(function(){
		console.log("클릭 테스트");
		var code= $("#address option:selected").val();
		console.log(code);
		
		$.ajax({
			url:"./weatherOpen.do",
			type:"post",
			data:{"zone":code},
			dataType: "text",
			success:function(data){
				//TODO 01
//				console.log("ajax 결과 값 : ", data);
				//TODO 02, 03, 04
				//var obj = JSON.parse(data);
//				console.log(obj, typeof obj);
				var obj = JSON.parse(data);
				console.log(obj, typeof obj);
				
				$("#x").val(obj.x)
				$("#y").val(obj.y)
				$("#pubDate").val(obj.pubDate)
				$("#wfKor").val(obj.wfKor)
				$("#temp").val(obj.temp)
				$("#reh").val(obj.reh)
				$("#pop").val(obj.pop)
				
				var weather_icon = obj.wfKor;
				switch(weather_icon){
					case "맑음": 		$("#weatherImg").attr("src","./images/Clear.png");break;
					case "구름 조금": 	$("#weatherImg").attr("src","./images/PartlyCloudy.png");break;
					case "구름 많음": 	$("#weatherImg").attr("src","./images/MostlyCloudy.png");break;
					case "흐림":		$("#weatherImg").attr("src","./images/Cloudy.png");break;
					case "비": 		$("#weatherImg").attr("src","./images/Rain.png");break;
					case "눈/비": 	$("#weatherImg").attr("src","./images/SnowRain.png");break;
					case "눈": 		$("#weatherImg").attr("src","./images/Snow.png");break;
				}
			},
			error:function(){
				alert("잘못된 요청값 입니다.")
			}			
		});
	});
	//CORS가 처리되지 않기 때문에 Ajax를 직접 호출이 불가능함
	$("#cors").click(function(){
		console.log("jQuery Ajax를 통해서 공공데이터의 xml을 요청해 본다");
		$.ajax({
			url:"http://www.kma.go.kr/wid/queryDFSRSS.jsp",
			type:"post",
			data:{"zone":"1150061100"},
			success:function(data){
				var obj = JSON.parse(data);
				console.log(obj);
			},
			error:function(){
				alert("잘못된 요청 처리");
			}		
		});
	});
	$("#xmlview").click(function(){
		location.href="./weatherXML.do";
		});
	$("#jsoupEx").click(function(){
		location.href="./jsoup.do";
	});
	$("#webtoon").click(function(){
		location.href="./webtoon.do";
	});
});