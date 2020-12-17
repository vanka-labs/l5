package com.company;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.*;

public abstract class Series {
    protected double first;
    protected double step;
    protected double n;

    public Series() {
        this.first = 0;
        this.step = 0;
        this.n = 0;
    }

    public double getFirst() {
        return first;
    }

    public double getStep() {
        return step;
    }

    public double getN() {
        return n;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public void setN(double n) {
        this.n = n;
    }

    public Series(double first, double step, double n) {
        this.first = first;
        this.step = step;
        this.n = n;
    }

    abstract double solve(int j);

    double sum() {
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += solve(i);
        return sum;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n; i++)
            s.append(solve(i) + " ");
        return s.toString();
    }
    void save()  {

        String s=this.toString();
        double summa=this.sum();

        try(FileOutputStream fos=new FileOutputStream("output.txt");
            PrintStream printStream = new PrintStream(fos))
        {
            printStream.println(s);
            printStream.println("Sum= "+ summa);
            System.out.println("Запись произведена в output.txt");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
 }


