package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReSetPsw
 */
@WebServlet("/ReSetPsw")
public class ReSetPsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String name,password;
    private String sql;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReSetPsw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name=request.getParameter("name");
		password=request.getParameter("password");
		
		System.out.println(name+"\n"+password);
		
		ConnMySQL_UserInf_change temp=new ConnMySQL_UserInf_change(name,password);
	}

}
