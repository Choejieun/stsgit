// JavaScript Document


$(function(){
	$("ul.nav>li").mouseover(function(){
		$(this).children(".submenu").stop().slideDown();
		});
			$("ul.nav>li").mouseleave(function(){
		$(this).children(".submenu").stop().slideUp();
		});
	
	});
	
	
start();

var imgs = 4;
var now = 0;

function start(){
	$(".imgs>img").eq(0).siblings().css({"margin-left":"-4000px"});
	setInterval(function(){slide()},1500);
	}
	
function slide(){
	now = now == imgs?0:now+=1;
	$(".imgs>img").eq(now-1).css({"margin-left":"-4000px"});
	$(".imgs>img").eq(now).css({"margin-left":"0px"});
}
	