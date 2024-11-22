package com.example.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TestDate {
    public static void main(String[] args) {
        long a=System.currentTimeMillis();
        Date date=new Date();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy");
        String s =simpleDateFormat.format(date);
        System.out.println(s);

        Calendar calendar=new GregorianCalendar();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.YEAR));

        long b=System.currentTimeMillis();
        System.out.println(b-a);

        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.maxMemory()/1024/1024);
        System.out.println(runtime.freeMemory());

        System.out.println(DateFormat.getDateInstance().format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.YEAR_FIELD,new Locale("zh","ch")).format(new Date()));
        System.out.println(DateFormat.getDateTimeInstance().format(new Date()));
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.YEAR_FIELD,DateFormat.ERA_FIELD,new Locale("zh","ch")).format(new Date()));

    }
}
