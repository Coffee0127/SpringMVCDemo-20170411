package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //接收資料
        String name = request.getParameter("name");

        //驗證資料
        Map<String, String> errors = new HashMap<>();
        request.setAttribute("errors", errors);

        if(name==null || name.length()==0) {
            errors.put("name", "name is required(mvc)");
        }

        if(errors!=null && !errors.isEmpty()) {
//            request.getRequestDispatcher(
//                    "/form.jsp").forward(request, response);
            return new ModelAndView("/form.jsp");
        }

        //呼叫Model，根據執行結果導向View
        HttpSession session = request.getSession();
        session.setAttribute("name", name + "(mvc)");

//        String path = request.getContextPath();
//        response.sendRedirect(path+"/success.jsp");
        return new ModelAndView("/success.jsp");
    }

}
