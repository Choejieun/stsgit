/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2024-03-07 05:53:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.MangoChat.LoginDB.L_Dto;
import java.util.ArrayList;
import com.MangoChat.util.Util;
import com.MangoChat.FriendDB.F_Dao;

public final class friendList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.MangoChat.util.Util");
    _jspx_imports_classes.add("com.MangoChat.LoginDB.L_Dto");
    _jspx_imports_classes.add("com.MangoChat.FriendDB.F_Dao");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

	String myUserNo = (String) session.getAttribute("userNo");
	String roomNo = request.getParameter("roomNo");
	String mag = request.getParameter("mag");
	F_Dao fdao = new F_Dao();
	Util util = new Util();
	ArrayList<String> friendList = fdao.friendList(myUserNo);
	if(friendList == null){
		
      out.write("친구가 없습니다.");

	} else {
	if (friendList.size() > 0) {

		if (mag != null) { // 초대가 안될떄 안되는 이유를 출력해주는함수
			if (mag.equals("invite")) {
	
      out.write("<hr> 이미 초대를 보낸 유저입니다.");

	} else if (mag.equals("join")) {
	
      out.write("이미 채팅방에 소속된 유저입니다. <hr>");

	}
	}
	for (String list : friendList) {
	L_Dto user = util.userName(list);
	
      out.write("\r\n");
      out.write("	<div id=\"friendList\">\r\n");
      out.write("	<a class=\"userName\">");
      out.print(user.userName);
      out.write("</a><a class=\"userTag\">#");
      out.print(user.userTag);
      out.write("</a>\r\n");
      out.write("	");

	if (!roomNo.equals("null")) {
	
      out.write("\r\n");
      out.write("			<div id=\"friendInput\">\r\n");
      out.write("		<form action=\"/chat/roomInvite\" method=\"get\">\r\n");
      out.write("			<input type=\"hidden\" name=\"roomNo\" value=\"");
      out.print(roomNo);
      out.write("\"> <input\r\n");
      out.write("				type=\"hidden\" name=\"userNo\" value=\"");
      out.print(list);
      out.write("\"> <input\r\n");
      out.write("				type=\"submit\" value=\"채팅방 초대\">\r\n");
      out.write("		</form>\r\n");
      out.write("\r\n");
      out.write("	");

	}
	
      out.write("\r\n");
      out.write("		<form action=\"/chat/freindDel\" method=\"get\">\r\n");
      out.write("			<input type=\"hidden\" name=\"userNo\" value=\"");
      out.print(list);
      out.write("\"> <input\r\n");
      out.write("				type=\"submit\" value=\"친구 삭제\">\r\n");
      out.write("		</form>\r\n");
      out.write("		</div>\r\n");
      out.write("			</div>\r\n");
      out.write("	");

	}
	} else {
	
      out.write("\r\n");
      out.write("	친구가 없습니다.\r\n");
      out.write("	");

	}
	}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
