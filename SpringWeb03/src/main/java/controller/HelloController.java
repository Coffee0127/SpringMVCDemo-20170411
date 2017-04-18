package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import model.FormBean;

@Controller
@RequestMapping(path = { "/hello.controller" })
@SessionAttributes(names = { "name" })
public class HelloController {

    @RequestMapping(method = { RequestMethod.GET })
    public String method(@RequestParam String name, Model model,
            FormBean bean) {

        System.out.println(bean);

        // 驗證資料
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        if (name == null || name.length() == 0) {
            errors.put("name", "name is required");
        }

        if (errors != null && !errors.isEmpty()) {
            return "form.error";
        }

        // 呼叫Model，根據執行結果導向View
        // 使用 @SessionAttributes 將其放入 session 中
        model.addAttribute("name", name);

        return "form.success";
    }
}
