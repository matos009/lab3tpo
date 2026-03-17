package com.app;
import com.app.logarifmics.*;
import com.app.trigonoXYI.*;
import com.app.util.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final String BASE_PATH = "src/main/resources/";

    public static void main(String[] args) {
        try {
            start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void start() throws Exception {

        ExecutionManager manager = new ExecutionManager();
        PlotBuilder plotter = new PlotBuilder();

        System.out.println("Enter start value:");
        double from = input.nextDouble();

        System.out.println("Enter end value:");
        double to = input.nextDouble();

        System.out.println("Enter step:");
        double step = input.nextDouble();

        System.out.println("Enter precision:");
        double eps = input.nextDouble();

        manager.setRange(from, to);
        manager.setStep(step);
        manager.setPrecision(eps);

        // trig
        Sinus sin = new Sinus();
        Cosinus cos = new Cosinus(sin);
        Cotik cot = new Cotik(sin, cos);
        Csc csc = new Csc(sin);

        // logs
        NaturalLogarithm ln = new NaturalLogarithm();
        Logarifm2 log2 = new Logarifm2(ln);
        Logarifm3 log3 = new Logarifm3(ln);
        Logarifm5 log5 = new Logarifm5(ln);
        Logarifm10 log10 = new Logarifm10(ln);

        // system
        FunctionSystem system = new FunctionSystem(
                sin, cos, cot, csc,
                ln, log2, log3, log5, log10
        );

        // export CSV
        manager.process(BASE_PATH + "sin.csv", sin);
        manager.process(BASE_PATH + "cos.csv", cos);
        manager.process(BASE_PATH + "ln.csv", ln);
        manager.process(BASE_PATH + "log2.csv", log2);
        manager.process(BASE_PATH + "log3.csv", log3);
        manager.process(BASE_PATH + "log5.csv", log5);
        manager.process(BASE_PATH + "log10.csv", log10);
        manager.process(BASE_PATH + "system.csv", system);

        // charts
        String chartsDir = BASE_PATH + "charts";
        Files.createDirectories(Paths.get(chartsDir));

        File folder = new File(BASE_PATH);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".csv"));

        if (files != null) {
            for (File f : files) {
                try {
                    plotter.build(f, chartsDir);
                } catch (Exception ignored) {
                }
            }
        }

        System.out.println("done ✔");
    }
}