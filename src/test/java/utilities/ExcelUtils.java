package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    // WorkBook
    // Sheet
    // Row
    // Cell
    // filePath
    // openExcelFile (String path , string sheetName )
    // getValue (int rowNum, int cellNum) -> return String
    // setValue (int rowNum, int cellNum) -> String value that we provide
    // get number of rows ()- > return int


 private static XSSFWorkbook workbook;
 private  static XSSFSheet excelSheet;
 private  static XSSFRow row;
 private  static XSSFCell cell;
 private static  String filePath;


    /**
     * this method accesses the excel sheet and reads it
     * @param excelFileName
     * @param sheetName
     */


 public static  void openExcelFile(String excelFileName, String sheetName){

     filePath="src/test/resources/data/"+ excelFileName+ ".xlsx";

     try{
         File file =new File(filePath);
         FileInputStream input=new FileInputStream(file);
         workbook= new XSSFWorkbook(input);
         excelSheet= workbook.getSheet(sheetName);

     }catch (Exception e){
         System.out.println("No such file in directory.");

     }

 }

    /**
     * This Method will accept the row  and sell indexes and returns the cell;
     * @param rowNum
     * @param cellNum
     * @return
     */

 public static  String getValue(int rowNum , int cellNum){
     row =excelSheet.getRow(rowNum);
     cell=row.getCell(cellNum);

     return cell.toString();

 }

    /**
     * This method will take String value and put in a cell where you provide the row and cell number.
     * @param value
     * @param rowNum
     * @param cellNum
     * @throws IOException
     */
 public static void setValue (String value, int rowNum, int cellNum ) throws IOException {

     row= excelSheet.getRow(rowNum);
     cell= row.getCell(cellNum);
     if (cell == null ){
         cell=row.createCell(cellNum);
         cell.setCellType(CellType.STRING);
         cell.setCellValue(value);
     }else{
         cell.setCellValue(value);
     }

     FileOutputStream output=null;

     try {
         output = new FileOutputStream(filePath);
         workbook.write(output);

     }catch (FileNotFoundException e ){
         System.out.println("No such file in directory");
     }finally {
         output.close();
     }

 }

    /**
     * Method will return the number of rows in xcel file.
     * @return
     */

 public  static int getNumberOfRows (){

     return  excelSheet.getPhysicalNumberOfRows();
 }

}



































