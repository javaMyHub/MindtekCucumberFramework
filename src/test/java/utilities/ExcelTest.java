//package utilities;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ExcelTest {
//    public static void main(String[] args) throws IOException {
//
//        String path = System.getProperty("user.dir")+"/src/test/resources/testdata/Data2 2.xlsx"; //path to Data1.xlxs
//
//        FileInputStream input = new FileInputStream(path);
//        Workbook workbook = new XSSFWorkbook(input); // pointing to ExcelSpreadSheet (MicrosoftWork) -> all files
//
//        Sheet sheet1= workbook.getSheet("Sheet1");// working on Sheet1
//
//        String firstName = sheet1.getRow(1).getCell(0).toString();
//        System.out.println(firstName);
//
//        System.out.println(sheet1.getRow(2).getCell(1).toString());
//
//        sheet1.getRow(2).getCell(1).setCellValue("Kevin"); // changing value of row1/cell1 -> last name
//
//        System.out.println(sheet1.getRow(2).getCell(1).toString());
//
//        FileOutputStream outputStream = new FileOutputStream(path);
//        workbook.write(outputStream);
//        outputStream.close();
//
//      ExcelUtils.openExcelFile("Data1", "Sheet1");
//        System.out.println(ExcelUtils.getValue(1,2));
//
//        ExcelUtils.setValue(1,2, "coconut@gmail.com");
//        System.out.println(ExcelUtils.getValue(1,2));
//
//        List <String> names=new ArrayList<>();
//        names.add("Nisa");
//        names.add("Kate");
//        names.add("Luiza");
//
//        for(String name: names){
//            ExcelUtils.setValue(1,2,name);
//            System.out.println(ExcelUtils.getValue(1,2));
//        }
//
//
//    }
//}
