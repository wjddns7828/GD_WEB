/**
 * 	1.객체의 작성 방법 명시적 / 익명적 방법
 		명시적 방법은 this를 사용
 		
 	2. 객체를 생성 할 때는 Pascal방법으로 명명함
 */
 
 /*
 명시적 작성방법
 	-this는 new로 객체를 생성하면
 	생성된 객체명을 통해서 속성 접근이 가능하다(수정/삭제)
 	-var로 생성된 변수는 외부에서 절대 접근이 불가능하다(은닉화)
 	-만약에 외부에서 값을 가져가거나 혹은 입력하는 기능을 만들고 싶다며 익명함수를 통해서 정의 할 수 있다.
 */
function Class008(){
	this.name="eclipse";
	var naem02 = "javascript";
	this.getName02 = function(){
						return name02;
						};
} ;

/*
	익명적 방식
 */
 var Class008_2={
	name:"korea",
	print:function(){
		alert(class008Class008_2.name+"!")
		return Class008_2.name;
	}
};

function objectTest(){
	//명시적 방법의 사용
	var class008=new Class008();
	class008.name="배추도사";
	/*alert("Class008의 속성값 name :"+class008.name);//this로 생성되어 외부에서 접근가능*/
	/*alert("Class008의 속성값 name :"+class008.name02);//this로 생성되어 외부에서 접근가능*/
	//alert("Class008의 속성값 name :"+class008.getName02());//this로 생성되어 접근가능함수
	
	
	//익명적 방법 사용
	Class008_2.name="무도사";
	alert("class008_2.name의 속성값 :" +class008_2.name);
	alert(Class008_2.name + ":"+Class008_2.print());
	//console.log(class008);
	var class008_proto= new Class008();
	class008_proto.printName();
}
Class008.prototype.printName = function(){
									/*alert(this.name+":" +this.getName02);*/
									alert(name02);
								};























































































































































































































































































































































































































































































































































































































