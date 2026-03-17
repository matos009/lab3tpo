package com.app.util;



import com.app.MathFunction;

public class ExecutionManager {

    private double left;
    private double right;
    private double step;
    private double eps;

    public void setRange(double from, double to) {
        this.left = from;
        this.right = to;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public void setPrecision(double eps) {
        this.eps = eps;
    }

    public void process(String file, MathFunction func) {
        ResultWriter.export(file, func, left, right, step, eps);
    }
}
