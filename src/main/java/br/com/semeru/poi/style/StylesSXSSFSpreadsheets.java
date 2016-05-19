package br.com.semeru.poi.style;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class StylesSXSSFSpreadsheets {

	public CellStyle formatHeaderStyles(SXSSFWorkbook workBook, boolean vertical) {
		CellStyle cellStyleHeaders = workBook.createCellStyle();
		Font titleFonts = workBook.createFont();
		titleFonts.setColor(IndexedColors.BLACK.index);
		titleFonts.setBoldweight(Font.BOLDWEIGHT_BOLD);
		titleFonts.setFontName("Calibri");
		titleFonts.setFontHeightInPoints((short)11);
		cellStyleHeaders.setFillForegroundColor(IndexedColors.WHITE.index);
		cellStyleHeaders.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyleHeaders.setFont(titleFonts);
		cellStyleHeaders.setAlignment(vertical ? CellStyle.ALIGN_RIGHT : CellStyle.ALIGN_CENTER);
		cellStyleHeaders.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyleHeaders.setLocked(false);
		formatEdges(cellStyleHeaders);
		return cellStyleHeaders;
	}

	private void lockToEdition(CellStyle cellStyle) {
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		cellStyle.setLocked(true);
	}

	private void freeToEdition(CellStyle cellStyle) {
		cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
		cellStyle.setLocked(false);
	}
	
	public CellStyle formatCellStyles(SXSSFWorkbook workBook, boolean locked, String format) {
		CellStyle cellStyle = workBook.createCellStyle();
		Font font = workBook.createFont();
		font.setFontName("Calibri");
		font.setFontHeightInPoints((short)10);
		if (locked) lockToEdition(cellStyle);
		else freeToEdition(cellStyle);
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);
		formatEdges(cellStyle);
		
		if (format != null && !format.isEmpty()) {
			cellStyle.setDataFormat(workBook.createDataFormat().getFormat(format));
		}
		
		return cellStyle;
	}	
	
	private void formatEdges(CellStyle cellStyleHeaders) {
		cellStyleHeaders.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyleHeaders.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyleHeaders.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyleHeaders.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	}
	
}
