package com.yfw.chengjiaodan.test;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/28 10:50
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        String result = "C0000000009";
        int i = Integer.parseInt(result.substring(1));
        String stringFormat = String.format("C%010d", ++i);
        System.out.println(stringFormat);
    }
}
