package com.peisia.jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.peisia.c.util.Cw;
import com.peisia.jsp.board.BoardListProcessor;
import com.peisia.jsp.board.dto.Dto;
import com.peisia.jsp.board.service.ServiceBoard;

@WebServlet("/board/*")
public class ControllerBoard extends HttpServlet {
	String category;
	String nextPage;
	ServiceBoard service;
	@Override
	public void init() throws ServletException {
		service = new ServiceBoard();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		category = request.getParameter("category");
		String action = request.getPathInfo();
		Cw.wn("action:"+action);
		if(action!=null) {
			switch(action) {
			case "/del":
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함
				service.del(category,request.getParameter("no"));	//🐇서비스🐇:삭제 기능
				break;
			case "/write":
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함
				Dto dto = new Dto(
						category,
						request.getParameter("title"),
						request.getParameter("id"),
						request.getParameter("text")
						);
				service.write(dto);	//🐇서비스🐇:쓰기 기능				
				break;
			case "/edit_insert":
				Cw.wn("수정-insert");
				nextPage="/edit.jsp";
				request.setAttribute("post", service.read(category, request.getParameter("no")));	//🐇서비스🐇:수정 기능				
				break;
			case "/edit_proc":
				Cw.wn("수정-proc");
				nextPage="/board/list";	//컨트롤러 리스트를 타게 수정함				
				service.edit(
						new Dto(
								request.getParameter("title"),
								request.getParameter("text")
								)
						,request.getParameter("no")
						);	//🐇서비스🐇:수정 기능				
				break;
			case "/read":
				nextPage="/read.jsp";
				Dto d=service.read(category, request.getParameter("no"));	//🐇서비스🐇:읽기 기능
				request.setAttribute("post", d);
				break;
			case "/list":
				//리스트 관련 각종 처리를 다 한 BoardListProcessor 객체 넘기기.
				//서비스 : 컨트롤러에서 로직처리를 분리해버린 담당 클래스
				nextPage="/list.jsp";
				BoardListProcessor blp = service.list(category, request.getParameter("page"),request.getParameter("word"));	//🐇서비스🐇:리스트 기능
				request.setAttribute("blp", blp); //어떤 것이든 저장가능, 사용 시 형변환 해주면 됨
				break;
			}
			System.out.println("현재 액션"+action);
			RequestDispatcher d = request.getRequestDispatcher(nextPage); //nextPage로 저장 해 놓은 페이지로 이동
			d.forward(request,response);
		}
	}
}