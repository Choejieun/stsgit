package Main;

public class List {
	static public final int showIndex = 5; // 한번에 보여지는 값
	public static int totalPage;

	static public void run() {
	int StartIndex = 0; //첫 인덱스
	int currentPage = 1; //현재 페이지
	
	////	전체 페이지 수를 구하기	////전체 칼럼 내용물 수
	totalPage = 0;
	if(Data.getPostCount() % showIndex > 0) { // 나눈 수 의 나머지 계산
		totalPage = Data.getPostCount() / showIndex + 1; 
		Cw.wn("ㄱㄴ다");
	}else {
		Cw.wn("ㄱㄻㅈㄻㄹㄴ다");
		totalPage = Data.getPostCount() / showIndex; //나머지가 없으면
	}
//	예를 들어, 전체 게시물 수가 15이고, 한 페이지에 보여지는 게시물 수가 5라면:
//	15 % 5 = 0  *  ... totalPage =15 / 5 = 3
	Cw.wn("글 수  : "+Data.count);
	Cw.wn("총 페이지 수:"+totalPage);

//		result = st.executeQuery("select * from board");
		String showsss;
		while(true) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			showsss = Ci.r("페이지번호입력 (이전메뉴 x) : ");
			if(showsss.equals("x")) {
				break;
			}
			
			currentPage = Integer.parseInt(showsss); //수변환 int 상태
			if(currentPage > totalPage || currentPage < 1) {
				Cw.wn("페이지 범위에 맞는 값을 넣어주세요");
				continue;
			}
		StartIndex = (currentPage-1)*showIndex;
		Display.showLISt();
		String sql = "select * from board order by b_no limit "+StartIndex+","+showIndex+";"; //제한리스트 노출
		try {
//			Cw.wn("전송한sql문:"+sql);
			Data.result = Data.st.executeQuery(sql);
			while(Data.result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			String no = Data.result.getString("b_no");
			String hit12 = Data.result.getString("b_hit");
			String title = Data.result.getString("b_title");
			String id = Data.result.getString("b_id");
			String datetime = Data.result.getString("b_time");
			System.out.println(no+" "+title+" "+id+" "+datetime);
			}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}}}
