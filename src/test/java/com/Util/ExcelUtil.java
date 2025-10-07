package com.Util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    // Constructor to open Excel file and sheet
    public ExcelUtil(String filePath, String sheetName) throws Exception {
        File src = new File(filePath);
        FileInputStream fis = new FileInputStream(src);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Method to get total rows in sheet
    public int getRowCount() {
        return sheet.getLastRowNum();  // returns last row index
    }

    // Method to fetch one row data as String array
    public String[] getRowData(int rowIndex) {
        int totalCols = sheet.getRow(0).getLastCellNum();  // header count
        String[] rowData = new String[totalCols];

        for (int i = 0; i < totalCols; i++) {
            rowData[i] = sheet.getRow(rowIndex).getCell(i).getStringCellValue();
        }

        return rowData;
    }

    // Optional: close workbook
    public void closeWorkbook() throws Exception {
        workbook.close();
    }
}