package com.wax.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.service.StudentService;




public class LoadReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadReportServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String stu_id = request.getParameter("stu_id");
		Student_infoDao studao=new Student_infoDao();
		List<Map<String, Object>> stu = studao.search(stu_id);
		SelectTopicInfoDao stuselectdao=new SelectTopicInfoDao();
		List<Map<String, Object>> search = stuselectdao.search(stu_id);
		if(!search.get(0).get("st_stu_check").equals("组长")) {
			response.sendRedirect("fail.jsp");
		}
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if(ismultipart)//判断上传表单中是否有mutipart属性
		{
			DiskFileItemFactory factory=new DiskFileItemFactory();
            factory.setSizeThreshold(1024*100);//设置缓冲区的大小为100KB，如果不指定，那么缓冲区的大小默认是10KB
            // 2、创建一个文件上传解析器
			ServletFileUpload fileUpload=new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("UTF-8");
			fileUpload.setFileSizeMax(1024*1024*100);
			try {
				//通过parseRequest解析form表单中的所有请求字段，并且保存到items中
				List<FileItem> itme = fileUpload.parseRequest(request);
				//遍历item中的数据（name,pwd,file）
				Iterator<FileItem> it=itme.iterator();
				while(it.hasNext()) {
					FileItem fileItem = it.next();
					//获取文件名
					String filename=fileItem.getName();
					if(filename==null || filename.trim().equals("")){
                        continue;
                    }
					//处理获取到的上传文件的文件名的路径部分只保留文件名部分
                    filename =filename.substring(filename.lastIndexOf("\\")+1);
                    //得到上传文件的扩展名
                    String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                    //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
					String savePath=this.getServletContext().getRealPath("/WEB-INF/upload");
                    //得到文件的保存目录
                    String realSavePath = makePath((String)stu.get(0).get("class_name"), savePath,(String)stu.get(0).get("class_grade"),(String)stu.get(0).get("class_major"),(String)search.get(0).get("st_team_id"));
                    //文件全路径
                    String filePath = realSavePath + "\\" + filename;	
					File file=new File(realSavePath,filename);
					fileItem.write(file);
					File f=new File(filePath);
					if(f.exists())
					{
						StudentService ss=new StudentService();
						int row = ss.updateReport((String)search.get(0).get("st_team_id"), "提交");
						if (row>0)
							response.sendRedirect("success.jsp");
					}
					else{
						response.sendRedirect("fail.jsp");
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

	 
    private String makePath(String stu_class,String savePath,String stu_grade,String stu_major,String team_id){
        
        //构造新的保存目录
        String dir = savePath +"\\"+stu_grade+ "\\"+stu_major+"\\"+stu_class+"\\"+team_id;  //upload\stu_id\
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if(!file.exists()){
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

}
