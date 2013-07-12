<%@page import="javaclasses.FormFieldPOJO"%>
<%@page import="java.io.Writer"%>
<%@page import="java.util.*"%>
<%@page import="java.io.PrintWriter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 

/*get list*/ 
//List<FormFieldPOJO> flist = session.getAttribute("fieldList");
//list length is int listLenght = fieldList.lenght

List<FormFieldPOJO> fields = (List<FormFieldPOJO>) session.getAttribute("fieldList"); 
int listLength = fields.size();		

int i;
FormFieldPOJO field = new FormFieldPOJO();

/*get values if already set in
	lastValue= value
*/

out.print("<form action='SaveFormDataServlet?sno=3&taskid="+session.getAttribute("taskid")+"&processid="+session.getAttribute("processid")+"' >");
/* Browse through all elements of list */
if(fields.isEmpty() == false){
for(i=0;i < listLength ; i++){
	field = (FormFieldPOJO)fields.get(i);
	out.print(field.getName());
	out.print("<input ");
	out.print("type='"+field.getType()+"' ");
	out.print("name='"+field.getName()+"' ");
	if(field.getType().equals("radio"))
	{
		out.print("value='"+field.getValue()+"' ");
	}
	if(field.getEditable() == false)
	{
		out.print("disabled");
	}
	if(field.getEditable() == true){
		if(field.getRequired() == true)
		{
			out.print("required ");
		}
	}
	out.print("><br/>");
		
}
}
else
{
	out.print("There are no parameters for this form");	
}
out.print("<input type='submit'>");
out.print("</form>");
%>

</body>
</html>
