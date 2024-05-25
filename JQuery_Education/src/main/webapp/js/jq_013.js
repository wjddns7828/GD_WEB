/**
	이벤트 전파 : 각 요소가 중첩(포함, 겹침)인 경우 하나의 이벤트가 발생하면 중첩된 요소의 이벤트도 모두 차례대로 이벤트가 발생됨
	이벤트 전파 막기 : 	stopPropagation() - 이벤트 요소를 막음 // javascript 이벤
					preventDefault() - 이벤트에 의한 기본 동작을 막음 // html의 기본 동작을 막음 Ex) a태그 submin 등등
					return false; - 두개 다 막아버림
					
	기본의 Propagation 없이 진행이 되면 중첩되어 있기 떄문에 a->p->div->HTML href 동작
	하지만 중간에 p태그 이벤트 stopPropagation을 작성하면 a->p->HTML href 동작
 */
 $(function(){
	$("a:eq(0)").click(function(event){//클릭이벤트에 이벤트를 담고있는 객체를 event변수로 받아줌
		alert("클릭");
		console.log(event);
		event.preventDefault();
		event.stopPropagation();
		return false;
	});
	
	$("p").click(function(){
		alert("p클릭");		
	});
	$("div").click(function(){
		alert("div클릭");
	});
	
	
	//이벤트 메소드 종류 : click(), change(), keyUp(), keyDown(), submit().............
	//이벤트 핸들러(이벤트의 발생을 도와주는 것) : 	bind (이벤트를 껴줌) / unbind(이벤트를 제거), 
	//									live(원래 있던 이벤트를 꺠워주는것 ), die(원래 있던 이벤트를 죽이는 것)....   
	console.log($("a:eq(1)").bind());
	$("a:eq(1)").bind(
		{
		"mouseover":
		function(){
			$(this).css("background","blue");
		},
		"mouseout":
		function(){
			$(this).css("background","white");
		}
	});
	//bind()를 통해 화면이 렌더링 될 때 없었던 이벤트를 생성 할 수 있다.
	//생성된 이벤트를 제어하는 unbind()
	//var interval = setIntervar("함수","시간")
	//clearIntervar(interval);
	
	
	$("span").click(function(){
		$("a:eq(1)").unbind();
	});
	//요소 추가
	$("button").click(function(){
		$("body").append("<p>새로 추가된 p 태그</p>");	
		// innerHTML 혹은 자바스크립트에 setAttribute를 통해서 이벤트를 설정해줘야함	
		$("body").append("<p onclick='alert(100)';>새로 추가된 p 태그</p>");		
	});
	
	//53번째 줄에 나중에 생성된 Element에 이벤트를 걸어줌 
	//랜더링 시 생성된 p태그가 아니기 때문에 이벤트 핸들러가 존재하지않음
	//이전에 생성된 태그가 아닌 추가된 ptag이기 떄문에 event를 걸어 줄 수 없다,
	//on을 통해서 처리해준다
	$("body").on("click","p",function(){
		alert("on으로 추가된 이벤트");
		
	});
	
	
	
	
});