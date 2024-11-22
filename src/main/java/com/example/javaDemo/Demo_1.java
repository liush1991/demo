package com.example.javaDemo;

import java.awt.*;
import java.util.Arrays;

public class Demo_1 {
    public static void main(String[] args) {
        int[]  arr = new int[]{1,2,3,4,5,6,7,8};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        arr = Arrays.copyOf(arr,6);
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

        System.out.println();
        arr = Arrays.copyOf(arr,9);
        System.out.println(arr.length);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public void paintObject(Graphics g){

    }
    public void pa(Graphics graphics){

    }

}
