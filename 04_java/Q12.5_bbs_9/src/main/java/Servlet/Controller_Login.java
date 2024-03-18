package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.db.DtoLogin;
import com.peisia.service.ServiceBoard;

@WebServlet("/Controller_Login/*")
public class Controller_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String category;
	String nextPage;
    ServiceBoard service; // 변수명 변경: Service -> service
    
    @Override
    public void init() throws ServletException {
        service = new ServiceBoard(); // ServiceBoard 클래스의 인스턴스 생성 및 할당
    }
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		category = request.getParameter("category");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getPathInfo();
		System.out.println("현재 액션 : "+action);
		if(action != null) {
			switch (action) {
			case "/login":
				String id =request.getParameter("ID");
				String pw =request.getParameter("PW");
				String user_name =request.getParameter("USER_NAME");
				
				String URL = service.login(id, pw);
					nextPage = URL;
				break;
			case "/join":
				DtoLogin dtoLogin = new DtoLogin( 
						request.getParameter("id"), 
						request.getParameter("pw"), 
						request.getParameter("pw_ck"),
						request.getParameter("userNAME")
						);
				String URL1 = service.join(dtoLogin);
				nextPage = URL1;
				break;
			}
		RequestDispatcher L = request.getRequestDispatcher(nextPage);
		L.forward(request, response); //이동실행문
	}}

}
