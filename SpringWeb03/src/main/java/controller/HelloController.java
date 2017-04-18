package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import beans.propertyeditors.PrimitiveNumberEditor;
import model.FormBean;

@Controller
@RequestMapping(path = { "/hello.controller" })
@SessionAttributes(names = { "name" })
public class HelloController {

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        // 註冊 CustomDateEditor
        CustomDateEditor dateEditor =
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        webDataBinder.registerCustomEditor(Date.class, dateEditor);

        PrimitiveNumberEditor numberEditor =
                new PrimitiveNumberEditor(Integer.class, true);
        webDataBinder.registerCustomEditor(int.class, numberEditor);
    }

    @RequestMapping(method = { RequestMethod.GET })
    public String method(FormBean bean, BindingResult bindingResult, Model model) {

        System.out.println("bean=" + bean);
        System.out.println("BindingResult=" + bindingResult);

        // 驗證資料
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        String name = bean.getName();
        if (name == null || name.length() == 0) {
            errors.put("name", "name is required");
        }

        // 使用 org.springframework.validation.BindingResult 擷取錯誤欄位
        if (bindingResult != null && bindingResult.hasFieldErrors()) {
            if (bindingResult.getFieldError("date") != null) {
                errors.put("date", "date必須是日期");
            }

            if (bindingResult.getFieldError("number") != null) {
                errors.put("number", "number必須是整數");
            }
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
