package com.controller;

import com.service.CaculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam("first-operand") float firstOperand, @RequestParam("second-operand") float secondOperand, @RequestParam char operator) {

        float result = CaculatorService.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);

        ModelAndView modelAndView = new ModelAndView("/index");
//        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("message", firstOperand + " " + operator + " " + secondOperand + " = " + result);
        return modelAndView;
//        return "/index";
    }
}
