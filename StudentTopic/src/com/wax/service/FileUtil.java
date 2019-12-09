package com.wax.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class FileUtil {
	//读取Excel，获取Excel的文本和数字格式的内容，可根据需要修改
	@SuppressWarnings({ "deprecation", "resource" })
	public static List<List<String >> readExcel(String filePath){ 
		
		
        List<List<String>> list=new ArrayList<List<String>>();
        //判断是否是excel2007格式  
        boolean isE2007 = false;    
        if(filePath.endsWith("xlsx"))  
              isE2007 = true;  
        try {  
             //建立输入流  
             InputStream input = new FileInputStream(filePath);  
             Workbook wb  = null;  
             //根据文件格式(2003或者2007)来初始化  
             if(isE2007)  
            	 wb = new XSSFWorkbook(input);  
             else  
            	 wb = new HSSFWorkbook(input);  
              //获得第一个表单
             Sheet sheet = wb.getSheetAt(0);    
              //获得第一个表单的迭代器   
             Iterator<Row> rows = sheet.rowIterator(); 
             while (rows.hasNext()) { 
	            List<String> cellList = new ArrayList<String>();
	            //获得行数据 
	            Row row = rows.next(); 
	            //获得第一行的迭代器  
	            Iterator<Cell> cells = row.cellIterator();      
	            while (cells.hasNext()) {  
	                Cell cell = cells.next();  
	                //根据cell中的类型来输出数据 
	                switch (cell.getCellType()) {    
	                case HSSFCell.CELL_TYPE_NUMERIC:  
	                	cellList.add(String.valueOf(new BigDecimal(cell.getNumericCellValue())));
	                    break;  
	                case HSSFCell.CELL_TYPE_STRING:  
	                    cellList.add(cell.getStringCellValue());
	                    break;  
	                case HSSFCell.CELL_TYPE_BOOLEAN:  
	                    break;  
	                case HSSFCell.CELL_TYPE_FORMULA:  
	                    break;  
	                }  
	            }
	            list.add(cellList);
	        }
	        input.close();
        } catch (IOException ex) {  
        	ex.printStackTrace();  
        }
    return list;
		
}

	

}
