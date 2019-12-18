package com.wax.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.wax.dao.SelectTopicInfoDao;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		String tea_id=request.getParameter("tea_id");
		List<Map<String, Object>> findAll = dao.searchByTea(tea_id);
		Workbook workbook=new XSSFWorkbook();
		String []tableHeaders= {"分组编号","题目","组长","组员"};
		exportDataToWorkbook(findAll, tableHeaders, workbook);
		downWorkBookToPC(response, workbook, System.currentTimeMillis()+".xlsx");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dTODO Auto-generated method stub
		doGet(request, response);
	}
	public void exportDataToWorkbook(List<Map<String, Object>> data,String[] tableHead,Workbook workbook) { 
		Sheet sheet = workbook.createSheet("排序结果");//创建一个表单 Row headRow=sheet.createRowC0);
		org.apache.poi.ss.usermodel.Row headRow=sheet.createRow(0);
		//设罝表头，如果没有跳过	ecxcel的表头
		for(int i=0;i<tableHead.length;i++) {
			headRow.createCell(i).setCellValue(tableHead[i]);//设 S 表头
		}
		Map<String, String> teams=new HashMap<String, String>();
		Set<String>fenzhu=new HashSet<String>();
		for(int i=0; i<data.size() ;i++) {
			fenzhu.add(data.get(i).get("team_id").toString());
		}
		for(int i=0; i<data.size() ;i++) {
			teams.put(data.get(i).get("team_id").toString()+"   "+data.get(i).get("topic_name").toString(),
			teams.get(data.get(i).get("team_id").toString())+"   "
			+data.get(i).get("stu_name").toString());
		}
		//加入数据
		int i=0;
		for(String key : teams.keySet()) {
			Row row = sheet.createRow(i+1);
			String[] split = key.split("   ");
			row.createCell(0).setCellValue(split[0]);
			row.createCell(1).setCellValue(split[1]);
			for(int k=0; k<data.size() ;k++) {
				if(split[0].equals(data.get(k).get("team_id").toString())&&"组长".equals(data.get(k).get("st_stu_check").toString())) {
					row.createCell(2).setCellValue(data.get(i).get("stu_name").toString());
				}
			}
			row.createCell(3).setCellValue(teams.get(key));
			i+=1;
			
		}
		workbook.setSheetName(0, "导出名单");
	}
	public void downWorkBookToPC(HttpServletResponse response,Workbook wb,String filename) {
		try {
			response.setHeader("Content-Disposition","attachment;filename="+new String(filename.getBytes("utf-8"),"utf-8"));
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		} 
		OutputStream out=null;
		try {
			out = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public Boolean check(String s,Set<String>set) {
		for(String str:set) {
			if(str.equals(s))
				return true;
		}
		return false;
	}
}
