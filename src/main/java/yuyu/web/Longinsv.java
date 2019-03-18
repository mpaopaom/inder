package yuyu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yuyu.dao.AdminDao;

@WebServlet(urlPatterns="/admin/login")
public class Longinsv extends HttpServlet {
  AdminDao admindao=new AdminDao();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
	
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		if (admindao.login(username,password)) {
			response.sendRedirect(basePath+"/jsp/admin/main.html");
			
		} else {
			response.sendRedirect(basePath+"/jsp/admin/login.jsp");
		}
		
	}

}