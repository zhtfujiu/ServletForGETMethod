//package com.servlet;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import org.apache.commons.fileupload.servlet.ServletRequestContext;
//import org.apache.tomcat.util.http.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
//import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
///**
// * Servlet implementation class UpLoadPic
// */
//@WebServlet("/UpLoadPic")
//@MultipartConfig(
//		location="E:\\Eclipse_Workspace\\CUMTCSDataBase"		
//)
//public class UpLoadPic extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UpLoadPic() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");  
//        //��ô����ļ���Ŀ������  
//        DiskFileItemFactory factory = new DiskFileItemFactory();  
//        //��ȡ�ļ��ϴ���Ҫ�����·����upload�ļ�������ڡ�  
//        String path = request.getSession().getServletContext().getRealPath("/upload");  
//        //������ʱ����ļ��Ĵ洢�ң�����洢�ҿ��Ժ����մ洢�ļ����ļ��в�ͬ����Ϊ���ļ��ܴ�Ļ���ռ�ù����ڴ��������ô洢�ҡ�  
//        factory.setRepository(new File(path));  
//        //���û���Ĵ�С�����ϴ��ļ���������������ʱ���ͷŵ���ʱ�洢�ҡ�  
//        factory.setSizeThreshold(1024*1024);  
//        //�ϴ��������ࣨ��ˮƽAPI�ϴ�������  
//        ServletFileUpload upload = new ServletFileUpload(factory);  
//          
//        try{  
//            //���� parseRequest��request������  ����ϴ��ļ� FileItem �ļ���list ��ʵ�ֶ��ļ��ϴ���  
//            List<FileItem> list = (List<FileItem>)upload.parseRequest(new ServletRequestContext(request));  
//            for(FileItem item:list){  
//                //��ȡ���������֡�  
//                String name = item.getFieldName();  
//                //�����ȡ�ı���Ϣ����ͨ���ı���Ϣ����ͨ��ҳ�����ʽ���������ַ�����  
//                if(item.isFormField()){  
//                    //��ȡ�û�����������ַ�����  
//                    String value = item.getString();  
//                    request.setAttribute(name, value);  
//                }  
//                //���������ǷǼ��ַ���������ͼƬ����Ƶ����Ƶ�ȶ������ļ���  
//                else{   
//                    //��ȡ·����  
//                    String value = item.getName();  
//                    //ȡ�����һ����б�ܡ�  
//                    int start = value.lastIndexOf("\\");  
//                    //��ȡ�ϴ��ļ��� �ַ������֡�+1��ȥ����б�ܡ�  
//                    String filename = value.substring(start+1);  
//                    request.setAttribute(name, filename);  
//                      
//                    /*�������ṩ�ķ���ֱ��д���ļ��С� 
//                     * item.write(new File(path,filename));*/  
//                    //�յ�д�����յ��ļ��С�  
//                    OutputStream out = new FileOutputStream(new File(path,filename));  
//                    InputStream in = item.getInputStream();  
//                      
//                    int length = 0;  
//                    byte[] buf = new byte[1024];  
//                    System.out.println("��ȡ�ļ�����������:"+ item.getSize());  
//                      
//                    while((length = in.read(buf))!=-1){  
//                        out.write(buf,0,length);  
//                    }  
//                    in.close();  
//                    out.close();  
//                }  
//            }  
//        }catch(Exception e){  
//            e.printStackTrace();  
//        }  
//          
//	}
//
//	public String getCurrentData() {
//		SimpleDateFormat formatter = new SimpleDateFormat(
//				"yyyy.MM.dd HH:mm:ss");
//		Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
//		String currentDate = formatter.format(curDate);
//		return currentDate;
//	}
//}
