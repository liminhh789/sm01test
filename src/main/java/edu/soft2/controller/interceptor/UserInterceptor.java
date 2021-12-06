package edu.soft2.controller.interceptor;

import edu.soft2.controller.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    /**
     * 相当于aop的前置增强方法
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

//        获取session
        Object obj=request.getSession().getAttribute("user");
        if (obj != null&&obj instanceof User) {
            return true;//通过拦截器
        }else {
            //跳转登录页面
            System.out.println("被拦截!!!");
        request.getRequestDispatcher("login.jsp").forward(request,response);
        return false;//被拦截器阻断
        }
    }

    /**
     * 相当于aop的后置增强方法
     * @param request
     * @param response
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
/*    return "hello";*/
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
/*执行过滤器 */
    }
}
