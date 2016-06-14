package xiugaimima;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XiugaimimaServlet
 */
@WebServlet("/XiugaimimaServlet")
public class XiugaimimaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String userID,userNicheng,password;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiugaimimaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userID=request.getParameter("userID");
		userNicheng=request.getParameter("userNicheng");
		try {
			userNicheng=new String(userNicheng.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password=request.getParameter("password");
		
		System.out.println(userID+"\n"+userNicheng+"\n"+password);
		
		new XiugaimimaToSQL(userID,userNicheng,password);
	}

}
