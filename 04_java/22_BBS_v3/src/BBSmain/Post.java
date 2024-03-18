package BBSmain;

import java.time.LocalDate;

import uitn.Cw;
import uitn.Material;

public class Post {
	
	static public int no = 0;
	public int noSetup = 0;
	public String title;
	public String texts;
	public String write;
	public int hit;
	public String date; //날짜 이지만 숫자가 아닌, 버퍼된 문자열 데이터를 받을 예정
	
	public Post(String title,String texts, String write, int hit) {
		no = no+1; //생성자 함수 메소드 시 마다 숫자 1증가
		noSetup = no;
		this.title = title; //this.이 클래스의 객체를 추적 = 생성자 함수의 객체를 추적
		this.texts = texts;
		this.write = write;
		this.hit = hit;
		LocalDate now = LocalDate.now();
		  date = now.toString();
	};
	



public void infoList() {  // post 생성자 함수 하위의 객체를 인식하지 못하므로 this 를 붙일 필요가 없다.
		Cw.W("[ "+noSetup); 
		Cw.W(" ]  [ 글 제목 : "+title); 
		Cw.W(" ] [ 글 작성자 : "+write);
		Cw.W(" ] [ 조회수 : "+hit);
		Cw.Wn(" ] [ 작성일 : "+date+" ]");
		Material.line();
	}
 
 public void infoListBest() {  // post 생성자 함수 하위의 객체를 인식하지 못하므로 this 를 붙일 필요가 없다.
	 Cw.Wn("[ 베스트 게시글 ]" ); 
	 Cw.W("[ "+noSetup); 
	 Cw.W(" ]  [ 글 제목 : "+title); 
	 Cw.W(" ] [ 글 작성자 : "+write);
	 Cw.W(" ] [ 조회수 : "+hit);
	 Cw.Wn(" ] [ 작성일 : "+date+" ]");
	 Material.line();
 }
 
 public void info() {  // post 생성자 함수 하위의 객체를 인식하지 못하므로 this 를 붙일 필요가 없다.
		Cw.W("[ 글 제목 : "+title); 
		Cw.W(" ] [ 글 작성자 : "+write);
		this.hit=this.hit+1;
		Cw.W(" ] [ 조회수 : "+hit);
		Cw.Wn(" ] [ 작성일 : "+date+" ]");
		Material.line();
		Cw.Wn("- 글 내용  : "+texts);
		Material.line();
	}

}
