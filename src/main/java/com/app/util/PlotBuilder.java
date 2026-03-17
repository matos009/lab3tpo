package com.app.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

import java.io.*;

public class PlotBuilder {

    public void build(File file, String outputDir) throws Exception {

        String title = file.getName().replace(".csv", "");
        XYSeries data = new XYSeries(title);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length != 2) continue;

                try {
                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);

                    if (!Double.isFinite(y)) continue;

                    data.add(x, y);

                } catch (Exception ignored) {
                }
            }
        }

        XYSeriesCollection dataset = new XYSeriesCollection(data);

        JFreeChart chart = ChartFactory.createXYLineChart(
                title,
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        File out = new File(outputDir + "/" + title + ".png");
        ChartUtils.saveChartAsPNG(out, chart, 1000, 600);
    }
}