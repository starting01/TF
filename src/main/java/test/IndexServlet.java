package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author yqf
 * @create 2022-03-30-2:10
 */
//value = {"/index2","/index"} value和urlPatterns作用相同，但不可同时使用,servlet3.0以上可以使用注解
@WebServlet(urlPatterns = {"/index2","/index"},loadOnStartup = 0)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies =  req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                System.out.println(URLDecoder.decode(cookie.getName(),"UTF-8")+":"+URLDecoder.decode(cookie.getValue(),"UTF-8"));
            }
        }
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        String pwd = (String) req.getAttribute("password");
        String name2 = (String) this.getServletContext().getAttribute("name");
        System.out.println(name+":"+pwd);
        System.out.println("name2：" + name2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
