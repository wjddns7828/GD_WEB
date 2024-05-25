/*let number = [1,2,3,4,5,6];
console.log(typeof number, number, number.length);

for(let i = 0; i<number.length; i++){
	console.log("!!"+number[i]);
}

for(let i in number){
	console.log("@@"+number[i]);
}
for(let i of number){
	console.log("##"+i);
}

number.forEach(function(x){
					console.log("$$ :"+x);
					});
*/

//1.배열의 선언방법
var arrayObj = new Array();//array의 객체 생성방법
var arrayLiteral = ["a1","a2","a3","a4"];//타입의 구분이 없ㅇ므
console.log(typeof arrayObj);
console.log(typeof arrayLiteral);

//2.배열의 선언 방식 종류

var arrayObj02 = new Array();//선언
var arrayObj03 = new Array(5);//배열의 크기 선언
var arrayObj04 = new Array(1,2,3,4,5)//1~5까지 들어가 있는 array 즉 값을 넣어줌

arrayObj02[0]=10;
arrayObj02[2]=20;

//객체가 있을 때 index를 지정하여 입력하면 자동으로 해당 인덱스가생성되고 값이 입력됨
//만약 index가 생성되어진 index보다 크다면 하위에 index에 객체가 상성되고 undefined가 됨
console.log(arrayObj02[0],arrayObj02[1],arrayObj02[2]);
console.log("arrayObj02.length :"+arrayObj02.length);

//객체를 만들 때 공간을 잡아주더라도 
console.log(arrayObj03);
console.log(arrayObj03[0],arrayObj03[1],arrayObj03[2],arrayObj03[3],arrayObj03[4],arrayObj03[6]);
console.log("length:"+arrayObj03.length);

//
console.log(arrayObj04);
console.log(arrayObj04[5]=10);
console.log(arrayObj04.length);




function muiltarray(){
	
	var len = 3;
	var arr = new Array(len);
	for(let i = 0; i<len;i++){
		arr[i] = new Array(len);
	}
	arr[0][0] ="apple";
	arr[0][1]="banana";
	arr[0][2]="tomato";

	arr[1][0]=1;
	arr[1][1]=2;
	arr[1][2]=3;
	
	arr[2][0]=["java","javascript"];
	arr[2][1]=["jsp","servlet"];
	arr[2][2]=["oracle","mysql"];
	
	console.log(arr[2][1][1])
}




function joinFn(){
	var arr01=["apple","banana","tomato"];
	var arr02=[1,2];
	var arr03=[1,2];
	
	//join은 배열의 각 요소를 문자열로 생성 conjuction을통해서붙여줌
	
	var joinarr = arr01.join("-");
	console.log(joinarr);
	
	var arraysum = arr02.join(arr03);
	console.log(arraysum);
}

function sortStringFn(){
	//문자,숫자 만 있는 Array에서 sorting의 문제가 발생하지 않음
	//문자,숫자,null을 sortin하면 모든 값들을 문자로 변경하여 sort 숫자->문자
	var arr= ['a','b,','d','c'];
	var arrStr=['1','10','5'];
	var arrNum=[1,4,2,6];
	var random = ['a',1,null,'b'];
	
	arr.sort();
	arrStr.sort();
	arrNum.sort();
	random.sort();
}
function sortNumberFn(){
	var arr=['1','2','3','9','5'];
	arr.sort(compare);
}
function compare(a,b){
	return a - b;
}



function sliceFn(){
	//slice는 잘라내는 index를 포함
	//java에서는 substring이랑 비슷함
	
	var arr01=[1,2,3,4,5]
	var arr02 = arr01.slice(1);
	
	var array02 = new arArray;
	array02[0] = new Array(1,2); 
	array02[1] = new Array(3,4); 
	array02[2] = new Array(5,6); 
	array02[3] = new Array(7,8);
	
	var Arrayslice = array02.slice(1,3); 
}

function saveArray(){
	var q = new Array();
	console.log(typeof q);
	//index에 상관없이 값을 입력 push
	q.push(10);
	q.push("first");
	q.push("second");
	q.push("thirdssssssssssssss");
	console.log(q);
	 
	 //shift array의 앞부터 잘나냄
	 var a0 = q.shift();
	//pop : 뒤에브타 잘ㄻ
	var b0 = q.pop();	
}





























