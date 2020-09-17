<%@ page   
	import = "java.io.*"
	import = "java.text.*"
	import = "java.lang.*"
	import = "java.sql.*"
	import = "java.util.ArrayList"
	import = "com.freewinesearcher.online.Webroutines"
	import = "com.freewinesearcher.common.Wine"
	import = "com.freewinesearcher.common.Wineset"
	import = "com.freewinesearcher.online.Searchdata"
	import = "com.freewinesearcher.common.Dbutil"
	import = "com.freewinesearcher.common.Knownwines"
	import = "com.freewinesearcher.batch.Spider"
	import = "java.util.regex.Matcher"
	import = "java.util.regex.Pattern"
	
%>

<%
	String id=Webroutines.filterUserInput(request.getParameter("id"));
	String url=Webroutines.filterUserInput(request.getParameter("url"));
	String winename=Webroutines.filterUserInput(request.getParameter("name"));
	if (winename==null) winename="";
	String ipaddress="";
	if (request.getHeader("HTTP_X_FORWARDED_FOR") == null) {
		ipaddress = request.getRemoteAddr();
	} else {
	    ipaddress = request.getHeader("HTTP_X_FORWARDED_FOR");
	}

	String hostcountry=Webroutines.getCountryCodeFromIp(ipaddress);
	if (hostcountry.equals("NZ")){
		out.print ("<br/><br/>This service is temporarily unavailable. Please try again later.");
		Webroutines.logWebAction("NZ: Access denied",url,ipaddress, request.getHeader("referer"), winename,"", 0,(float)0.0, (float)0.0,"", false, "", "", "", "",0.0);
		
	} else {
		Webroutines.logWebAction("Priceinfoquote",url,ipaddress, request.getHeader("referer"), winename,"", 0,(float)0.0, (float)0.0,"", false, "", "", "", "",0.0);

	String vintage="";
	String result="";
	Double average=0.0;
	Double minimum=0.0;
	Pattern pattern;
	Matcher matcher;
	pattern = Pattern.compile("(\\d\\d\\d\\d)");
	matcher = pattern.matcher(winename);
	if (matcher.find()){
		vintage=matcher.group(1);
		winename=winename.replaceAll("\\d\\d\\d\\d+","");
	}
	int knownwineid= Knownwines.determineKnownWineId(winename);
	if (knownwineid>0){
		winename=Dbutil.readValueFromDB("Select wine from knownwines where id="+knownwineid,"wine");
		average=Webroutines.getAveragePrice(knownwineid,vintage);
		minimum=Webroutines.getLowestPrice(knownwineid,vintage);
		
	} else {
		average=Webroutines.getAveragePrice(winename,vintage);
		minimum=Webroutines.getLowestPrice(winename,vintage);
	}
	
	if (average>0){
		result="{\"minprice\":"+Webroutines.formatPrice(minimum)+"}";
		
		}
	out.print(result);		
}
%>