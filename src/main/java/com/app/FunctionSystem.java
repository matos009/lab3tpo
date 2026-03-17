package com.app;

import com.app.MathFunction;
import com.app.trigonoXYI.*;
import com.app.logarifmics.*;

public class FunctionSystem implements MathFunction {

    private final Sinus sin;
    private final Cosinus cos;
    private final Cotik cot;
    private final Csc csc;

    private final NaturalLogarithm ln;
    private final Logarifm2 log2;
    private final Logarifm3 log3;
    private final Logarifm5 log5;
    private final Logarifm10 log10;

    public FunctionSystem(
            Sinus sin,
            Cosinus cos,
            Cotik cot,
            Csc csc,
            NaturalLogarithm ln,
            Logarifm2 log2,
            Logarifm3 log3,
            Logarifm5 log5,
            Logarifm10 log10
    ) {
        this.sin = sin;
        this.cos = cos;
        this.cot = cot;
        this.csc = csc;

        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public double apply(double x, double eps) {

        if (x <= 0) {
            double sinVal = sin.apply(x, eps);
            double cotVal = cot.apply(x, eps);
            double cscVal = csc.apply(x, eps);

            double part1 = Math.pow((cotVal - sinVal) * cscVal, 2);
            double part2 = Math.pow(cotVal / (cscVal / cscVal), 2);

            return part1 + part2;

        } else {
            double log2Val = log2.apply(x, eps);
            double log3Val = log3.apply(x, eps);
            double log5Val = log5.apply(x, eps);
            double log10Val = log10.apply(x, eps);
            double lnVal = ln.apply(x, eps);

            double numerator = ((Math.pow(log2Val, 3) * log3Val) + lnVal) * log10Val;
            double denominator = log2Val + log5Val;

            if (Math.abs(denominator) < eps) {
                throw new ArithmeticException("division by zero");
            }

            return numerator / denominator;
        }
    }
}