package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = { "/hello.controller" })
public class HelloController {

    @RequestMapping(method = { RequestMethod.GET })
    public String method() {
        System.out.println("hahaha");
        return null;
    }
}
