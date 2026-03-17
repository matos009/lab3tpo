package com.app.logarifmics;
import com.app.MathFunction;

public class Logarifm3 implements MathFunction {

    private final NaturalLogarithm lnFunc;
    private final double base;

    public Logarifm3(NaturalLogarithm ln) {
        this.lnFunc = ln;
        this.base = ln.apply(3.0, 1e-9);
    }

    @Override
    public double apply(double x, double eps) {
        double value = lnFunc.apply(x, eps);
        return value / base;
    }
}