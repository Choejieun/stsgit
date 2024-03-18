package Main;


public class Display {
	static private String TITLE_BAR = "🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈"; 
	static private String TITLE 	= "🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈     게시판     🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈🐈"; 
	
	static private String MAIN_MENU_BAR = "================================================================";
	static private String MAIN_MENU	 	= "[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [0]관리자 [e]종료";
	
	static public void showTitle() {
		System.out.println(TITLE_BAR);
		System.out.println(TITLE);
		System.out.println(TITLE_BAR);
	}
	
	static public void showMainMenu() {
		System.out.println(MAIN_MENU_BAR);
		System.out.println(MAIN_MENU);
		System.out.println(MAIN_MENU_BAR);
	}
	static public void showLISt() {
		System.out.println("==========================================");
		System.out.println("================= 글리스트 ==================");
		System.out.println("==========================================");
		System.out.println("글번호 글제목 작성자id 작성시간");
		Cw.wn("총 페이지 수:"+List.totalPage);
	}
}


