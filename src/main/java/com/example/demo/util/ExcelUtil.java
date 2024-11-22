package com.example.demo.util;

import org.apache.poi2.hssf.usermodel.*;
import org.apache.poi2.hssf.util.CellRangeAddressList;
import org.apache.poi2.hssf.util.HSSFColor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * XSSF .xlsx
 * HSSF .xls
 */
public class ExcelUtil {
    private HSSFCellStyle titleStyle = null;
    private HSSFCellStyle dataStyle = null;
    public HSSFWorkbook getHSSFWorkbook(String sheetName, List<String[]> titlelist, List<Map<String, Object>> datalist, HSSFWorkbook wb) {
        //创建一个HSSFWorkbook  对应一个excel
        if(wb==null){
            wb=new HSSFWorkbook();
        }
        //在excel中创建一个sheet
        HSSFSheet sheet=wb.createSheet(sheetName);

        //创建单元格格式
        //设置表头样式
        this.setTitleCellStyles(wb,sheet,titlelist);
        //设置数据样式
        this.setDataCellStyles(wb,sheet,titlelist);
        HSSFCell cell = null;
        //在sheet中创建第一行
        HSSFRow row = sheet.createRow(0);
        //设置第一行表头字段
        for(int i=0;i<titlelist.size();i++){
            cell=row.createCell(i);
            cell.setCellValue((titlelist.get(i))[0]);
            cell.setCellStyle(titleStyle);
        }
        Map<String, Object> map = null;
        //创建内容
        for(int i=0;i<datalist.size();i++){
            map = datalist.get(i);
            row = sheet.createRow(i + 1);
            //将内容按顺序赋给对应的列对象

            for(int j=0;j<titlelist.size();j++){
                cell=row.createCell(j);
                cell.setCellValue(map.get((titlelist.get(j))[1]).toString());
                cell.setCellStyle(dataStyle);
            }
        }
        //设置下拉框
        for(int i=0;i<titlelist.size();i++){
            String[] data= titlelist.get(i)[3].split(";");
            if(titlelist.get(i)[3].length()>0){
                //参数 下拉选项,列,起始行,结束列
                HSSFDataValidation data_validation_list = this.getDataValidationByFormula(data,i,1,1000);
                sheet.addValidationData(data_validation_list);
            }

        }
      //  this.getDataValidationByFormula();
        return wb;
    }
    /**
     * 列头样式
     *
     * @param workbook
     * @param sheet
     */
    public void setTitleCellStyles(HSSFWorkbook workbook, HSSFSheet sheet,List<String[]> titlelist) {
        titleStyle = workbook.createCellStyle();

        // 设置边框
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置背景色
        titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // 设置居中
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置字体
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11); // 设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
        titleStyle.setFont(font);// 选择需要用到的字体格式
        // 设置自动换行
        titleStyle.setWrapText(true);
        // 设置列宽 ,第一个参数代表列id(从0开始),第2个参数代表宽度值
        for(int i = 0;i < titlelist.size();i++){
            sheet.setColumnWidth(i, Integer.parseInt((titlelist.get(i))[2]));
        }

    }

    /**
     * 数据样式
     *
     * @param workbook
     * @param sheet
     */
    public void setDataCellStyles(HSSFWorkbook workbook, HSSFSheet sheet,List<String[]> titlelist) {
        dataStyle = workbook.createCellStyle();

        // 设置边框
        dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // 设置背景色
        dataStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        dataStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // 设置居中
        dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置字体
        HSSFFont font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 11); // 设置字体大小
        dataStyle.setFont(font);// 选择需要用到的字体格式
        // 设置自动换行
        dataStyle.setWrapText(true);
    }
    /**
     * 使用已定义的数据源方式设置一个数据验证
     * 设置下拉框
     * @param formulaString
     * @return
     */
    public HSSFDataValidation getDataValidationByFormula(String[] formulaString, int col, int firstRow,int lastRow) {
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(formulaString);
        // 设置数据有效性加载在哪个单元格上。
        // 四个参数分别是：起始行、终止行、起始列、终止列

        CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, col, col);
        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        return data_validation_list;
    }


    //解析excel
    public List<List<List>>  readExcel(File file) throws Exception {
      //  String fileName = file.getOriginalFilename();
        String fileName = file.getName();
        String postfix = fileName.substring(fileName.lastIndexOf(".")+1);
        List<List<List>> lists = null;
        if("static/xls".equals(postfix)){
            lists=readXLS(file);
        }else if("xlsx".equals(postfix)){

        }else{
            throw  new Exception("文件不是excel格式");
        }
        return lists;
    }

    private List<List<List>> readXLS(File file) {
        List<List<List>> listList= new ArrayList();
        List<List> lists ;
        List list ;
        HSSFWorkbook hssfWorkbook;
        InputStream inputStream;
        HSSFSheet hssfSheet;
        HSSFRow hssfRow;
        HSSFCell hssfCell;
        try {
       //     inputStream=file.getInputStream();
            inputStream=new FileInputStream(file);
            hssfWorkbook=new HSSFWorkbook(inputStream);
            for(int i=0;i<hssfWorkbook.getNumberOfSheets();i++){
                lists = new ArrayList<>();
                hssfSheet= hssfWorkbook.getSheetAt(i);
                for(int j=1;j<=hssfSheet.getLastRowNum();j++){   //j=1  排除第一行表头
                    hssfRow = hssfSheet.getRow(j);
                    list = new ArrayList<>();
                    for(int n=0;n<hssfRow.getLastCellNum();n++){
                        hssfCell = hssfRow.getCell(n);
                        if(hssfCell==null){
                            list.add("");
                        }else{
                            getHSSFValue(list,hssfCell);
                        }
                    }
                    lists.add(list);
                }
                listList.add(lists);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listList;
    }
    public void getHSSFValue(List list,HSSFCell hssfCell){
        list.add(hssfCell.getStringCellValue());
    }

}
