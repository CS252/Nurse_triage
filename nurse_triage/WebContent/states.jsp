<%@ page language="java" import="java.sql.*" %>
<% response.setContentType("text/html");%>
<%
String str=request.getParameter("queryString");
try {
String connectionURL = "jdbc:mysql://localhost:3306/activiti_standalone";
Connection con;
Class.forName("com.mysql.jdbc.Driver");
// Get a Connection to the database
con = DriverManager.getConnection(connectionURL, "root", "mysql"); 
//Add the data into the database
String sql = "SELECT * FROM patient WHERE firstname LIKE '"+str+"%' LIMIT 10";
System.out.println(sql);
Statement stm = con.createStatement();
stm.executeQuery(sql);
ResultSet rs= stm.getResultSet();
while (rs.next ()){
out.println("<li onclick='fill("+rs.getString("patientID")+");'>"+rs.getString("firstname") + rs.getString("lastname") + rs.getString("patientID")+"</li>");
}}catch(Exception e){
out.println("Exception is ;"+e);
}
%>
