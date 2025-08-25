package com.empresa.proyecto.functional.util.practicelambda;

public class LambdaPractice4 {
    public static void main(String[] args) {
        LengthOfString2 len = str -> {
            int l = str.length();
            System.out.println("The length of the given String is: " + l);
            return l;
        };
        int length = len.length("BasicStrong");
        System.out.println(length);
    }
}

interface LengthOfString2 {
    int length(String s);
}
