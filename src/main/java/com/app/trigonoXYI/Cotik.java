package com.app.trigonoXYI;



import com.app.MathFunction;

public class Cotik implements MathFunction {

    private final Sinus sin;
    private final Cosinus cos;

    public Cotik(Sinus sin, Cosinus cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double apply(double x, double eps) {
        double s = sin.apply(x, eps);

        if (Math.abs(s) < eps) {
            throw new ArithmeticException("cot undefined");
        }

        double c = cos.apply(x, eps);
        return c / s;
    }
}