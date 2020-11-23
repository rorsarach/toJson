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

import bean.Examination;
import utils.GetList;

public class GetListExamination implements GetList{

	@Override
	public List getList(String filename) throws IOException {
		// TODO Auto-generated method stub
        File excel = new File(filename);
        String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！
		List<Examination> list = new ArrayList<Examination>();
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
    	ArrayList uplist = new ArrayList();
    	ArrayList downlist = new ArrayList();
    	String[] thesplit = null;
    	String target = null;
    	for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
    		Boolean isnot = true;
    		Examination bean = new Examination();
        	String up = null;
        	String down = null;
            Row row = sheet.getRow(rIndex);
            if (row != null) {
                int firstCellIndex = row.getFirstCellNum();
                int lastCellIndex = row.getLastCellNum();
                for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列   
                	Cell cell = row.getCell(cIndex);
                	if(cIndex==1 && cell!=null) {
                		target = cell.toString();
                		isnot = false;
                	}else if(cIndex==1 && cell==null) {
                		isnot = true;
                	}
                	if(cIndex==7 && cell!=null && isnot==false) {
                		if( cell.toString().equals("—")) {
                			up = "";
                		}
                		else {
                			up = cell.toString();
                			String disease1 = "";
                			boolean haveAlias = false;
                			boolean nomore = false;
                			ArrayList splitList = new ArrayList();
                			//按、分割
                			for(int i = 0; i < up.length() ; i++){                   				
                				String ss = String.valueOf(up.charAt(i));
                				if(ss.equals("(") || ss.equals("（")) {
                					haveAlias = true;
                  				}else if(ss.equals("）") || ss.equals(")")) {
                  					haveAlias = false;
                  				}
                      			if( ( (ss.equals("、") || ss.equals(",") || ss.equals("，") ) && haveAlias == false) ) {
		          					splitList.add(disease1);
		          					disease1 = "";
                      			}else {
                      				disease1 += ss;
                      			}
                      			if(i == up.length()-1) {
		          					splitList.add(disease1);
		          					disease1 = "";
                      			}

                			}
                			System.out.println(splitList);
                			ArrayList more = new ArrayList();
            				ArrayList disease = new ArrayList();
                			for(int i=0;i<splitList.size();i++) {
                				String str = (String) splitList.get(i);
                    			thesplit = str.split("['、','，','。',',','(','（',')','）']");
                    			for(String s : thesplit) {
//                    				System.out.println(s);
                    				disease.add(s);
                    			}
//                    			more.add(disease);
                    			uplist.add(disease);
                    			disease = new ArrayList();
//                    			more = new ArrayList();
                    		}
                		} 
                	}
                	if(cIndex==8 && cell!=null && isnot==false) {
                		if( cell.toString().equals("—")) {
                			down = "";
                		}
                		else {
                			down = cell.toString();
                   			String disease1 = "";
                			boolean haveAlias = false;
                			boolean nomore = false;
                			ArrayList splitList = new ArrayList();
                			//按、分割
                			for(int i = 0; i < down.length() ; i++){                   				
                				String ss = String.valueOf(down.charAt(i));
                				if(ss.equals("(") || ss.equals("（")) {
                					haveAlias = true;
                  				}else if(ss.equals("）") || ss.equals(")")) {
                  					haveAlias = false;
                  				}
                      			if( ((ss.equals("、") || ss.equals(",") || ss.equals("，") && haveAlias == false))) {
                      				System.out.println(disease1);
		          					splitList.add(disease1);
		          					disease1 = "";
                      			}else {
                      				disease1 += ss;
                      			}
                      			if(i == down.length()-1) {
		          					splitList.add(disease1);
		          					disease1 = "";
                      			}
                			}
//                			System.out.println(splitList);
                			ArrayList more = new ArrayList();
            				ArrayList disease = new ArrayList();
                			for(int i=0;i<splitList.size();i++) {
                				String str = (String) splitList.get(i);
                    			thesplit = str.split("['、','，','。',',','(','（',')','）']");
                    			for(String s : thesplit) {
//                    				System.out.println(s);
                    				disease.add(s);
                    			}
//                    			more.add(disease);
                    			downlist.add(disease);
                    			disease = new ArrayList();
//                    			more = new ArrayList();
                    		}
                		} 
                	}
                	
                }

            }
            bean.setTarget(target);
            bean.setDownlist(downlist);;
            bean.setUplist(uplist);
            list.add(bean);   
			uplist = new ArrayList();
			downlist = new ArrayList();
        }
		return list;
	}

}
