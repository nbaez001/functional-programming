package com.empresa.proyecto.lambda;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread executed!");
    }
}
