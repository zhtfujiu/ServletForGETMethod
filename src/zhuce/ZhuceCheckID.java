package zhuce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.servlet.setStoreName;

public class ZhuceCheckID {

	private String userID;
	private ResultSet rs;
	private boolean flag=false;
	public ZhuceCheckID() {
		userID=setStoreName.userID;
		//
		Connection con;//����Connection����
		String driver="com.mysql.jdbc.Driver";//����������������*******����
		String url="jdbc:mysql://localhost:3306/user_information";//urlָ��Ҫ���ʵ����ݿ���
		String name_mysql="root";
		String password_mysql="mysql5556";//MySQL����ʱ���˺�����
		//
		//
		try {
			//������������
			Class.forName(driver);
			//1.getConnection()�������������ݿ�
			con=DriverManager.getConnection(url, name_mysql, password_mysql);
			if(!con.isClosed()){
				System.out.println("���ID Connection Succeed��");
			}
			//2.����statement�����ִ��SQL���
			Statement statement=con.createStatement();
			String sql_getAll="select COUNT(*) FROM user_information WHERE userID='"+userID+"'";
			//
			System.out.println("SQL����е�userID��"+userID);
			rs=statement.executeQuery(sql_getAll);
			while(rs.next()){
				if(!rs.getString(1).equals("0")){
				flag=true;
				}
			}			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean returnResult(){
		return flag;
	}
}
