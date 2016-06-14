package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import json.DetailData;
import json.ResultOfDetailData;

import com.google.gson.Gson;

/**
 * Servlet implementation class Json
 */
@WebServlet("/Json")
public class Json extends HttpServlet {
	ResultSet rs;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//
		ConnMySQL_detail conn=new ConnMySQL_detail();
		//
		ResultOfDetailData resultOfDetailData=new ResultOfDetailData();
		resultOfDetailData.setKey(1);
		List<DetailData> list=new ArrayList<DetailData>();
		resultOfDetailData.setDetails(list);
		//
		
		String str_download_all="select * from detail ORDER BY time DESC";
		String str=setStoreName.storeName;
		System.out.println("this is storeName:"+str);
		String str_download_all2="select * from detail where storeID= '"+str+"' ORDER BY time DESC";
		conn.DownloadData(str_download_all);
		rs=conn.getRS();
		try {
			do{
				DetailData data_4=new DetailData();
				data_4.setTime(rs.getString(1));
				data_4.setUserID(rs.getString(2));
				data_4.setUserNicheng(rs.getString(3));
				data_4.setStoreID(rs.getString(4));
				data_4.setLocationID(rs.getString(5));
				data_4.setComment(rs.getString(6));
				data_4.setScoreOfShangpin(rs.getString(7));
				data_4.setScoreOfFuwu(rs.getString(8));
				
				list.add(data_4);
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		Gson gson=new Gson();
		System.out.println(gson.toJson(resultOfDetailData));
		//
		out.print(gson.toJson(resultOfDetailData));
	}

}
