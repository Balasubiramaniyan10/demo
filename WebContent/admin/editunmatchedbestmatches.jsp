<html>

<head>
<%@ page 
	import = "java.util.ArrayList"
	import = "java.util.List"
	import = "java.util.Iterator"
	import = "java.util.ListIterator"
	import = "java.io.*"
	import = "java.net.*"
	import = "java.text.*"
	import = "java.lang.*"
	import = "java.sql.*"
	import = "com.freewinesearcher.common.Knownwines"
	import = "com.freewinesearcher.common.Wineset"
	import = "com.freewinesearcher.common.Wijnzoeker"
	import = "com.freewinesearcher.online.Webroutines"
	import = "com.freewinesearcher.batch.Spider"
	import = "com.freewinesearcher.common.Variables"
	import = "com.freewinesearcher.common.Dbutil"
	import = "com.freewinesearcher.common.Region"
	
	
%>
<script type="text/javascript">

var g_remoteServer = '/admin/updateknownwinerow.jsp?id=';
function updateValue(id,actie){
	value="";
	if (actie!="disable"){
	value=document.getElementById(actie+id).value;
	}
	script = document.createElement('script');	
	if (actie=="fulltext") while (value.indexOf('+')>-1) {
	value=value.replace('+','|');
	}
	script.src = g_remoteServer+id+"&value="+escape(value)+"&actie="+actie;	
	script.type = 'text/javascript';	
	script.defer = true;	
	script.id = 'lastLoadedCmds';	
	document.getElementById('result').innerHTML='';
	document.getElementById('result').appendChild(script);

	}

</script>

<script type="text/javascript">
function mark(elm){
elm.innerHTML='';
}

</script>
<div id='result'></div>
<title>
Unmatched Wines editor
</title>
</head>
<body>
<%String appellation = request.getParameter("appellation");
if (appellation==null||appellation.equals("All")) appellation="%";
 %>
<jsp:include page="/admin/adminlinks.jsp" />

<%	
out.print(Knownwines.editBestMatchUnmatchedWinesHTML());
%>
</body> 
</html>