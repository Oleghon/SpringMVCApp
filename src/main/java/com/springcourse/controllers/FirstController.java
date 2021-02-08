package com.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {


        //   System.out.println("Hello, " + name + " " + surname);

        model.addAttribute("message", "hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        int res = 0;



        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a")int a,
                             @RequestParam("b") int b,
                             @RequestParam("act")String act, Model model){
        double res;
        switch (act) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / (double)b;
                break;
            default: res = 0.0;
            break;
        }

        model.addAttribute("result", res);
        return "first/calculator";
    }
}
