package com.example.lab4spring;


import com.example.lab4spring.Solution.AproxyMethod;
import com.example.lab4spring.Solution.Function;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class InputOutput {

    @GetMapping("/")
    public String chooseCount() {
        return "welcomePage";
    }


    @GetMapping("/list")
    public String inputForm(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }

    @GetMapping("/list9")
    public String inputForm9(Model model) {
        model.addAttribute("form", new Form());
        return "nine";
    }

    @GetMapping("/list10")
    public String inputForm10(Model model) {
        model.addAttribute("form", new Form());
        return "ten";
    }


    @GetMapping("/list11")
    public String inputForm11(Model model) {
        model.addAttribute("form", new Form());
        return "eleven";
    }

    @GetMapping("/list12")
    public String inputForm12(Model model) {
        model.addAttribute("form", new Form());
        return "twelve";
    }

    @GetMapping(value = "/form")
    public String outputForm(@ModelAttribute Form form, Model model) throws IOException {

        Function function = new Function();
        double[] x = function.convertXToArray(form.getList());
        double[] y = function.convertYToArray(form.getList());


        AproxyMethod aproxyMethod =
                new AproxyMethod(x, y);

        double[][] resultOfSystem = aproxyMethod.ABForAllFunctions();
        UploadChart.points = aproxyMethod.fifthFunction(x, y, resultOfSystem);
        UploadChart.ABResults = resultOfSystem;

        double[][] func1 = aproxyMethod.firstFunction(x, y, resultOfSystem);
        double[][] func2 = aproxyMethod.firstFunction(x, y, resultOfSystem);
        double[][] func3 = aproxyMethod.firstFunction(x, y, resultOfSystem);
        double[][] func4 = aproxyMethod.firstFunction(x, y, resultOfSystem);
        double[][] func5 = aproxyMethod.firstFunction(x, y, resultOfSystem);
        double[] bestFunc = function.getQ(func1, func2, func3, func4, func5);


        model.addAttribute("Func1", func1);
        model.addAttribute("Func2", func2);
        model.addAttribute("Func3", func3);
        model.addAttribute("Func4", func4);
        model.addAttribute("Func5", func5);
        model.addAttribute("BestFunc", bestFunc);


        model.addAttribute("result", form);
        return "result";
    }
}
