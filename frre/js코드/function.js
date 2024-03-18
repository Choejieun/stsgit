function x() {

    return "고양이";
    //고양이 값을 되돌려준다. 이후 코드는 사용하지 않는다.
}

var cat = x();
// cat = "고양이";

document.write(cat);
//결과값 = 고양이


function xx(n){

        if(n == 1){
            document.write("가나다");
        }
}

var rpc = x(2);
document.write(rpc);