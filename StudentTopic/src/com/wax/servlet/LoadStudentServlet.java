package com.wax.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
import com.wax.dao.Student_infoDao;
import com.wax.service.FileUtil;


public class LoadStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoadStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
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
				String class_id=null;
				while(it.hasNext()) {
					FileItem fileItem = it.next();
					String fieldName= fileItem.getFieldName();
					if(fileItem.isFormField()) {
						if("addclass_id".equals(fieldName)) {
							class_id= fileItem.getString("utf-8");
						}
					}
				}
				Iterator<FileItem> it2=itme.iterator();
				while(it2.hasNext()) {
					FileItem fileItem = it2.next();
					String fieldName= fileItem.getFieldName();
					if(fileItem.isFormField()) {
						if("addclass_id".equals(fieldName)) {
							class_id= fileItem.getString("utf-8");
						}
					}else {
						String filename=fileItem.getName();
						if(filename==null || filename.trim().equals("")){
							continue;
						}
						
						//处理获取到的上传文件的文件名的路径部分只保留文件名部分
						filename = filename.substring(filename.lastIndexOf("\\")+1);
						//得到上传文件的扩展名
						String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
						//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
						
						String savePath=this.getServletContext().getRealPath("/WEB-INF/upload");
						
						//得到文件保存的名称
						String saveFilename = makeFileName(filename);
						//得到文件的保存目录
						String realSavePath = makePath(saveFilename, savePath);
						//文件全路径
						String filePath = realSavePath + "\\" + saveFilename;
						
						File file=new File(realSavePath,saveFilename);
						fileItem.write(file);
						if("xlsx".equals(fileExtName) || "xls".equals(fileExtName)) {
							int row = 0;
							List<List<String>> readExcel = FileUtil.readExcel(filePath);
							int k=0;
							for(List<String > rowList :readExcel) {
								k+=1;
								if(k==1) {
									continue;
								}
								Student_infoDao dao = new Student_infoDao();
								Student_info stu=new Student_info(rowList.get(0), rowList.get(1), class_id, rowList.get(2), rowList.get(3), rowList.get(4) , rowList.get(5));
								row = dao.insert(stu);
								if(row>0)
								{	continue;
								}
								else{
									response.sendRedirect("fail.jsp");
								}
							}
							response.sendRedirect("success.jsp");
						}
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
	
	
	private String makeFileName(String filename){  //2.jpg
	        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	        return UUID.randomUUID().toString() + "_" + filename;
	    }
	 
    private String makePath(String filename,String savePath){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
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
