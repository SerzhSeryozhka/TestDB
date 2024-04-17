package org.example;

public class Tr {
    double a,b,c;

    public Tr(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double perimetr(){
        return a+b+c;
    }

    @Override
    public String toString() {
        return "Tr{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
