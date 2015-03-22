package br.com.semeru.poi.exporter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import br.com.semeru.poi.structure.DocumentStructure;
import br.com.semeru.poi.structure.SheetStructure;
import br.com.semeru.poi.style.StylesSXSSFSpreadsheets;

public class PoiExporter {
	
    private StylesSXSSFSpreadsheets stylesSXSSFSpreadsheets = new StylesSXSSFSpreadsheets();
    
    SXSSFWorkbook workBook = new SXSSFWorkbook();
	CellStyle blockedCell = null;
	CellStyle unblockedCell = null;
	
	public ByteArrayOutputStream export(DocumentStructure documentStructure){
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		buildTabs(documentStructure);
		try {
            byteArrayOutputStream = createByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArrayOutputStream;
	}

	private void buildTabs(DocumentStructure documentStructure) {
		
		blockedCell = stylesSXSSFSpreadsheets.formatCellStyles(workBook, false, null);
		unblockedCell = stylesSXSSFSpreadsheets.formatCellStyles(workBook, true, null);
		
		for (SheetStructure sheetStructure : documentStructure.sheetStructures) {
			SXSSFSheet sheet = (SXSSFSheet) workBook.createSheet(sheetStructure.tabLabel);
			createHeader(sheetStructure.headerColumns, sheet);
			createSheet(sheetStructure.source, sheet);
		}
	}
	
	private void createSheet(List<? extends Object> sourceObjects, SXSSFSheet sheet) {
		sheet.protectSheet("password");
		createLines(sourceObjects, sheet);
	}

	private void createLines(List<? extends Object> sourceObjects, SXSSFSheet sheet) {
		int rowCount = 1;
		for (Object sourceObject : sourceObjects) {
			Row rowSheet = sheet.createRow(rowCount++);
			createCell(sourceObject, rowSheet);
		}
	}

	private void createCell(Object sourceObject, Row rowSheet){
		int cellCount = 0;
		for (Field field : sourceObject.getClass().getFields()) {
			Cell cell = rowSheet.createCell(cellCount++);
			cell.setCellStyle(blockedCell);
			Object value = getFieldValue(sourceObject, field);
			if (value != null) cell.setCellValue(value.toString());
		}
	}

	private Object getFieldValue(Object sourceObject, Field field) {
		Object value = null;
		try {
			value = field.get(sourceObject);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private void createHeader(LinkedHashMap<String, String> columns, SXSSFSheet sheet) {
		Row rowSheet = sheet.createRow(0);
		rowSheet.setHeightInPoints(15);
		int cellCount = 0;
		for (String key : columns.keySet()) {
			Cell cell = rowSheet.createCell(cellCount++);
			if (key != null) {
				cell.setCellStyle(stylesSXSSFSpreadsheets.formatHeaderStyles(workBook, false));
				cell.setCellValue(columns.get(key));
			}
		}
	}

	private ByteArrayOutputStream createByteArray() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		workBook.write(byteArrayOutputStream);
		return byteArrayOutputStream;
	}
}