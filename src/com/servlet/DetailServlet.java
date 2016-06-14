package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upLoadStoreInfo.UpLoadStoreInfo;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String userID,userNicheng,storeID,locationID,comment,time;
       private String ScoreOfShangpin,ScoreOfFuwu;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		userID=request.getParameter("userID");
		userID=new String(userID.getBytes("ISO-8859-1"),"UTF-8");
		userNicheng=request.getParameter("userNicheng");
		userNicheng=new String(userNicheng.getBytes("ISO-8859-1"),"UTF-8");		
		storeID=request.getParameter("storeID");
		storeID=new String(storeID.getBytes("ISO-8859-1"),"UTF-8");
		locationID=request.getParameter("locationID");
		locationID=new String(locationID.getBytes("ISO-8859-1"),"UTF-8");
		comment=request.getParameter("comment");
		comment=new String(comment.getBytes("ISO-8859-1"),"UTF-8");
		time=request.getParameter("time");
		ScoreOfShangpin=request.getParameter("ScoreOfShangpin");
		ScoreOfFuwu=request.getParameter("ScoreOfFuwu");
		ScoreOfShangpin=new String(ScoreOfShangpin.getBytes("ISO-8859-1"),"UTF-8");
		ScoreOfFuwu=new String(ScoreOfFuwu.getBytes("ISO-8859-1"),"UTF-8");
		//
		System.out.println("userID="+userID+"\n"+"userNicheng="+userNicheng+"\n"+"storeID="+storeID+"\n"+"locationID="+locationID+"\n"+
				"comment="+comment+"\n"+"time="+time+"\n"+"ScoreOfShangpin="+ScoreOfShangpin
				+"\n"+"ScoreOfFuwu="+ScoreOfFuwu);
		ConnMySQL_detail conn=new ConnMySQL_detail();
		conn.UploadData(userID, userNicheng,storeID, locationID, comment, time, ScoreOfShangpin,ScoreOfFuwu);
		UpLoadStoreInfo upStore=new UpLoadStoreInfo(ScoreOfShangpin, ScoreOfFuwu, storeID);
		upStore.ReFreshData();
	}
	

}
