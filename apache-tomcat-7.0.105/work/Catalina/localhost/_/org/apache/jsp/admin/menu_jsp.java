/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.105
 * Generated at: 2020-09-08 07:26:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.freewinesearcher.online.Ad;
import com.freewinesearcher.online.PageHandler;
import com.freewinesearcher.online.Webroutines;
import com.freewinesearcher.common.Configuration;
import java.util.HashSet;
import com.freewinesearcher.online.PageHandler;
import com.freewinesearcher.online.Webroutines;
import com.freewinesearcher.common.Dbutil;
import com.freewinesearcher.common.Configuration;
import com.freewinesearcher.common.Configuration;
import com.freewinesearcher.online.PageHandler;
import com.freewinesearcher.common.Dbutil;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/snippets/topbar.jsp", Long.valueOf(1598006156000L));
    _jspx_dependants.put("/snippets/textpage.jsp", Long.valueOf(1598006156000L));
    _jspx_dependants.put("/snippets/footer.jsp", Long.valueOf(1598006156000L));
    _jspx_dependants.put("/snippets/textpagefooter.jsp", Long.valueOf(1598006156000L));
    _jspx_dependants.put("/snippets/logoandsearch.jsp", Long.valueOf(1598006156000L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html><head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/header2.jsp", out, false);
      out.write("\r\n");
      out.write("</head><body>\r\n");
      out.write('\r');
      out.write('\n');
	int numberofimages=2;
	try {numberofimages=Integer.parseInt((String)request.getAttribute("numberofimages"));}catch (Exception e){}
 
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
 //PageHandler p=(PageHandler)request.getAttribute("pagehandler");
      out.write('\r');
      out.write('\n');
 String mobilelink="/m";
 if (PageHandler.getInstance(request,response).thispage.contains("/wine/")){
	 mobilelink=PageHandler.getInstance(request,response).thispage.replace("/wine/","/mwine/");
 } else if (PageHandler.getInstance(request,response).thispage.contains("/winery/")){
	 mobilelink=PageHandler.getInstance(request,response).thispage.replace("/winery/","/mwinery/");
 } else if (PageHandler.getInstance(request,response).thispage.contains("/region/")){
	 mobilelink=PageHandler.getInstance(request,response).thispage.replace("/region/","/mregion/");
 } else {
	mobilelink="/mobile.jsp"+(PageHandler.getInstance(request,response).searchdata.getName().length()>2?"?name="+Webroutines.URLEncode(Webroutines.removeAccents(PageHandler.getInstance(request,response).searchdata.getName()))+(PageHandler.getInstance(request,response).searchdata.getVintage().length()>3?"+"+PageHandler.getInstance(request,response).searchdata.getVintage():"").trim():"");
 }

      out.write("\r\n");
      out.write("<div class='topbar spriter spriter-refine'>\r\n");
      out.write("<div class='topbarcontent'><img src='");
      out.print(Configuration.static2prefix );
      out.write("/css/sprite4.png' style='display:none;width:1px;height:1px' alt=''/><img src='");
      out.print(Configuration.cdnprefix );
      out.write("/css/spriter.png' style='display:none;width:1px;height:1px' alt=''/>\r\n");
      out.write("<div id='mobile'>\r\n");
      out.write("<a href=\"");
      out.print(mobilelink);
      out.write("\">Mobile access</a>\r\n");
      out.write("<a href='");
      out.print((request.getAttribute("wineguidelink")==null?"/nf/wine-guide/":request.getAttribute("wineguidelink")));
      out.write("' rel='nofollow'>Wine Guide</a>\r\n");
      out.write("<a href='/settings/index.jsp' rel='nofollow'>PriceAlerts</a>\r\n");
      out.write("<a href='/retailers.jsp' rel='nofollow'>Getting listed</a>\r\n");
      out.write("<a href='/about.jsp' rel='nofollow'>About us</a>\r\n");
      out.write("<a href='/links.jsp' rel='nofollow'>Links</a>\r\n");
      out.write("<a href='/publishers.jsp' rel='nofollow'>For web site owners</a>\r\n");
      out.write("<!-- <a href='/Deals.jsp' rel='nofollow'>Deals</a> -->\r\n");
if (request.getRemoteUser()!=null) {
      out.write("<a href='/settings/index.jsp?logoff=true'>Log off</a>");
} 
      out.write("\r\n");
      out.write("</div>\r\n");
if (false){ 
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write("<div id='language'>");
      out.print(PageHandler.getInstance(request,response).t.get("language"));
      out.write(": \r\n");
      out.write("<a href='/lang-EN/wine/");
      out.print((Webroutines.URLEncode(PageHandler.getInstance(request,response).searchdata.getName()).replace("'","&apos;")+(PageHandler.getInstance(request,response).searchdata.getVintage().length()>3?"?vintage=" + PageHandler.getInstance(request,response).searchdata.getVintage():"")));
      out.write("'><img alt='English' src='/images/transparent.gif' class='sprite sprite-language sprite-english'/></a>\r\n");
      out.write("<a href='/lang-FR/wine/");
      out.print((Webroutines.URLEncode(PageHandler.getInstance(request,response).searchdata.getName()).replace("'","&apos;")+(PageHandler.getInstance(request,response).searchdata.getVintage().length()>3?"?vintage=" + PageHandler.getInstance(request,response).searchdata.getVintage():"")));
      out.write("'><img alt='Français' src='/images/transparent.gif' class='sprite sprite-language sprite-french'/></a>\r\n");
      out.write("<a href='/lang-NL/wine/");
      out.print((Webroutines.URLEncode(PageHandler.getInstance(request,response).searchdata.getName()).replace("'","&apos;")+(PageHandler.getInstance(request,response).searchdata.getVintage().length()>3?"?vintage=" + PageHandler.getInstance(request,response).searchdata.getVintage():"")));
      out.write("'><img alt='Nederlands' src='/images/transparent.gif' class='sprite sprite-language sprite-dutch'/></a>\r\n");
      out.write("</div>\r\n");
      out.write(" -->");
} 
      out.write("\r\n");
      out.write("&nbsp;\r\n");
      out.write("</div>\r\n");
      out.write("</div>");
      out.write("\r\n");
      out.write("<div class='textpage'>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class='logoandsearch' id='logoandsearch'>\r\n");
      out.write("\t\t<div class='logo'><a href=\"/\" title=\"Wine Searcher and Wine Prices Comparison\"><img src='");
      out.print(Configuration.cdnprefix);
      out.write("/css2/logo.png' alt='Vinopedia Wine Searcher and Price Comparison'/></a></div>\r\n");
      out.write("\t\t<div class='search'>\r\n");
      out.write("\t\t<div class='findwine'>");
      out.print(PageHandler.getInstance(request,response).t.get("searchwine"));
      out.write("</div>\r\n");
      out.write("\t\t\t");
// <img class='searchgosmall' alt='Search' src='/css2/gosmall.jpg' onclick='document.getElementById("searchform").submit()' />
      out.write("\r\n");
      out.write("\t\t\t<form action='");
      out.print(PageHandler.getInstance(request,response).searchpage);
      out.write("' method=\"post\" id=\"searchform\" name=\"searchform\" accept-charset=\"UTF-8\"><input type=\"hidden\" name=\"dosearch\" value=\"true\" /><input class='searchinput' id='name' type='text' name=\"name\" value=\"");
      out.print(Webroutines.escape((PageHandler.getInstance(request,response).searchdata.getName()+" "+PageHandler.getInstance(request,response).searchdata.getVintage()).trim()));
      out.write("\" size=\"25\" /></form>\r\n");
      out.write("\t\t\t<div class='sprite sprite-gosmall searchgosmall' onclick='document.getElementById(\"searchform\").submit()' ></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
 // <div id='plusone'><script type='text/javascript' defer="defer">/*<![CDATA[*/document.write('<g:plusone href="<%=PageHandler.getInstance(request,response).plusonelink % >"></g:plusone>');/*]]>*/</script></div>

      out.write('\r');
      out.write('\n');
 if (numberofimages>0){ 
      out.write("\r\n");
      out.write("<div id='right'>");

	String imagepath="/images/photos/";
 	HashSet<String> images=Webroutines.getRandomImages(application.getRealPath("/")+imagepath,numberofimages);
	int n=0;
 	for (String filename:images){
		n++;
		out.write("<img class='photo' src='"+imagepath+filename+"' alt='"+filename+"'/>");
	}
	if ("true".equals(request.getAttribute("ad"))){
	Ad rightad = new Ad("newdesign",160, 600, PageHandler.getInstance(request,response).hostcountry, PageHandler.getInstance(request,response).s.wineset.region, PageHandler.getInstance(request,response).s.wineset.knownwineid,"");
	out.write(rightad.html);
	}
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div id='left'>\t\r\n");
} else {	
      out.write("\r\n");
      out.write("\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "adminlinks.jsp", out, false);
      out.write('\r');
      out.write('\n');
 
	PageHandler.getInstance(request,response).getLogger().logaction();
	session.setAttribute("lasturl",PageHandler.getInstance(request,response).thispage);
	String canonicallink=(String)request.getAttribute("canonicallink");
	String regionlink=(String)request.getAttribute("regionlink");
	if (regionlink==null) regionlink="<a href='/region/'>Wines by region</a>";

      out.write("<div class='footer'><div id='links'><a href='/' rel='nofollow'>Home</a><a href='/links.jsp' rel='nofollow'>Links</a><a href='/contact.jsp' rel='nofollow'>Contact Vinopedia</a><a href='/about.jsp' rel='nofollow'>About us</a><a href='/termsofuse.jsp' rel='nofollow'>Terms of use</a>");
      out.print(regionlink);
 if (canonicallink!=null) out.write("<br/>"+canonicallink); 
      out.write("</div>\r\n");
      out.write("<div class='clear'></div><div id='copyright'>&#169; ");
      out.print(java.util.GregorianCalendar.getInstance().get(java.util.GregorianCalendar.YEAR));
      out.write(" Vinopedia.com</div></div>");

PageHandler.getInstance(request,response).firstrequest=false;
PageHandler.getInstance(request,response).cleanup();
//for (Cookie cookie:request.getCookies()) { 
//	if (cookie.getName().equals("wineid")||cookie.getName().equals("sort")||cookie.getName().equals("vintage")) {cookie.setMaxAge(0);response.addCookie(cookie);}
//}
 
      out.write("\t\r\n");
      out.write("</div> <!--  main-->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("</body></html>");
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
