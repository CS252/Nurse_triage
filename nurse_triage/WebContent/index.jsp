<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script type="text/javascript">
function lookup(inputString) {
if(inputString.length == 0) {
$('#suggestions').hide();
} else {
$.post("states.jsp", {queryString: ""+inputString+""}, function(data){
if(data.length >0) {
$('#suggestions').show();
$('#autoSuggestionsList').html(data);
}
});
}
}
function fill(thisValue) {
$('#inputString').val(thisValue);
setTimeout("$('#suggestions').hide();", 200);
}
</script>
<style type="text/css">
body {
font-family: Helvetica;
font-size: 13px;
color: #000;
}
h3 {
margin: 0px;
padding: 0px;
}
.suggestionsBox {
position: relative;
left: 260px;
margin: 0px 0px 0px 0px;
width: 200px;
background-color: #7845DD;
-moz-border-radius: 7px;
-webkit-border-radius: 7px;
border: 2px solid #000;
color: #fff;
}
.suggestionList {
margin: 0px;
padding: 0px;
}
.suggestionList li {




margin: 0px 0px 3px 0px;
padding: 3px;
cursor: pointer;
}
.suggestionList li:hover {
background-color: #DD45CD;
}
</style>
<!--<script type="text/javascript">
function getXMLObject()  //XML OBJECT
{
    var xmlHttp = false;
    try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP")  // For Old Microsoft Browsers
    }
    catch (e) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")  // For Microsoft IE 6.0+
        }
        catch (e2) {
            xmlHttp = false   // No Browser accepts the XMLHTTP Object then false
        }
    }
    if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
        xmlHttp = new XMLHttpRequest();        //For Mozilla, Opera Browsers
    }
    return xmlHttp;  // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject();   //xmlhttp holds the ajax objec
function showHint(str)
{
var xmlhttp;
if (str.length==0)
  {
  document.getElementById("message").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("message").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","FetcherServlet?q="+str,true);

xmlhttp.onreadystatechange  = handleServerResponse;

xmlhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
xmlhttp.send(null);
}
function handleServerResponse() {
    if (xmlhttp.readyState == 4) {
        if(xmlhttp.status == 200) {
           getVal();
        }
        else {
            alert("Error during AJAX call. Please try again");
        }
    }
}
function getVal()
{
     var xmlResp=xmlhttp.responseText;
     try{

        if(xmlResp.search("Maintag")>0 )
        {
       var x=xmlhttp.responseXML.documentElement.getElementsByTagName("Subtag");
            var xx=x[0].getElementsByTagName("unameVal"); 
            var recievedUname=xx[0].firstChild.nodeValue;
           document.getElementById("message").innerText=recievedUname;//here 
        } 
        }catch(err2){
            alert("Error in getting data"+err2);
        }
}
</script>-->
</head>
<body>
<div id= "leftpanel">
	<div id = "tasks">
		<table>
		<c:forEach var="task" items="${tasklist}">
			<tr>
				<td>${task.getId()}</td>
				<td>${task.getName()}</td>
			</tr>
		</c:forEach>
		</table>
	</div>
</div> 
<% //session = request.getSession();
   String group = (String) session.getAttribute("group"); 
%>
<div id = "rightpanel">
	<div id = "details">
	<c:choose>
		<c:when test="${group=='nurse'}" >
		Hello Nurse
		</c:when>
		<c:when test="${group=='management'}" >
		<form action="StartWorkFlow" method="get">
	    <input type="text" name="patientid">
	    <input type = "submit" value = "Proceed" name = "PatientId">
	    </form>
		</c:when>
		<c:otherwise>
			<form>
<div> <h3><font color="red">Indian States</states></font></h3> <br /> Enter India State Name to see autocomplete
<input type="text" size="30" value="" id="inputString" onkeyup="lookup(this.value);" onblur="fill();" />
</div>
<div class="suggestionsBox" id="suggestions" style="display: none;">
<div class="suggestionList" id="autoSuggestionsList">
</div>
</div>
</form>
		</c:otherwise> 
	</c:choose>
	</div>
</div>
</body>
</html>
