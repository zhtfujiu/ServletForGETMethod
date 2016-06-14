package upLoadStoreInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpLoadStoreInfo {

	private Statement statement;
	private Connection con;//声明Connection对象
	private String driver="com.mysql.jdbc.Driver";//设置驱动程序名称*******不懂
	private String url="jdbc:mysql://localhost:3306/store_information";//url指向要访问的数据库名
	private String name_mysql="root";
	private String password_mysql="mysql5556";//MySQL配置时的账号密码
	private ResultSet rs,rs2;
	//标识执行语句的种类，1为查询，2为更新
//	final int SQL_Query=1,SQL_Update=2;
	//
//	private String sql_getAll="select * from store_information";
	private String sql_refresh_score,sql_refresh_avg;
	//两个评分
	private int ScoreOfSp=0,ScoreOfFw=0;
	public UpLoadStoreInfo(String ScoreOfShangpin,String ScoreOfFuwu,String storeID) {
		ScoreOfSp=Integer.parseInt(ScoreOfShangpin);
		ScoreOfFw=Integer.parseInt(ScoreOfFuwu);
		sql_refresh_score="UPDATE store_information SET num=num+1, shangpinScore=shangpinScore+"+ScoreOfSp+",fuwuScore=fuwuScore+"+ScoreOfFw+" WHERE storeID='"+storeID+"'";
	    sql_refresh_avg="UPDATE store_information SET avgsp=shangpinScore/num,avgfw=fuwuScore/num WHERE storeID='"+storeID+"'";
	}
	public void ReFreshData(){
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接数据库
			con = DriverManager.getConnection(url, name_mysql, password_mysql);
			if (!con.isClosed()) {
				System.out.println("Connection to upLoadStoreInfo Succeed！");
			}
			// 2.创建statement类对象，执行SQL语句
			statement=con.createStatement();
			statement.executeUpdate(sql_refresh_score);
			statement.executeUpdate(sql_refresh_avg);						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
