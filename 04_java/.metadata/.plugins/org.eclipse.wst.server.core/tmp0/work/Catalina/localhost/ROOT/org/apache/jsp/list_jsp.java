/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2024-02-07 05:23:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.peisia.list.PrevNaxtProc;
import com.peisia.list.PageBlock_F;
import org.apache.naming.HandlerRef;
import com.peisia.db.Dto;
import java.util.ArrayList;
import com.peisia.db.Dao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import com.peisia.db.Board;
import com.peisia.list.Setting;
import com.peisia.list.PageBlock_F;
import com.peisia.list.PrevNaxtProc;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("com.peisia.db.Dao");
    _jspx_imports_classes.add("com.peisia.list.Setting");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("org.apache.naming.HandlerRef");
    _jspx_imports_classes.add("java.sql.DatabaseMetaData");
    _jspx_imports_classes.add("com.peisia.list.PageBlock_F");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("com.peisia.db.Board");
    _jspx_imports_classes.add("com.peisia.db.Dto");
    _jspx_imports_classes.add("com.peisia.list.PrevNaxtProc");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("java.sql.Statement");
    _jspx_imports_classes.add("java.sql.DriverManager");
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

      out.write("<!-- 자바연결 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 이 import 문 추가 -->\r\n");
      out.write("<!-- 자바연결 -->\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"/CSS/common.css?ver=");
      out.print(System.currentTimeMillis());
      out.write("\">\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>커뮤니티 8버전</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- 	세팅 시작		 -->\r\n");
      out.write("	");

    request.setCharacterEncoding("UTF-8");
	Setting blp = (Setting) request.getAttribute("blp"); //서블릿~서비스에서 만들어 놓은 함수 호출
	ArrayList<Dto> posts = blp.getPosts(); //위 과정에서 만든 데이터 컬렉션 호출
	
      out.write("\r\n");
      out.write("	<!-- 	세팅 종료		 -->\r\n");
      out.write("	<div id=\"warp\">\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "x_top_list_Design.jsp", out, false);
      out.write("\r\n");
      out.write("		<div id=\"bbs\">\r\n");
      out.write("\r\n");
      out.write("			<!-- 	값 노출 시작		 -->\r\n");
      out.write("			");

			for (int i = 0; i < posts.size(); i = i + 1) {
			
      out.write("\r\n");
      out.write("			<div id=\"bottom_bar\">\r\n");
      out.write("				<div id=\"idtext\">\r\n");
      out.write("					[");
      out.print(posts.get(i).num);
      out.write("] 🤷‍♀️");
      out.print(posts.get(i).id);
      out.write('/');
      out.print(posts.get(i).datatime);
      out.write("</div>\r\n");
      out.write("				<a href=\"/board/read?num=");
      out.print(posts.get(i).num);
      out.write("&topick=");
      out.print(posts.get(i).topick);
      out.write("\"><strong>");
      out.print(posts.get(i).title);
      out.write("</strong></a>\r\n");
      out.write("			</div>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("			<!-- 	값 노출 종료		 -->\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "x_num_Design.jsp", out, false);
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "x_right_Design.jsp", out, false);
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
