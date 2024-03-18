package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.db.Dto;
import com.peisia.list.Setting;
import com.peisia.service.Service;

@WebServlet("/board/*")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String topick;
    String nextPage;
    Service service;

    @Override
    public void init() throws ServletException {
        // 서블릿 초기화 시 Service 객체 초기화
        service = new Service();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        handleRequest(request, response);
    	doPost(request, response);
    	System.out.println("도달");
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        topick = request.getParameter("topick");
        String action = request.getPathInfo();
        System.out.println("현재 액션 : " + action);

        if (action != null) {
            switch (action) {
                case "/list":
                    nextPage = "/list.jsp";
					Setting blp = service.list(topick, request.getParameter("word"),request.getParameter("page"),request.getParameter("old"));
					request.setAttribute("blp", blp);
					break;
                case "/read":
                    request.setCharacterEncoding("UTF-8");
                    nextPage = "/read.jsp";
                    String num = request.getParameter("num");
                    Dto r = service.read(topick,num);
                    request.setAttribute("post", r);
                    break;
                case "/write":
                    request.setCharacterEncoding("UTF-8");
                    Dto dto = new Dto(
                            request.getParameter("title"),
                            request.getParameter("id"),
                            request.getParameter("content"),
                            null,
                            request.getParameter("topick_new")
                    );
                    nextPage = "/board/list?topick="+request.getParameter("topick_new")+"&old="+request.getParameter("old");
                    service.write(dto);
                    break;
                    
                case "/modify":
                    nextPage = "/modify.jsp";
                    request.setAttribute("post", service.read(topick, request.getParameter("num")));
                    break;
                    
                case "/modify_edit":
                	nextPage = "/board/list?topick="+request.getParameter("topick_new")+"&old="+request.getParameter("old");
                	service.modify(new Dto(
                            request.getParameter("title"),
                            request.getParameter("content"),
                            request.getParameter("topick_new")
                			)
                			,request.getParameter("no"));
                    break;

                case "/del":
                    nextPage = "/read.jsp";
                    break;
            }
            System.out.println("이동할 페이지 : "+nextPage);
            RequestDispatcher a = request.getRequestDispatcher(nextPage);
            a.forward(request, response); // 이동실행문
        }
    }
}
