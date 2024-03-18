document.write("<p>가위바위 보 도박</p>");
document.write("<button>시작</button>");
var m = 10;
var p

window.onload = function(){

    rpcInputText = document.getElementById("rpc_input_text");       // 연결

}


function start(){

        // 현재 가진 돈이 0 이하이면 초기화
        if (m <= 0) {
            alert("가진 돈이 부족하여 초기화됩니다.");
            m = 10; // 초기 가진 돈으로 설정
                    // 버튼 클릭 시 페이지 새로고침
            location.reload();
            
        }


        while(true){
            // var p = prompt("안내면 진거");
            p = rpcInputText.value;

            if (p == "가위" || p == "보" || p == "바위"){
                break;
            }
            else{                alert("이게 아닌데");
        }
        }


var c = Math.floor(Math.random() * 3) + 1;
var go = "";


document.write(p+"<br>");

switch (c) {
    case 1:
    var c = "가위"
        break;
    case 2:
        var c = "바위"
        break;
    case 3:
        var c = "보"
        break;
}

document.write(c+"<br>");


var windrawlose = "";

switch (p){
    case "가위" :
            switch (c) {
                case "가위" :
                        windrawlose = "무승부";
                    break;
                case "바위" :
                        windrawlose = "패배";
                        m = m-20;
                    break
                case "보" :
                        windrawlose = "승리";
                        m = m+10;
                    break
            }
    break;
    case "바위" :
            switch (c) {
                case "가위" :
                    windrawlose = "승리";
                    m = m+10;
                    break
                case "바위" :
                    windrawlose = "무승부";
                    break
                case "보" :
                    windrawlose = "패배";
                    m = m-20;
                    break
            }
    break;
    case "보" :
            switch (c) {
                case "가위" :
                    windrawlose = "승리";
                    m = m+10;
                    break
                case "바위" :
                    windrawlose = "패배";
                    m = m-20;
                    break
                case "보" :
                    windrawlose = "무승부";
                    break
            }
    break;
}

document.write("<br>"+windrawlose+"<br><br>");
document.write("현재가진 돈"+m+"<br>");


 // 새 버튼 생성
 var newButton = document.createElement("button");
 newButton.textContent = "재도전";
 newButton.id = "restartButton";
 
 document.body.appendChild(newButton);

 // 새 버튼에 이벤트 리스너 추가
 newButton.addEventListener("click", function() {
     // 버튼 클릭 시 다시 start 함수 호출...허나 적을 칸이 없다.
     start();
     // 현재 버튼 제거
     newButton.parentNode.removeChild(newButton);
 });
}







document.addEventListener("DOMContentLoaded", function() {
    var button = document.querySelector("button");
    var paragraph = document.querySelector("p");

    button.addEventListener("click", function() {
        start();
        button.style.display = "none";
    });
});

