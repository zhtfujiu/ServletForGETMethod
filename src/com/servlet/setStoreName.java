package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class setStoreName
 */
@WebServlet("/setStoreName")
public class setStoreName extends HttpServlet {
	public static String storeName=null;
	public static String userID=null;
	public static boolean flag=false;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setStoreName() {
        super();
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
		storeName=request.getParameter("storeName");
		
		userID=request.getParameter("userID");
			
		if(storeName!=null){
			flag=false;
			storeName=new String(storeName.getBytes("ISO-8859-1"),"UTF-8");
		}
		if(userID!=null){
			flag=true;
			userID=new String(userID.getBytes("ISO-8859-1"),"UTF-8");	
		}
		System.out.println(storeName);
		System.out.println(userID);
		
	}

}
