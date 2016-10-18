package mypkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EchoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set mime type
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		out.println("<!DOCTYPE = html>");
		out.println("<html><head>");
		out.println("<meta http-eqiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<title>Echo Servlet<title></head>");
		out.println("<body><h2>You have enter</h2>");
		
		String userName = req.getParameter("username");
		if(userName == null || userName.trim().length()==0)
			out.println("<p>Name : MISSING</p>");
		else
			out.println("<p>Name : " + userName + "</p>");
		
		String password = req.getParameter("password");
		if(password == null|| password.trim().length()==0 )
			out.println("<p>Password : MISSING</p>");
		else
			out.println("<p>Password : " + password + "</p>");
		
		//get all parameters
		Enumeration names = req.getParameterNames();
		out.print("<p> Parameter names are ");
		if(names.hasMoreElements())
			out.print(names.nextElement().toString());
		out.println("<br></p>");
		
		out.println("<a href='form_input.html'>BACK</a>");
		
		out.println("</body></html>");
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//redirect post to get
		doGet(req, resp);
	}
}
