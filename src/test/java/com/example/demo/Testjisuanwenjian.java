package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Testjisuanwenjian {
    private String str=new String("--");
    private long fileSize ;
    private long fileLine;
    public static void main(String[] args) {
        String path = "D:\\java\\api\\javadoc\\com\\yinhai\\sysframework\\dto";
        File file = new File(path);
        Testjisuanwenjian testjisuanwenjian=new Testjisuanwenjian();
        testjisuanwenjian.proFile(file);
        System.out.println("大小:"+testjisuanwenjian.fileSize+"b");
        System.out.println("行数:"+testjisuanwenjian.fileLine);

    }

    private  long proFile2(String path) {
        long line = 0;
        try {
            Stream<String> lines= Files.lines(Paths.get(path));
            line=lines.count();
            lines.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    private  long proFile(File file) {
        if (file.exists()&&file.isFile()){
         //   System.out.println(str+file.getName());
          //  System.out.println(str+file.length());
            fileSize=fileSize+file.length();
            System.out.println(file.getPath());
            fileLine=fileLine+proFile2(file.getPath());
        } else if  (file.exists() && file.isDirectory()) {
         //   System.out.println(str+file.getName());
            str=str+"--";
            File[] files= file.listFiles();
            for (int i = 0; i <= files.length-1; i++) {
                proFile(files[i]);
            }
        }
        return fileSize;
    }

}
