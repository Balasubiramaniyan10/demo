<%@page import = "com.freewinesearcher.batch.Spider"%><form action='/mobile.jsp' method="post" id="searchform" ><div class="searchform">Name of wine with or without vintage:<br/><input type="text" id="name" name="name" value="<%=Spider.escape(searchdata.getName()+" "+searchdata.getVintage()).trim()%>" size="40" onkeypress="return navigationkeys(event);" onkeyup="return searchSuggest(event);" onkeydown="keyDown(event);" /><div id="search_suggest" class="search_suggest_hidden" ></div>(e.g. <a href='/mwine/Chateau+Rieussec+2001'>Rieussec 2001</a>)<br/>Country of Seller<br/><select name="country"><option value="All"<%if (searchdata.getCountry().equals("All")) out.print(" selected='selected'");%>>All</option><%
for (int i=0;i<countries.size();i=i+2){
		%><option value="<%=countries.get(i)%>"<%if (searchdata.getCountry().equals(countries.get(i))) out.print(" selected=\"selected\"");%>><%=countries.get(i+1)%></option><%
}
		%></select><input type="submit" value="Search" /><div class='currency'><%=PageHandler.getInstance(request,response).t.get("displaycurrency")%>
		<input type="radio" name="currency" value="EUR"  onchange='javascript:document.getElementById("refineform").submit();' <%if (PageHandler.getInstance(request,response).searchdata.getCurrency().equals("EUR")||PageHandler.getInstance(request,response).searchdata.getCurrency().equals("")) out.print(" checked=\"checked\"");%> />&#8364;&#160;<input type="radio" name="currency" value="GBP"  onchange='javascript:document.getElementById("refineform").submit();' <%if (PageHandler.getInstance(request,response).searchdata.getCurrency().equals("GBP")) out.print(" checked=\"checked\"");%> />&#163;&#160;<input type="radio" name="currency" value="USD"  onchange='javascript:document.getElementById("refineform").submit();' <%if (PageHandler.getInstance(request,response).searchdata.getCurrency().equals("USD")) out.print(" checked=\"checked\"");%> />$&#160;<input type="radio" name="currency" value="CHF"  onchange='javascript:document.getElementById("refineform").submit();' <%if (PageHandler.getInstance(request,response).searchdata.getCurrency().equals("CHF")) out.print(" checked=\"checked\"");%> /><span style='font-size:9px;'>CHF</span>
		</div><div><input type="hidden" id="dosearch" name="dosearch" value="true" /><input type="hidden" id="order" name="order" value="" /><input type="hidden" id="createdstring" name="createdstring" value="0" /></div></div></form><script type='text/javascript'>document.getElementById("name").setAttribute("autocomplete","off");</script>