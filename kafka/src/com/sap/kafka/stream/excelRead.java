package com.sap.kafka.stream;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	public static void main(String[] args) {
		try {
			File file = new File("C:\\Users\\i058963\\Desktop\\auth.xlsx"); // creating a new file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			String value1 = "";
			int colCount = 0;
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {
					String value2 = "";
					Cell cell = cellIterator.next();
					// value = cell.getStringCellValue();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: // field that represents string cell type
						// System.out.print(cell.getStringCellValue() + "\t\t\t");
						value2 = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
						// System.out.print(cell.getNumericCellValue() + "\t\t\t");
						value2 = cell.getNumericCellValue() + "";
						value2 = value2.replace(".0", "");
						break;
					default:
					}
					value1 = value1 + "<td>" + value2 + "</td>";
				}
				if(!value1.isEmpty()) {
					value1 = "<tr>" + value1 + "</tr>";
				}
				System.out.println(value1);
				value1 = "";
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}