package GenericUtils;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class ExcelTestDataGenerator {

    public static Object[][] excelTestDataGenerator(String Sheetname) throws IOException, InvalidFormatException {
        XSSFSheet sheet;
        XSSFWorkbook work_Book = new XSSFWorkbook(new File(System.getProperty("user.dir") + "/src/test/TestData/BookingAPPTestData.xlsx"));
        sheet = work_Book.getSheet(Sheetname);
        int rows= sheet.getPhysicalNumberOfRows(); //2
        int coloumns=sheet.getRow(0).getLastCellNum();//2
        Object[][] obj=new Object[rows-1][coloumns];
        for(int i=1;i<rows;i++){
            for(int j=0;j<coloumns;j++){
                String cellvalue = sheet.getRow(i).getCell(j).toString();
                obj[i-1][j]=cellvalue;
                System.out.println(" Values" +cellvalue);
            }
        }
        return obj;
    }
}
