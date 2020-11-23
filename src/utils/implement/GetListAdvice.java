package utils.implement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.Advice;
import utils.GetList;

public class GetListAdvice implements GetList{

	@Override
	public List getList(String filename) throws IOException {
		// TODO Auto-generated method stub

        File excel = new File(filename);
        String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！
		List<Advice> list = new ArrayList<Advice>();

        Workbook wb;
        //根据文件后缀（xls/xlsx）进行判断
        if ( "xls".equals(split[1]) || "csv".equals(split[1])){
            FileInputStream fiStream = new FileInputStream(excel);   //文件流对象
            wb = new HSSFWorkbook(fiStream);
        }else{
            wb = new XSSFWorkbook(new FileInputStream(excel));
        }

        //开始解析
        Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

        int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
        int lastRowIndex = sheet.getLastRowNum();
    	ArrayList clinic = new ArrayList();
    	ArrayList advice = new ArrayList();
		ArrayList alias = new ArrayList();
    	String disease = null;
    	String information = null;
    	String[] thesplit = null;
        for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行

            Row row = sheet.getRow(rIndex);
            if (row != null) {
//            	Model model = new Model();
            	Advice bean = new Advice();
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列   
                	Cell cell = row.getCell(cIndex);
                	if(cIndex==0 && !cell.toString().equals("") && rIndex==1) {
            			thesplit = cell.toString().split("['(',,'（',]"); 
            			int i=0;
            			for(String str:thesplit) {
            				if(i == 0) {
                    			disease = thesplit[0];
            				}else if(i == 1){
            					alias.add(thesplit[1]);
            				}
            				i++;
            			}  
                	}
                	else if(cIndex==0 && !cell.toString().equals("") && rIndex!=1) {                		
                		bean.setDisease(disease);
                		bean.setInformation(information);
                		bean.setClinic(clinic);
                		bean.setAdvice(advice);
                		bean.setAlias(alias);
                        list.add(bean);
                        System.out.println(disease+clinic);
                    	clinic = new ArrayList();
                    	advice = new ArrayList();
                    	alias = new ArrayList();
            			thesplit = cell.toString().split("['(','（',')','）']");
            			int i=0;
            			for(String str:thesplit) {
            				if(i == 0) {
                    			disease = thesplit[0];
            				}else if(i == 1) {
            					alias.add(thesplit[1]);
            				}
            				i++;
            			}       			

                	}
                	else if(cIndex==1 && cell != null) {
                		information = cell.toString();
                	}
                	else if(cIndex==2 && (cell != null)) {
                		if( !cell.toString().equals("")) {
                            clinic.add(cell.toString());
                		}
                	}
                	else if(cIndex==3 && (cell != null)) {
                		if(!cell.toString().equals("")) {
                			advice.add(cell.toString());
                		}
                	}
                }

            }
        }
		return list;
	}

}
