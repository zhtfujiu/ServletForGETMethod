package zhuce;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class returnCheckIDResult
 */
@WebServlet("/returnCheckIDResult")
public class returnCheckIDResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public returnCheckIDResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean flag=new ZhuceCheckID().returnResult();
		//��true����ڴ��û�
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//
		
		if(flag){
		    System.out.println("0");
			out.print("0");//APP ���ܵ�0��֤���û���ע��
		}else{
			System.out.println("1");
			out.print("1");//APP ���ܵ�1��֤���û�δע��
		}
	}

}
