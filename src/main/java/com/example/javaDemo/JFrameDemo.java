package com.example.javaDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JFrameDemo extends JPanel{
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("demo");//创建一个窗口
        JFrameDemo jFrameDemo = new JFrameDemo();//创建面板
        jFrame.add(jFrameDemo);//将面板添加到窗口
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口则关闭程序
        jFrame.setSize(500,700);//修改尺寸
        jFrame.setLocationRelativeTo(null); //居中设置
        jFrame.setVisible(true); //1.使窗口可见,,,默认不可见 2.尽快调用paint方法
        jFrameDemo.action();//启动程序的 执行
    }
    public void action(){
        System.out.println("ddddddd");
        repaint();  //调用画图方法


    }

    /**
     * 画图方法
     * @param g
     */
    public void paint(Graphics g){
        paintObject(g);
    }

    /**
     * 画图
     * @param g
     */
    public void paintObject(Graphics g){//对窗口画对象

        g.drawImage(getImage(), 111, 111, null);

        g.drawString("666",300,300);



    }

    /**
     * 获取图片
     * @return
     */
    public  BufferedImage getImage() {
        BufferedImage img;
        try {

//            String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//            File file = new File(basePath+"META-INF/resources/image/hero0.png");
//            System.out.println(file.getPath().toString());
//            img= ImageIO.read(file);
//
//        //    img= ImageIO.read(ImageLoad.class.getResource("/image/hero0.png"));
//            System.out.println(img.getHeight());
             System.out.println(JFrameDemo.class.getResource(""));
            System.out.println(JFrameDemo.class.getResource("/"));
             img=ImageIO.read(JFrameDemo.class.getResource("/static/image/hero0.png"));
        } catch (Exception e) {
            System.out.println("加载图片出错...");
            e.printStackTrace();
            throw new RuntimeException();
        }
        return img;
    }

}
