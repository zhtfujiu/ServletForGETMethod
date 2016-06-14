package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReturnPswToAPP
 */
@WebServlet("/ReturnPswToAPP")
public class ReturnPswToAPP extends HttpServlet {
	private String psw;
	private static final long serialVersionUID = 1L;
       
	/**
	 * 
	 * 
	 * 这个servlet为APP返回<password:name>组合数据！！！！！！！！！
	 * 
	 */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnPswToAPP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUserPswFromMySQL getpsw=new getUserPswFromMySQL(getUserId.userID);
		//
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String str=getpsw.psw+":"+getpsw.name;
		//
		out.print(str);
	}

}
