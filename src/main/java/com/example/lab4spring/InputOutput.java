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

    @GetMapping("/list")
    public String inputForm(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }

    @GetMapping(value = "/form")
    public String outputForm(@ModelAttribute Form form, Model model) throws IOException {

        Function function = new Function();


        AproxyMethod aproxyMethod =
                new AproxyMethod(function.convertXToArray(form.getList()), function.convertYToArray(form.getList()));

        aproxyMethod.lineApproximation();
        model.addAttribute("result", form);
        return "result";
    }
}
