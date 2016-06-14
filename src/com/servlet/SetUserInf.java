package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imooc_servlet
 */
@WebServlet("/imooc_servlet")
public class SetUserInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String userID,userNicheng,password;
    private String sql;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetUserInf() {
        super();
        
    }
    public SetUserInf(String sql){
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response){ 
		userID=request.getParameter("userID");
		userNicheng=request.getParameter("userNicheng");
		try {
			userNicheng=new String(userNicheng.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password=request.getParameter("password");
		
		System.out.println(userID+"\n"+userNicheng+"\n"+password);
		
		ConnMySQL_UserInf temp=new ConnMySQL_UserInf(userID,userNicheng,password);
		
		
	}
}
