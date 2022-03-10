package edu.soft2.controller;

import edu.soft2.controller.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("param1")
public class MyController {
    @RequestMapping("testMaV")
    public ModelAndView testMaV(){
        System.out.println("MyController.testMaV");
        User user=new User();//USer对象创建
        user.setUsername("peter");
        ModelAndView MaV=new ModelAndView();//ModelAndVieW对象实例化
        MaV.addObject("user",user);
         MaV.setViewName("hello");//相当于跳转的url(前缀+hello+后缀)
        return MaV;
    }
@RequestMapping("testForward")
    public String testForward(){//转发
    System.out.println("----testForward----");
//    return "forward:/WEB-INF/pages/hello.jsp"  要么不加后缀和前缀，要么就都加，加的话不能缺少一个
        return "forward:hello";//转发到webapp下的hello
    }
    @RequestMapping("testRedirect")
      public String testRedirect(){//重定向
    System.out.println("----testRedirect---");
        //   return "redirect:/WEB-INF/pages/hello";这种会失败，因为客户端不能直接访问WEB-INF下的文件
        return "redirect:/hello";//重定向到webapp下的hello
}




    @RequestMapping(value = "/hello.do",method = {RequestMethod.GET})
    public String hello(HttpServletRequest request) {
        System.out.println("-----hello()-----");
        //接收处理，调用业务，跳转页面
        String name = request.getParameter("name");
        System.out.println("name=" + name);
        return "hello";//拼接：前缀+hello+后缀
    }
    @RequestMapping(value = "/param1",method = {RequestMethod.GET,RequestMethod.POST})
    @GetMapping(value = "/param1")
    public String param1(HttpServletRequest request){
        System.out.println("-----param1()-----");
        //接收处理，调用业务，跳转页面
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username="+username+",age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);
        return "hello";//跳转到视图：WEB-INF/pages/hello.jsp
        //默认重定向方式  Url地址会变
    }
    @RequestMapping(value = "/param2")  /*重定向或转发*/
    public String param2(HttpServletRequest request){
        System.out.println("-----param2()-----");
        //接收处理，调用业务，跳转页面
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("username="+username+",age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);
        return "forward:hello";//拼接：前缀+hello+后缀forward(转发) redirect(重定向)  跳转到视图：WEB-INF/pages/hello.jsp
        //默认重定向方式  Url地址会变
    }
    @RequestMapping(value = "/param3")  /*session方式*/
    public String param3(HttpServletRequest request, HttpSession session){
        System.out.println("-----param3()-----");
        //接收处理，调用业务，跳转页面
        String username = request.getParameter("username");
        String age = request.getParameter("age");//通过参数值(url) ,获取参数值
        System.out.println("username="+username+",age="+age);
        session.setAttribute("username",username);//将数据放入session
        session.setAttribute("age",age);
        return "hello";//跳转到视图：WEB-INF/pages/hello.jsp
        //默认重定向方式  Url地址会变
    }
    @RequestMapping(value = "/param4")
    public String param4(String username,int age){
        System.out.println("-----param4()-----");
        System.out.println("username="+username+",age="+age);
        return "hello";//拼接：前缀+hello+后缀forward redirect
        //默认重定向方式  Url地址会变
    }
    @RequestMapping(value = "/param5")
    public String param5(@RequestParam(value = "username",required = false) String u,@RequestParam(value = "age",required = true,defaultValue = "30") int a){
        //required的true代表必填(不填会报错)false代表不用填   defaultValue(缺损值)后面加上这个，就算不填也会默认填写(但required要为true)
        System.out.println("-----param5()-----");
        System.out.println("username="+u+",age="+a);
        return "hello";//拼接：前缀+hello+后缀forward redirect
        //默认重定向方式  Url地址会变
    }
    @RequestMapping(value = "/test1")
    public String test1() {
        System.out.println("-----test1()-----");
        return "forward:param1/test2";//跳转到控制器test2.do
    }
    @RequestMapping(value = "/test2")
    public String test2() {
        System.out.println("-----test2()-----");
        return "hello";//跳转到视图：WEB-INF/pages/hello.jsp
    }
}
