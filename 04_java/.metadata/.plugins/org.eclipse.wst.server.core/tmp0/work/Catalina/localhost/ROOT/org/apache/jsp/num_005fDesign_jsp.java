/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.80
 * Generated at: 2024-02-05 03:27:57 UTC
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

public final class num_005fDesign_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"CSS/common.css?ver=");
      out.print( System.currentTimeMillis() );
      out.write("\">\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("				<div id=\"bottom\">\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 시작 [1]		 -->		\r\n");
      out.write("					<div>			\r\n");
      out.write("					");

					//이전 버튼
					if (PrevNaxtProc.hasPrev){
						if(Setting.searchWord == null){ //키워드 X
							System.out.println("이전 : "+PrevNaxtProc.prevPage);
							
      out.write("\r\n");
      out.write("								<a href=\"list.jsp?page=");
      out.print(PrevNaxtProc.prevPage );
      out.write("\">Prev</a>\r\n");
      out.write("							");

						}else{
							
      out.write("\r\n");
      out.write("							<a href=\"list.jsp?page=");
      out.print(PrevNaxtProc.prevPage );
      out.write("&word=");
      out.print(Setting.searchWord);
      out.write(" \">Prev</a>\r\n");
      out.write("						");

						}}
					
      out.write("	\r\n");
      out.write("					</div>\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 종료 [1]		 -->\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->\r\n");
      out.write("					<div id=\"num\">\r\n");
      out.write("					");

					if (PrevNaxtProc.hasPrev){ // 1번
						if(Setting.searchWord == null){ //키워드 X
							System.out.println("이전 : "+PrevNaxtProc.prevPage);
							
      out.write("\r\n");
      out.write("								<a href=\"list.jsp?page=1\">1 ···</a>\r\n");
      out.write("							");

						}else{
							
      out.write("\r\n");
      out.write("							<a href=\"list.jsp?page=1&word=");
      out.print(Setting.searchWord);
      out.write(" \">1 ···</a>\r\n");
      out.write("						");
			}}			
      out.write("	\r\n");
      out.write("<!-- 						/////////////////////////////////////////////////////////////////////////////////////////// -->\r\n");
      out.write("						");

					for(int i = PageBlock_F.start_Block; i <= PageBlock_F.end_Block; i++ ){
						if(i == PageBlock_F.npageNum){
							
      out.write("\r\n");
      out.write("							<strong>[ ");
      out.print(i );
      out.write(" ]</strong>\r\n");
      out.write("							");

						}else{
							if(Setting.searchWord == null){ //키워드 X
								
      out.write("\r\n");
      out.write("									<a href=\"list.jsp?page=");
      out.print(i );
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a>\r\n");
      out.write("								");

							}else{
								String urlEncodedSearchWord = java.net.URLEncoder.encode(Setting.searchWord);	
								
      out.write("\r\n");
      out.write("								<a href=\"list.jsp?page=");
      out.print(i );
      out.write("&word=");
      out.print(Setting.searchWord);
      out.write(' ');
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a>\r\n");
      out.write("							");
			}	}	}			
      out.write("	\r\n");
      out.write("<!-- 						/////////////////////////////////////////////////////////////////////////////////////////// -->\r\n");
      out.write("							");

					Dao dao = new Dao(); 	//마지막 숫자
					if (PrevNaxtProc.hasNext){
						if(Setting.searchWord == null){ //키워드 X
							
      out.write("\r\n");
      out.write("								<a href=\"list.jsp?page=");
      out.print(dao.getTotalPagecount());
      out.write("\">··· ");
      out.print(dao.getTotalPagecount());
      out.write("</a>\r\n");
      out.write("							");
	}else{	
      out.write("\r\n");
      out.write("							<a href=\"list.jsp?page=");
      out.print(dao.getSearchTotalPagecount(Setting.searchWord));
      out.write("\r\n");
      out.write("							&word=");
      out.print(Setting.searchWord);
      out.write(" \">··· ");
      out.print(dao.getSearchTotalPagecount(Setting.searchWord));
      out.write("</a>\r\n");
      out.write("						");
}}
      out.write("	\r\n");
      out.write("						</div>\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 종료 [2]		 -->																		\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 시작 [3]		 -->		\r\n");
      out.write("					<div>\r\n");
      out.write("					");

					//다음 버튼
					if (PrevNaxtProc.hasNext){
						if(Setting.searchWord == null){ //키워드 X
							
      out.write("\r\n");
      out.write("								<a href=\"list.jsp?page=");
      out.print(PrevNaxtProc.naxtPage );
      out.write("\">Next</a>\r\n");
      out.write("							");

						}else{
							
      out.write("\r\n");
      out.write("							<a href=\"list.jsp?page=");
      out.print(PrevNaxtProc.naxtPage );
      out.write("&word=");
      out.print(Setting.searchWord);
      out.write(" \">Next</a>\r\n");
      out.write("						");

						}
						}
					
      out.write("	\r\n");
      out.write("					</div>\r\n");
      out.write("					<!-- 	하단 버튼 출력 영역 종료 [3]		 -->\r\n");
      out.write("				</div>\r\n");
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
