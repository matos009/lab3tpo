package com.app.trigonoXYI;
import com.app.MathFunction;

public class Sinus implements MathFunction {

    @Override
    public double apply(double x, double eps) {

        x = x % (2 * Math.PI);

        double term = x;
        double result = x;
        int k = 1;

        while (Math.abs(term) > eps) {
            term *= -1 * x * x / ((2 * k) * (2 * k + 1));
            result += term;
            k++;
        }

        return result;
    }
}