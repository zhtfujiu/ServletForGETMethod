package shangjia;

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

import com.google.gson.Gson;

/**
 * Servlet implementation class ShangjiaServlet3
 */
@WebServlet("/ShangjiaServlet3")
public class ShangjiaServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShangjiaServlet3() {
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
		ConnToStoreInfo conn=new ConnToStoreInfo(3);
		//
		ResultOfStoreDetailData resultOfStoreDetailData=new ResultOfStoreDetailData();
		resultOfStoreDetailData.setKey(1);
		List<DetailStoreItem> list=new ArrayList<DetailStoreItem>();
		resultOfStoreDetailData.setDetails(list);

		conn.DownloadData();
		rs=conn.getRS();
		try {
			do{
				DetailStoreItem data_4=new DetailStoreItem();
				data_4.setTv1(rs.getString(1));
				data_4.setTv2(rs.getString(2));
				data_4.setTv3(rs.getString(3));
				
				list.add(data_4);
			}while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//
		Gson gson=new Gson();
		System.out.println(gson.toJson(resultOfStoreDetailData));
		//
		out.print(gson.toJson(resultOfStoreDetailData));
	}

}
