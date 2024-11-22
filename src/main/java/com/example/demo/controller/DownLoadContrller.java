package com.example.demo.controller;

import com.example.demo.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi2.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "下载") // 类文档显示内容
@RequestMapping("/downloadController")
public class DownLoadContrller {
    @RequestMapping("/loadpage.do")
    @ApiOperation(value = "页面") // 接口文档显示内容
    public String loadpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("downloadController/loadpage.do");
//        request.getRequestDispatcher("/testController/login.do").forward(request, response);
//        return null;
        return "loadpage";
    }

    /**
     * 下载xls文件,有模板
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/download1.do")
    public void download1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = "下载模板一.xls";



        fileName = new String(fileName.getBytes(),"ISO-8859-1");
        response.setHeader("Content-disposition", "attachment; filename=" + fileName);
        response.setContentType("application/octet-stream");
        InputStream fileInputStream=  DownLoadContrller.class.getClassLoader().getResourceAsStream("static/xls/EmployeeBatchDPAdd.xls");
        OutputStream outputStream= null;

        try {
            outputStream = response.getOutputStream();
            byte[]  bytes= new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            outputStream.write(bytes);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
        }


    }

    /**
     * 下载文件 .xls 无模板
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/download2.do")
    public void download2(HttpServletRequest request, HttpServletResponse response) throws IOException {
      //  HSSFWorkbook
        //获得表格的值
        Map map = new HashMap();
        List<Map<String,Object>> datalist = new ArrayList();
        map.put("user_id","1");
        map.put("name","刘少华");
        map.put("degree","本科");
        datalist.add(map);
        // 3 生成excel
        String []title = {"UID","姓名","学历"};
        List<String[]> titlelist= new ArrayList();
        titlelist.add(new String[]{"uid","user_id","7000",""});
        titlelist.add(new String[]{"姓名","name","5000",""});
        titlelist.add(new String[]{"学历","degree","5000","1-小学;2-中学;3-大学;4-硕士;5-博士"});

        HSSFWorkbook wb = new ExcelUtil().getHSSFWorkbook("SheetName",titlelist,datalist,null);
        // 4 响应到客户端,弹出下载提示框
        try {
            this.setResponseHeader(response, "user.xls");

            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("excel导出错误："+e);
        }

    }
    /**
     * 功能描述: 发送响应流方法
     *
     *
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.out.println("excel导出错误："+e);
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("excel导出错误："+ex);
        }
    }
    @Value("${spring.file.path}")
    private String filepath;
    @ResponseBody
    @RequestMapping("/upload.do")
    public String upload(MultipartFile file) throws Exception {
        file.getBytes();
        String fileName =file.getOriginalFilename();
        String path = DownLoadContrller.class.getResource("/").toString();
      //  File file1 = new File(path+"/META-INF/resources/upload/"+fileName);
      //  File file1 = new File("D:\\java\\idea\\demo\\target\\classes\\META-INF\\resources\\upload\\"+fileName);
      //  File file1 = new File("D:\\java\\idea\\demo\\src\\main\\webapp\\upload\\"+fileName);
        //保存
        File file1 = new File(filepath+fileName);
        file.transferTo(file1);
        System.out.println(file.getOriginalFilename());
        //解析
        List list =new ExcelUtil().readExcel(file1);
        System.out.println(list);
       return "上传成功";
    }
    @ResponseBody
    @RequestMapping("/upload2.do")
    public String upload2(HttpServletRequest request){
        List<MultipartFile> files= ((MultipartRequest) request).getFiles("file");
        for(int i=0 ; i<files.size();i++){
            System.out.println(files.get(i).getOriginalFilename());
        }
      //  System.out.println(files.length);
        return "上传成功";
    }
}
