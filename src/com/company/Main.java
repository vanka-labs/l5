package com.company;

public class Main {

    public static void main(String[] args) {

        Liner a = new Liner(0, 0, 0);
        Exponential b = new Exponential(0, 0, 0);


        new Frame("Series", a, b);
    }
}
