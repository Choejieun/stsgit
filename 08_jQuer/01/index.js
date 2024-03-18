$(function() {	// << 이렇게 jquery 3.0 식으로 줄여쓰기. 대신 맨 아래 닫는 괄호들 주의.
	var myDiv = $('#cat');		
	myDiv.on('click', function() {  // 요소에 클릭 이벤트 처리	
        myDiv.on('click', function() {		
            // 실행해서 클릭하면 이 함수들이 순차적으로 실행 됨.
            myDiv.animate({	 // 1. 애니메이션 대상 속성값 변경
                'width': '300px',
                'height': '200px',
                'background-color': '#00FFFF'
            }, 1000, 'linear');	
                
            myDiv.animate({	 // 2. opacity 변경
                'opacity': 0.5
            }, 1000, 'swing');	
                
            myDiv.animate({	 // 3. left, top 위치 변경
                'left': '+=100px',
                'top': '+=100px'
            }, 1000, 'swing');	
                
            myDiv.animate({	// 4. font-size 변경
                'font-size': '24px'
            }, 1000, 'swing');	
        });		
                

        
		// myDiv.animate({	
		// 	'width': '300px',
		// 	'height': '200px',
		// }, 1000, 'linear');	
			
		// myDiv.animate({	
		// 	'opacity': 0.5
		// }, 1000, 'swing');	
			
		// myDiv.animate({	
		// 	'left': '+=100px',
		// 	'top': '+=100px'
		// }, 1000, 'swing');	
			
		// myDiv.animate({	
		// 	'font-size': '24px'
		// }, 1000, 'swing');	

		// myDiv.animate({	
		// 	'opacity': 1
		// }, 1000, 'swing');

		// myDiv.animate({	
		// 	'width': '100px',
		// 	'height': '100px',
		// }, 1000, 'linear');	

		// myDiv.animate({	
		// 	'font-size': '18px'
		// }, 1000, 'swing');


	});	
});