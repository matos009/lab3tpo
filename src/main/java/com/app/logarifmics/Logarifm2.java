package com.app.logarifmics;

import com.app.MathFunction;

public class Logarifm2 implements MathFunction {
    private final NaturalLogarithm baseLn;
    private final double ln2;

    public Logarifm2(NaturalLogarithm ln) {
        this.baseLn = ln;
        this.ln2 = ln.apply(2.0, 1e-10);
    }

    @Override
    public double apply(double x, double eps) {
        double numerator = baseLn.apply(x, eps);
        return numerator / ln2;
    }
}
