package com.empresa.proyecto.functional.util.practicelambda;

public class LambdaPractice3 {
    public static void main(String[] args) {
        LengthOfString lengthOfString = s -> s.length();
        int length =lengthOfString.length("BasicStrong");
        System.out.println(length);
    }
}

interface LengthOfString {
    int length(String s);
}
