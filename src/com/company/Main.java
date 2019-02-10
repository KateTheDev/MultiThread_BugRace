package com.company;

class Bug extends Thread {
    private String name;
    private int steps = 0;

    Bug(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; ; i++) {
            if (steps < 20) {
                steps += Math.random() * 3;
                System.out.println("Bug " + Thread.currentThread().getName()+ " has done " + steps + "steps");
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
            }
            else {
                this.interrupt();
                System.out.println("Bug " + Thread.currentThread().getName()+ " has finished");
                break;
            }
        }
    }
}

public class Main    {
    public static void main(String[] args) {
        Bug alice = new Bug("Alice");
        Bug jim = new Bug("Jim");
        Bug eric = new Bug("Eric");
        Bug carl = new Bug("Carl");
        Bug amanda = new Bug("Amanda");

        System.out.println("Начали!");
        alice.start();
        jim.start();
        eric.start();
        carl.start();
        amanda.start();
    }
}