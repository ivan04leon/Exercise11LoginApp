package org.gen.loginApp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gen.loginApp.model.LoginBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		LoginBean bean = new LoginBean();
//		RequestDispatcher rd = req.getRequestDispatcher("WelcomeServlet");
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		
		bean.setUser(user);
		bean.setPassword(password);
		
		boolean acceso = bean.validar();
//		resp.getWriter().append("Acceso denegado");
		
		if(acceso) {
//			RequestDispatcher rd = req.getRequestDispatcher("WelcomeServlet");
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(30);
			
			Cookie userName = new Cookie("user", user);
			userName.setMaxAge(30);
			resp.addCookie(userName);
			resp.sendRedirect("login.jsp");
//			rd.forward(req, resp);
		}else {
//			resp.getWriter().append("Acceso denegado");
//			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//			rd.forward(req, resp);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("index.jsp");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red> User o password erroneo </font>");
		}
		resp.getWriter().append("usuario: " + user + "<br>");
		resp.getWriter().append("password: " + password + "<br>");
	}

}
