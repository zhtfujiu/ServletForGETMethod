package xiugaimima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class XiugaimimaToSQL {

	ResultSet rs;
	
	public XiugaimimaToSQL(String userID,String userNicheng,String password) {
		Connection con;//����Connection����
		String driver="com.mysql.jdbc.Driver";//����������������*******����
		String url="jdbc:mysql://localhost:3306/user_information";//urlָ��Ҫ���ʵ����ݿ���
		String name_mysql="root";
		String password_mysql="mysql5556";//MySQL����ʱ���˺�����
		//
		
		try {
			//������������
			Class.forName(driver);
			//1.getConnection()�������������ݿ�
			con=DriverManager.getConnection(url, name_mysql, password_mysql);
			if(!con.isClosed()){
				System.out.println("Connection Succeed��");
			}
			//2.����statement�����ִ��SQL���
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
