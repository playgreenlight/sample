package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInitParam extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("test init parameters<br>");
		
		Enumeration e = getServletConfig().getInitParameterNames();
		while(e.hasMoreElements())
			out.println("param name = " + e.nextElement() + "</br>");
		
		out.println("email is : " + getServletConfig().getInitParameter("Email"));
		out.println("company is : " + getServletConfig().getInitParameter("Company"));
	}

}
