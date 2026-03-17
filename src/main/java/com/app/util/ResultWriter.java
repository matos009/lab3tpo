package com.app.util;
import com.app.MathFunction;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class ResultWriter {

    public static void export(String path,
                              MathFunction func,
                              double start,
                              double end,
                              double step,
                              double eps) {

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {

            out.println("x,value");

            for (double x = start; x <= end; x += step) {
                try {
                    double y = func.apply(x, eps);
                    out.printf(Locale.US, "%.8f,%.8f%n", x, y); // 💥 ВАЖНО
                } catch (Exception ignored) {
                }
            }

        } catch (IOException e) {
            System.out.println("file write error: " + e.getMessage());
        }
    }
}