package xiugaimima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XiugaimimaToSQL {

	ResultSet rs;
	
	public XiugaimimaToSQL(String userID,String userNicheng,String password) {
		Connection con;//声明Connection对象
		String driver="com.mysql.jdbc.Driver";//设置驱动程序名称*******不懂
		String url="jdbc:mysql://localhost:3306/user_information";//url指向要访问的数据库名
		String name_mysql="root";
		String password_mysql="mysql5556";//MySQL配置时的账号密码
		//
		
		try {
			//加载驱动程序
			Class.forName(driver);
			//1.getConnection()方法，连接数据库
			con=DriverManager.getConnection(url, name_mysql, password_mysql);
			if(!con.isClosed()){
				System.out.println("Connection Succeed！");
			}
			//2.创建statement类对象，执行SQL语句
			Statement statement=con.createStatement();
			String sql="UPDATE user_information SET userNiCheng='"+userNicheng+"' ,`password`='"+password+"' WHERE userID='"+userID+"'";
			//
			statement.executeUpdate(sql);
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
