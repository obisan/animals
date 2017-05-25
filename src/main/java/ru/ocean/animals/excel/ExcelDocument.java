package ru.ocean.animals.excel;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import ru.ocean.animals.formatter.DateFormatterImpl;
import ru.ocean.animals.model.Deceased;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ExcelDocument extends AbstractExcelView {

    private int rowIndex = 0;

    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String date = DateFormatterImpl.getInstance().format2excel(new Timestamp(Calendar.getInstance().getTime().getTime()));

        // Excel file name change
        String ss = "report_" + date + ".xls";

        response.setHeader("Content-Disposition", "attachment; filename=" + ss);

        List<Deceased> deceaseds = (List<Deceased>) model.get("deadsData");

        /////////////////////////////////////////////////////////////////////
        // New Excel sheet
        HSSFSheet excelSheet = workbook.createSheet("Отчет");
        setExcelTitle(excelSheet, workbook);
        setExcelHeader(excelSheet, workbook);

        /////////////////////////////////////////////////////////////////////
        // font and style for table
        Font font_table = workbook.createFont();
        font_table.setFontName("Times New Roman");
        font_table.setBoldweight(HSSFFont.SS_NONE);
        font_table.setColor(HSSFColor.BLACK.index);

        CellStyle tableStyle = workbook.createCellStyle();
        tableStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
        tableStyle.setAlignment(HorizontalAlignment.CENTER);
        tableStyle.setFont(font_table);

        //Get data from model
        for (Deceased deceased : deceaseds) {
            HSSFRow row = excelSheet.createRow(rowIndex++);
            row.createCell(0)   .setCellValue(deceased.getObject().getObject_name());
            row.getCell(0)      .getCellStyle().setAlignment(HorizontalAlignment.CENTER);

            row.createCell(1)   .setCellValue(deceased.getDeceased_count());
            row.getCell(1)      .getCellStyle().setAlignment(HorizontalAlignment.CENTER);

            row.createCell(2)   .setCellValue(DateFormatterImpl.getInstance().format2excelshort(deceased.getDeceased_date()));
            row.getCell(2)      .getCellStyle().setAlignment(HorizontalAlignment.CENTER);

            row.createCell(3)   .setCellValue(deceased.getTank().getTank_number());
            row.getCell(3)      .getCellStyle().setAlignment(HorizontalAlignment.CENTER);

            row.setHeight((short) 700);
            row.setRowStyle(tableStyle);
        }

        this.rowIndex = 0;
    }

    void setExcelTitle(HSSFSheet excelSheet, HSSFWorkbook workbook) {
        /////////////////////////////////////////////////////////////////////
        // main title
        Font font_title = workbook.createFont();
        font_title.setFontName("Times New Roman");
        font_title.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font_title.setColor(HSSFColor.WHITE.index);

        CellStyle styleTitle = workbook.createCellStyle();
        styleTitle.setFillForegroundColor(HSSFColor.WHITE.index);
        styleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleTitle.setFont(font_title);



    }

    void setExcelHeader(HSSFSheet excelSheet, HSSFWorkbook workbook) {
        /////////////////////////////////////////////////////////////////////
        // header of table
        Font font_header = workbook.createFont();
        font_header.setFontName("Times New Roman");
        font_header.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font_header.setColor(HSSFColor.WHITE.index);

        // Create Style for header
        CellStyle styleHeader = workbook.createCellStyle();
        styleHeader.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        styleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
        styleHeader.setFont(font_header);

        /////////////////////////////////////////////////////////////////////
        //set Excel Header names
        HSSFRow header = excelSheet.createRow(rowIndex++);

        header.createCell(0).setCellValue("Имя животного");
        header.getCell(0).setCellStyle(styleHeader);
        header.getCell(0).getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        header.getCell(0).getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);

        header.createCell(1).setCellValue("Количество");
        header.getCell(1).setCellStyle(styleHeader);
        header.getCell(1).getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        header.getCell(1).getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);

        header.createCell(2).setCellValue("Дата отхода");
        header.getCell(2).setCellStyle(styleHeader);
        header.getCell(2).getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        header.getCell(2).getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);

        header.createCell(3).setCellValue("Танк отхода");
        header.getCell(3).setCellStyle(styleHeader);
        header.getCell(3).getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        header.getCell(3).getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);

        excelSheet.setColumnWidth(0, 7000);
        excelSheet.setColumnWidth(1, 3000);
        excelSheet.setColumnWidth(2, 3000);
        excelSheet.setColumnWidth(3, 5000);

        header.setHeight((short) 700);

    }
}
