package xxx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = (String)request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("cat") && pw.equals("1234")) {
			request.setCharacterEncoding("UTF-8");
            // 로그인 성공 시 세션 생성
            HttpSession session = request.getSession();
            session.setAttribute("idKey", id);
            session.setMaxInactiveInterval(300); //5초 제한
            
            PrintWriter out = response.getWriter();
            out.println("<a href = index2.jsp>id show</a>");
		}
		
		System.out.println(id);
		System.out.println(pw);
	}

}
