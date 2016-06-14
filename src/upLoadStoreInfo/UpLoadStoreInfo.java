package upLoadStoreInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpLoadStoreInfo {

	private Statement statement;
	private Connection con;//����Connection����
	private String driver="com.mysql.jdbc.Driver";//����������������*******����
	private String url="jdbc:mysql://localhost:3306/store_information";//urlָ��Ҫ���ʵ����ݿ���
	private String name_mysql="root";
	private String password_mysql="mysql5556";//MySQL����ʱ���˺�����
	private ResultSet rs,rs2;
	//��ʶִ���������࣬1Ϊ��ѯ��2Ϊ����
//	final int SQL_Query=1,SQL_Update=2;
	//
//	private String sql_getAll="select * from store_information";
	private String sql_refresh_score,sql_refresh_avg;
	//��������
	private int ScoreOfSp=0,ScoreOfFw=0;
	public UpLoadStoreInfo(String ScoreOfShangpin,String ScoreOfFuwu,String storeID) {
		ScoreOfSp=Integer.parseInt(ScoreOfShangpin);
		ScoreOfFw=Integer.parseInt(ScoreOfFuwu);
		sql_refresh_score="UPDATE store_information SET num=num+1, shangpinScore=shangpinScore+"+ScoreOfSp+",fuwuScore=fuwuScore+"+ScoreOfFw+" WHERE storeID='"+storeID+"'";
	    sql_refresh_avg="UPDATE store_information SET avgsp=shangpinScore/num,avgfw=fuwuScore/num WHERE storeID='"+storeID+"'";
	}
	public void ReFreshData(){
		try {
			// ������������
			Class.forName(driver);
			// 1.getConnection()�������������ݿ�
			con = DriverManager.getConnection(url, name_mysql, password_mysql);
			if (!con.isClosed()) {
				System.out.println("Connection to upLoadStoreInfo Succeed��");
			}
			// 2.����statement�����ִ��SQL���
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
