function tv(s){	

	// document.write(s);
    maintextarea.value += s;
}
function tv3(s){	
	screenPlayerInfo.value += s;
}




function hr(){	
	// document.write("<hr>");

	str = str + "\n==============================================\n";

	t.value = str;

}
function br(){	
	// document.write("<br>");
	str = str + "\n";
	t.value = str;
}

function r(n){
	var random = Math.floor(Math.random() * n) + 1; // 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑아주는 애.
	return random;
}
