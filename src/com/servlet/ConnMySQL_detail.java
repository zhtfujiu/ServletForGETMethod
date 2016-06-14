package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class ConnMySQL_detail {
	private Statement statement;
	private Connection con;//声明Connection对象
	private String driver="com.mysql.jdbc.Driver";//设置驱动程序名称*******不懂
	private String url="jdbc:mysql://localhost:3306/detail";//url指向要访问的数据库名
	private String name_mysql="root";
	private String password_mysql="mysql5556";//MySQL配置时的账号密码
	private ResultSet rs,rs2;
	//标识执行语句的种类，1为查询，2为更新
	final int SQL_Query=1,SQL_Update=2;
	//
	private String sql_getAll="select * from user_information";
	private String sql_2="select password from user_information where user_information.userID='12345678';";
	private String userID,userNicheng,storeID,locationID,comment,time,ScoreOfShangpin,ScoreOfFuwu;

	public ConnMySQL_detail() {
		//
		userID=null;
		userNicheng=null;
		storeID=null;
		locationID=null;
		comment=null;
		time=null;
		ScoreOfShangpin=null;	
		ScoreOfFuwu=null;
		//
	}
	// 加载驱动程序并执行SQL语句
	private void LoadDriveMethod(String sql,int SQL_KIND){
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接数据库
			con = DriverManager.getConnection(url, name_mysql, password_mysql);
			if (!con.isClosed()) {
				System.out.println("Connection Succeed！");
			}
			// 2.创建statement类对象，执行SQL语句
			statement=con.createStatement();
			if(SQL_KIND==SQL_Query){
				rs=statement.executeQuery(sql);
				if(rs.next()){
					rs2=rs;
				}
			}else if(SQL_KIND==SQL_Update){
				statement.executeUpdate(sql);
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void UploadData(String userID1,String userNicheng1,String storeID1,String locationID1,String comment1,String time1,String ScoreOfShangpin1,String ScoreOfFuwu1){
		//
		userID=userID1;
		userNicheng=userNicheng1;
		storeID=storeID1;
		locationID=locationID1;
		comment=comment1;
		time=time1;	
		ScoreOfShangpin=ScoreOfShangpin1;	
		ScoreOfFuwu=ScoreOfFuwu1;
		//
		String sql_upload = "INSERT into detail VALUES ('" + time + "','"
		+ userID + "','"+userNicheng+"','" + storeID + "','" + locationID + "','"+ comment + "','" + ScoreOfShangpin + "','"+ScoreOfFuwu+"');";
		//加载驱动方法并执行SQL更新语句
		LoadDriveMethod(sql_upload,SQL_Update);
	}
	public void DownloadData(String sql_str){
		LoadDriveMethod(sql_str, SQL_Query);
	}

	public ResultSet getRS() {
		return rs2;
	}
	public void closeConn() throws SQLException{
		con.close();
	}
}
