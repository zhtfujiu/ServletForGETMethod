package shangjia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnToStoreInfo {

	private Statement statement;
	private Connection con;//声明Connection对象
	private String driver="com.mysql.jdbc.Driver";//设置驱动程序名称*******不懂
	private String url="jdbc:mysql://localhost:3306/store_information";//url指向要访问的数据库名
	private String name_mysql="root";
	private String password_mysql="mysql5556";//MySQL配置时的账号密码
	private ResultSet rs,rs2;
	//标识执行语句的种类，1为查询，2为更新
	final int SQL_Query=1,SQL_Update=2;
	private final int SQLSIGN;
	//热点排行、好评排行、差评排行
	private String sql_getAll1="select storeID,avgsp,avgfw from store_information ORDER BY num DESC";
	private String sql_getAll2="select storeID,avgsp,avgfw from store_information ORDER BY (avgfw+avgsp) DESC";
	private String sql_getAll3="select storeID,avgsp,avgfw from store_information ORDER BY (avgfw+avgsp) ASC";
	
	private String storeID=null,shangpinScore=null,fuwuScore=null;
	private int num=0;
	//
	public ConnToStoreInfo(int i) {
		SQLSIGN=i;
	}
	// 加载驱动程序并执行SQL语句
	private void LoadDriveMethod(String sql,int SQL_KIND){
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接数据库
			con = DriverManager.getConnection(url, name_mysql, password_mysql);
			if (!con.isClosed()) {
				System.out.println("Connection Succeed To Store_information！");
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

	public void UploadData(String storeID1,int num1,String shangpinScore1,String fuwuScore1){
		//
		storeID=storeID1;
		num=num1;
		shangpinScore=shangpinScore1;
		fuwuScore=fuwuScore1;
		//
		String sql_upload = "INSERT into detail VALUES ('" + storeID + "','"
		+ num + "','" + shangpinScore + "','" + fuwuScore + "');";
		//加载驱动方法并执行SQL更新语句
		LoadDriveMethod(sql_upload,SQL_Update);
	}
	public void DownloadData(){
		switch(SQLSIGN){
		case 1:LoadDriveMethod(sql_getAll1, SQL_Query);
			break;
		case 2:LoadDriveMethod(sql_getAll2, SQL_Query);
			break;
		case 3:LoadDriveMethod(sql_getAll3, SQL_Query);
			break;			
		}
	}

	public ResultSet getRS() {
		return rs2;
	}
	public void closeConn() throws SQLException{
		con.close();
	}
}
