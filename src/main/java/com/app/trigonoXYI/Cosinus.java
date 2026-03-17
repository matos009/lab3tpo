package com.app.trigonoXYI;

import com.app.MathFunction;

public class Cosinus implements MathFunction {

    private final Sinus sin;

    public Cosinus(Sinus sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double x, double eps) {
        return sin.apply(Math.PI / 2 - x, eps);
    }
}