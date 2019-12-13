package com.wax.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wax.JavaBeen.Student_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Student_infoDao;

public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String stu_id=request.getParameter("stu_id");
		Student_infoDao studao=new Student_infoDao();
		SelectTopicInfoDao stuselectdao=new SelectTopicInfoDao();
		List<Map<String, Object>> search = stuselectdao.search(stu_id);
		List<Map<String, Object>> stu = studao.search(stu_id);
		
		//上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
		String fileSaveRootPath=this.getServletContext().getRealPath("/WEB-INF/upload");
        String realSavePath = makePath((String)stu.get(0).get("class_name"), fileSaveRootPath,(String)stu.get(0).get("class_grade"),(String)stu.get(0).get("class_major"),(String)search.get(0).get("st_team_id"));
		File filesave=new File(realSavePath);
		File filesaves[] = filesave.listFiles();
		for(File file : filesaves){
			String realname = file.getName();
			System.out.println(realname);
			//如果文件不存在
			if(!file.exists()){
				request.setAttribute("message", "您要下载的资源已被删除！！");
				request.getRequestDispatcher("fail.jsp").forward(request, response);
				return;
			}
			else {
				//处理文件名
				//设置响应头，控制浏览器下载该文件
				response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
				//读取要下载的文件，保存到文件输入流
				FileInputStream in = new FileInputStream(realSavePath + "\\" + realname);
				//创建输出流
				OutputStream out = response.getOutputStream();
				//创建缓冲区
				byte buffer[] = new byte[1024];
				int len = 0;
				//循环将输入流中的内容读取到缓冲区当中
				while((len=in.read(buffer))>0){
					//输出缓冲区的内容到浏览器，实现文件下载
					out.write(buffer, 0, len);
				}
				//关闭文件输入流
				in.close();
				//关闭输出流
				out.close();
				response.sendRedirect("successu.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public String findFileSavePathByFileName(String filename,String saveRootPath){
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf;  //0--15
		int dir2 = (hashcode&0xf0)>>4;  //0-15
		String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
		File file = new File(dir);
		if(!file.exists()){
			//创建目录
			file.mkdirs();
		}
		return dir;
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
	public void listfile(File file,Map<String,String> map){
		//如果file代表的不是一个文件，而是一个目录
		if(!file.isFile()){
			//列出该目录下的所有文件和目录
			File files[] = file.listFiles();
			//遍历files[]数组
			for(File f : files){
				//递归
				listfile(f,map);
			}
		}else{

		String realName = file.getName().substring(file.getName().indexOf("_")+1);
		//file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
		map.put(file.getName(), realName);
		}
	}
}
