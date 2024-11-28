package fileutility;


	import org.apache.poi.ss.usermodel.*;
	import java.io.FileInputStream;
	import java.io.IOException;

	public class ExcelUtils {

	    private static Workbook workbook;
	    private static Sheet sheet;

	    // Open Excel File
	    public static void setExcelFile(String path, String sheetName) throws IOException {
	        FileInputStream fis = new FileInputStream(path);
	        workbook = WorkbookFactory.create(fis);
	        sheet = workbook.getSheet(sheetName);
	    }

	    // Get cell data and handle different cell types
	    public static String getCellData(int rowNum, int colNum) {
	        Cell cell = sheet.getRow(rowNum).getCell(colNum);
	        String cellValue = "";

	        // Check the cell type and handle accordingly
	        switch (cell.getCellType()) {
	            case STRING:
	                cellValue = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    cellValue = cell.getDateCellValue().toString(); // Handle dates if necessary
	                } else { 
	                    cellValue = String.valueOf((int) cell.getNumericCellValue()); // Convert numeric value to String
	                }
	                break;
	            case BOOLEAN:
	                cellValue = String.valueOf(cell.getBooleanCellValue());
	                break;
	            case BLANK:
	                cellValue = "";
	                break;
	            default:
	                cellValue = "";
	        }
	        return cellValue;
	    }

		/*
		 * // Get cell data public static String getCellData(int rowNum, int colNum) {
		 * Cell cell = sheet.getRow(rowNum).getCell(colNum); return
		 * cell.getStringCellValue(); }
		 */

	    // Get number of rows
	    public static int getRowCount() {
	        return sheet.getLastRowNum() + 1;
	    }
	}



