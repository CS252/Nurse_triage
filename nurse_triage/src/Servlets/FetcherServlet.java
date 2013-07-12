package Servlets;

import java.io.IOException;

import javaclasses.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class FetcherServlet
 */
@WebServlet("/FetcherServlet")
public class FetcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String ct=null;  
		ct=request.getParameter("q");
		      Connection con=null;
		      ResultSet rs=null;
		      Statement st=null;
		
		      try{
		con=ConnectionManager.getConnection();
		PreparedStatement ps=con.prepareStatement("(select * from patient where firstname ='+ct+'");
		rs=ps.executeQuery();
        int count=0;
		String sendThis="<?xml version='1.0'?>"
	            +"<Maintag>"
	            +"<Subtag>";
		String uname = "";
		while (rs.next()){
			count++;
		uname=rs.getString("firstname"); //some operation
			    //create one XML string
			 sendThis = sendThis +"<unameVal"+ count + ">"+uname+"</unameVal"+count+">";     
		}
		 sendThis = sendThis +"</Subtag>"+"</Maintag>";
		 ServletOutputStream out = response.getOutputStream();   
		 
		 response.setContentType("text/xml");
	    out.print(sendThis);
	    out.flush();

		}
		catch(Exception e)
		{
		    System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
