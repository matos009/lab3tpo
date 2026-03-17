package com.app.logarifmics;

import com.app.MathFunction;

public class Logarifm5 implements MathFunction {

    private final NaturalLogarithm lnFunc;
    private final double base;

    public Logarifm5(NaturalLogarithm ln) {
        this.lnFunc = ln;
        this.base = ln.apply(5.0, 1e-9);
    }

    @Override
    public double apply(double x, double eps) {
        return lnFunc.apply(x, eps) / base;
    }
}