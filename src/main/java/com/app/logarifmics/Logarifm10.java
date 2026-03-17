package com.app.logarifmics;

import com.app.MathFunction;

public class Logarifm10 implements MathFunction {

    private final NaturalLogarithm lnFunc;
    private final double base;

    public Logarifm10(NaturalLogarithm ln) {
        this.lnFunc = ln;
        this.base = ln.apply(10.0, 1e-9);
    }

    @Override
    public double apply(double x, double eps) {
        return lnFunc.apply(x, eps) / base;
    }
}