package com.app.trigonoXYI;

import com.app.MathFunction;

public class Csc implements MathFunction {

    private final Sinus sin;

    public Csc(Sinus sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double x, double eps) {
        double value = sin.apply(x, eps);

        if (Math.abs(value) < eps) {
            throw new ArithmeticException("csc undefined");
        }

        return 1.0 / value;
    }
}