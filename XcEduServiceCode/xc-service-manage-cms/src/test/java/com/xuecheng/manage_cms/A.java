package com.xuecheng.manage_cms;

public class A {
    static int i ;
    public static void main(String sgf[]) {
        /*StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        int[] arr =new int[6];
        int[] arr1 =new int[]{11,2,3,4};
        int[] arr2 ={11,2,3,4};

        System.out.println(a + "." + b);*/
        System.out.println(i);


    }
    public static void operate(StringBuffer x,StringBuffer y){
        x.append(y);
        y=x;
        System.out.println("x:"+x);
        System.out.println("y:"+y);
    }
}
