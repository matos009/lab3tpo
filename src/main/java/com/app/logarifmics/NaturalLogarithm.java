package com.app.logarifmics;

import com.app.MathFunction;

public class NaturalLogarithm implements MathFunction {
    @Override
    public double apply(double x, double eps) {
        if (x <= 0) {
            throw new ArithmeticException("invalid input");
        }

        double z = (x - 1) / x;
        double term = z;
        double result = 0.0;
        int i = 1;

        while (Math.abs(term) > eps) {
            result += term / i;
            i++;
            term *= z;

            if (i > 100000) {
                throw new ArithmeticException("too many iterations");
            }
        }

        return result;
    }
}
