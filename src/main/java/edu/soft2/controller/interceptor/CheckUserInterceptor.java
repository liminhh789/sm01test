package edu.soft2.controller.interceptor;

import edu.soft2.controller.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("CheckUserInterceptor.preHandle");
        Object user = request.getSession().getAttribute("user");
        if (user != null && user instanceof User) {
            System.out.println("已登录，爬过去");
            return true;//通过拦截器
        }
        System.out.println("你还没登录，爬去登录");
        response.sendRedirect(request.getContextPath()+"/user/index.jsp");
//        request.getRequestDispatcher("hello.do").forward(request, response);
        return false;
    }
//        //获取session对象
//        HttpSession session=request.getSession();
//        Object obj=session.getAttribute("user");
//        if (obj != null && obj instanceof User) {
//            System.out.println("拦截器放行");
//            return true;//拦截器放行
//        }
//        System.out.println("未登录，请先登录");
//        response.sendRedirect("/index.jsp");
//        return false;
//    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
