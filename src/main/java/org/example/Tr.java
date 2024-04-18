package org.example;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tr tr = (Tr) o;
        return Double.compare(a, tr.a) == 0 && Double.compare(b, tr.b) == 0 && Double.compare(c, tr.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
