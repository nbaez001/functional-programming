package com.empresa.proyecto.functional.util.reactive;

public class CallBackDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread is running");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new CallBackDemo().runningAsync(new Callback() {
                    @Override
                    public void pushData(String data) {
                        System.out.println("Callback data: " + data);
                    }

                    @Override
                    public void pushComplte() {
                        System.out.println("Callback done!");
                    }

                    @Override
                    public void pushError(Exception ex) {
                        System.out.println("Callback error called, got an exception: " + ex);
                    }
                });
            }
        };
        Thread t = new Thread(r);
        t.start();

        Thread.sleep(2000);
        System.out.println("Main thread Completed!");
    }

    public void runningAsync(Callback callback) {
        System.out.println("I am running in separate thread");
        sleep(1000);
        callback.pushData("Data1");
        callback.pushData("Data2");
        callback.pushData("Data3");

        callback.pushError(new RuntimeException("Oops!"));
        callback.pushComplte();
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface Callback {
    void pushData(String data);

    void pushComplte();

    void pushError(Exception ex);
}
