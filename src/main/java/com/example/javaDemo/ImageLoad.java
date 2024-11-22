package com.example.javaDemo;

import java.io.File;
public class ImageLoad {
    public static void main(String[] args) {
        try {

            String basePath1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            File file = new File(basePath1+"META-INF/resources/image/hero0.png");
            //BufferedImage img= ImageIO.read(file);
            System.out.println("basePath1  "+basePath1);
            System.out.println(file.getAbsolutePath());

            String basePath2 = ImageLoad.class.getResource("").getPath();
            System.out.println("basePath2  "+basePath2);
            String basePath3 =ImageLoad.class.getResource("/").getPath() ;
            System.out.println("basePath3  "+basePath3);
            //basePath1=basePath3
            System.out.println(basePath1.equals(basePath3));
            System.out.println(basePath1==basePath3);

            System.getProperty("user.dir");
            System.out.println(System.getProperty("user.dir"));

            //      BufferedImage img= ImageIO.read(new File("D:\\java\\idea\\demo\\src\\main\\resources\\image\\hero0.png"));
        //    D:\java\idea\demo\target\classes\META-INF\resources\image
            //   BufferedImage img= ImageIO.read(ImageLoad.class.getResource("/image/hero0.png")); ///
          //     BufferedImage img= ImageIO.read(ImageLoad.class.getResource("classpath:image/hero0.png"));  ///
           //    System.out.println(img.getHeight());
         //  String basePath4= ImageLoad.class.getResource("classpath:image/hero0.png").getPath();
          //  System.out.println(basePath4);
        } catch (Exception e) {
            System.out.println("加载图片出错...");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
