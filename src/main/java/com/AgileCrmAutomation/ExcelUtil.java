package com.AgileCrmAutomation;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
  
public class ExcelUtil {
	private static final CellType STRING = null;
	private static final CellType NUMERIC = null;
	private static final CellType BOOLEAN = null;
	private static final CellType NONE = null;
	private static final CellType BLANK = null;
	private static final CellType _NONE = null;
	private String getFileExtension(String filepath) {
		String Extension =filepath.substring(filepath.indexOf("."));
		System.out.println(Extension);
		return Extension;
	}
	private Workbook getWorkbookInstance(String filepath) throws IOException{
	Workbook wb;
	FileInputStream input=new FileInputStream(filepath);
	if(getFileExtension(filepath).equals(".xlsx")) {
		wb=new XSSFWorkbook(input);
	   }else {
		   wb=new HSSFWorkbook(input);
	   }
	   return wb;
	}
    private Sheet getSheet(String filepath,String sheetName) {
    	Sheet sheet=null;
    	try {
    		Workbook wb=getWorkbookInstance(filepath);
    		sheet=wb.getSheet(sheetName);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	return sheet;
    }
    
    public Object[][] getExcelData(String filepath, String sheetName){
    	String fileName = null;
		Sheet sheet=getSheet(filepath,fileName);
    	int totalRow=sheet.getPhysicalNumberOfRows();
    	int totalcolumn=sheet.getRow(0).getPhysicalNumberOfCells();
    	return getCellValue(sheet, totalRow, totalcolumn);
    }
    private Object[][] getCellValue(Sheet sheet, int totalRows, int totalcolmns){
    	Object[][] value = new Object[totalRows][totalRows];
    	for(int i=1; i<totalRows; i++) {
    		Row row = sheet.getRow(i);
    		
    		for(int j=0; j<totalRows; j++) {
    			Cell cell=row.getCell(j);
    			
    			CellType type=cell.getCellType();
    			
    			switch (type) {
    			
    			case STRING:
    				value[i][j]=cell.getStringCellValue();
    				break;
    			case NUMERIC:
    				value[i][j]=cell.getNumericCellValue();
    				break;
    			case BOOLEAN:
    				value[i][j]=cell.getBooleanCellValue();
    				break;
    			case _NONE:	
    				value[i][j]=null;
    				break;
    			case BLANK:
    				value[i][j]=null;
    				break;
    			default:
    				value[i][j]=null;	
    			}
    		}
    	}
    	return value;
    }
    
    public static void main(String[] args) {
         String filepath="C:\\Excel_Sheet\\TestData.xlsx";
         ExcelUtil excelValues=new ExcelUtil();
         Object[][] data=excelValues.getExcelData(filepath, "TestData");
         
         int rowLength=data.length;
         int columnLength=2;
         for(int i=1; i<=rowLength-1; i++) {
        	 for(int j=0; j<columnLength; j++) {
        		 System.out.println(data[i][j]);
            }
         }
  	  }
   }
  
   
    	
    		
    	
    	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  /*    static Workbook wb;
	public static void main(String[] args) throws IOException {
	 String filepath="C:\\Excel_Sheet\\TestData.xlsx";
     String extension=filepath.substring(filepath.indexOf("."));
     System.out.println(extension);
     FileInputStream input=new FileInputStream(filepath);
     if(extension.equals(".xlsx")) {
    	 wb=new XSSFWorkbook(input);
	 }else {
		 wb=new HSSFWorkbook(input);
	 }
     Sheet sheet=wb.getSheet("TestData");
     int totalRows=sheet.getPhysicalNumberOfRows();
     int totalColumns=sheet.getRow(0).getPhysicalNumberOfCells();
     
     for(int i=1;i<totalRows;i++) {
    	 Row row=sheet.getRow(i);
    	 for(int j=0;j<totalColumns;j++) {
    		 Cell cell=row.getCell(j);
    		 
    		 String value=cell.getStringCellValue();
    		 System.out.print(value +"  ");
    	 } 
    	 System.out.println();
     } 
     wb.close();
     input.close();
 }
}*/