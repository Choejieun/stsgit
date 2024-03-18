package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcBoard {

	int a;
	void run() {
		Data.dbInit(); //데이터 불러오기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		Display.showTitle();
		while (true) {
		Display.showMainMenu();

			System.out.println("명령 : ");
			String cmd = sc.next();
			switch (cmd) {
			case "1":	//글리스트
				List.run();
				break;
			case "2":
				System.out.println("읽을 글 번호를 입력해주세요:");
				String readNo = sc.next();
				String sql2 = "select * from board where b_no ="+readNo;
//				System.out.println(sql2);
				try {
					Data.result = Data.st.executeQuery(sql2);
					Data.result.next();
					String title = Data.result.getString("b_title");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String content = Data.result.getString("b_text");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					String id = Data.result.getString("b_id");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
					System.out.print("글제목: "+title);
					System.out.println("  / 작성자: "+id);
					System.out.println("글내용: "+content);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				break;
			case "3":
				//todo
				System.out.println("제목을 입력해주세요:");
				String title = sc.next();
				System.out.println("글내용을 입력해주세요:");
				String content = null;
				try {
					content = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("작성자id를 입력해주세요:");
				String id = sc.next();
				
				String x = String.format(
						"insert into board (b_title,b_ID,b_time,b_text,b_hit) "
						+ "values ('%s','%s',now(),'%s',0);"
						,title,id,content) ;
				dbExecuteUpdate(x);			
				
				System.out.println("글등록 완료");
				break;
			case "4":
				System.out.println("글삭제");
//				delete from board where b_no = 1;
				
				System.out.println("삭제할 글 번호를 입력하세요");
				String no = sc.next();
				
				String nox = String.format(
						"delete from board where b_no = '%s';"
						,no) ;
				dbExecuteUpdate(nox);			
				
				System.out.println("글삭제 종료");
				
				break;
			case "5":
				System.out.println("글 수정");
				
				System.out.println("수정할 글번호를 입력해주세요");
				String REno = sc.next(); // 넘버지정
				
				System.out.println("제목을 입력해주세요:");
				String REtitle = sc.next(); // 제목수정
				
				System.out.println("글내용을 입력해주세요:");
				String REcontent = null; //내용수정
				try {
					REcontent = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("작성자id를 입력해주세요:");
				String REid = sc.next(); //아이디수정
				
				String REx = String.format(
						"update board set b_title = '%s', b_time = now(), b_text = '%s', b_id = '%s'  where b_no ='%s';"
						,REtitle,REcontent,REid,REno) ;
				dbExecuteUpdate(REx);			
				
				System.out.println("글 수정 완료");
				
				break;
			case "0":
				System.out.println("관리자");
				break;
			case "e":
				System.out.println("종료");
				return;
			}
		}

		
//		dbExecuteQuery("select * from tottenham_squad where p_number=7");
		
		
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("글제목을 입력해주세요:");
//		String title = sc.next();
		
		
//		dbExecuteUpdate("insert into board (b_title,b_id,b_datetime,b_text,b_hit) values ('"+ title +"','kitty',now(),'콘솔프로그램에서 작성한 글입니다. 글글.....글....',0);");
	}
	

	private void dbExecuteUpdate(String query) {
		try {
			int resultCount = Data.st.executeUpdate(query);
			if (resultCount >= 1) {
			System.out.println("처리된 행 수:"+resultCount);}
			else {
				System.out.println("처리 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("SQLException: " + e.getMessage());
//			System.out.println("SQLState: " + e.getSQLState());
		}
	}	
}

