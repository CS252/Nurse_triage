package Servlets;

import java.io.IOException;

import javaclasses.CheckLogin;
import javaclasses.LoginPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("login") != null)
		{
			try 
			{ 
			LoginPojo user = new LoginPojo(); 
			user.setUsername(request.getParameter("un"));
			user.setPassword(request.getParameter("pw")); 
			String loginresult = CheckLogin.checklogin(user); 
			if (!loginresult.isEmpty()) 
			{ 
			HttpSession session = request.getSession(true);
			session.setAttribute("user",user); 
			session.setAttribute("group",loginresult); 
			response.sendRedirect("RetrieveList"); //logged-in page 
			} 
			else 
				response.sendRedirect("LoginPage.jsp"); //error page 
			} 
			
			catch (Throwable theException) 
			{ 
				System.out.println(theException); 
			}
		}
		else if (request.getParameter("regiter") != null)
		{
			response.sendRedirect("LoginPage.jsp"); // login page
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
