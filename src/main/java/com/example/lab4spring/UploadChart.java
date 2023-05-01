package com.example.lab4spring;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;


@Controller
public class UploadChart {

    public static double[][] points;
    public static double[][] ABResults;

    @GetMapping("/chart")
    public void handleChart(HttpServletResponse response, Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        Charts drawChart = new Charts();

        writeChartAsJPEG(out, drawChart.drawChart(points, ABResults), 400, 400);

    }
}
