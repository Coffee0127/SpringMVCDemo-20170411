//package controller;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@WebServlet(
//		name="HelloServlet",
//		value="/hello.controller"
//)
//public class HelloServlet extends HttpServlet {
//    @Override
//    public void doGet(HttpServletRequest request,
//    		HttpServletResponse response) throws ServletException, IOException {
////接收資料
//    	String name = request.getParameter("name");
//
////驗證資料
//    	Map<String, String> errors = new HashMap<String, String>();
//    	request.setAttribute("errors", errors);
//
//    	if(name==null || name.length()==0) {
//    		errors.put("name", "name is required");
//    	}
//
//    	if(errors!=null && !errors.isEmpty()) {
//    		request.getRequestDispatcher(
//    				"/form.jsp").forward(request, response);
//    		return;
//    	}
//
////呼叫Model，根據執行結果導向View
//    	HttpSession session = request.getSession();
//    	session.setAttribute("name", name);
//
//    	String path = request.getContextPath();
//    	response.sendRedirect(path+"/success.jsp");
//    }
//}
