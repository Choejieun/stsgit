var a=[1,2,3];
dw(a[1]);

hr();

var b=[];
b.push(4);
b.push(5);
dw(b[1]);

hr();

var c=new Array();
c.push(6);
c.push(7);
dw(c[1]);

hr();

var d=new Array();
d=[1,2,3];
dw(d[0]);

hr();

var e=new Array(3);
e[0]=9;
e[1]=8;
dw(e[0]);
dw(e[1]);
dw(e.length);   //101이 나옴. f[100] = 값 넣는순간 사이즈가 101이 되버림.

hr();

var f=new Array();
f[1]=8;
f[100]=10000;   //이런게 되긴함. but.. 쫌...
dw(f[0]);
dw(f[1]);
dw(f[100]);     //이런게 되긴함. but.. 쫌... 값이 잘 찍히긴 찍힘
dw("<br>");     //이런게 되긴함. but.. 쫌... 값이 잘 찍히긴 찍힘
dw(f.length);   //101이 나옴. f[100] = 값 넣는순간 사이즈가 101이 되버림.