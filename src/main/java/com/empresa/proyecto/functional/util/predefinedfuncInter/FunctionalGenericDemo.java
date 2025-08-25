package com.empresa.proyecto.functional.util.predefinedfuncInter;

public class FunctionalGenericDemo {
    public static void main(String[] args) {
        FunctionalGenerics<String, String> fun = s -> s.substring(1,5);
        System.out.println(fun.execute("BasicsStrong"));

        FunctionalGenerics<String, Integer> fun2 = s -> s.length();
        System.out.println(fun2.execute("BasicsStrong"));
    }
}

@FunctionalInterface
interface FunctionalGenerics<T, R> {
    R execute(T t);
}
