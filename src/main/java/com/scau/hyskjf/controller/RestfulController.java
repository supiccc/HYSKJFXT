package com.scau.hyskjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by supiccc on 2018-08-13 23:01
 */
@Controller
public class RestfulController {
    @RequestMapping(value = "/")
    public String signin() {
        return "redirect:/Member/indexReal.html";
    }
}
