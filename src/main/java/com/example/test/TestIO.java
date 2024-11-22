package com.example.test;



import java.io.*;

public class TestIO {
    public static void main(String[] args) throws IOException {
//        TestIO io=new TestIO();
//        io.test1();
        System.out.println(args.length);
        System.out.println(args[0]);
    }
    public void test1() throws IOException {
        File file=new File("E:"+File.separator+"tt"+File.separator+"test.txt");

        long d1= System.currentTimeMillis();
        OutputStream outputStream= new FileOutputStream(file,true);  //true 添加  false 覆盖
        String str = "\t\n水水反反复复反反复复水水反";
        byte[] b=str.getBytes();
        outputStream.write(b);
        outputStream.close();

        long d2= System.currentTimeMillis();
        ///
        Writer writer=new FileWriter(file,true);  //true 添加  false 覆盖
        writer.write("\t\n水水反反复复反反复复水水反");  // \t\n 换行
        writer.close();

        long d3= System.currentTimeMillis();
        System.out.println(d2-d1);
        System.out.println(d3-d2);
    }
    public void test2() throws IOException {
        File file=new File("E:"+File.separator+"tt"+File.separator+"test.txt");
        //1.
//        InputStream inputStream=new FileInputStream(file);
//        byte[] b=new byte[(int) file.length()];
//        inputStream.read(b);
//        inputStream.close();
//        String str=new String(b);
//        System.out.println(str);
        //2.

        Reader reader=new FileReader(file);
        char[] b2=new char[1024];
        int n = (int) reader.read(b2);
        String string = new String(b2, 0, n);
        System.out.println(string);
        reader.close();

    }
    public void test3(){
            BufferedReader l;
    }
}
