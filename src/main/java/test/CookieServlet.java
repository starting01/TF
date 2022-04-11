package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author yqf
 * @create 2022-03-31-16:16
 */
@WebServlet(value = "/cs")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器端创建cookie
        Cookie cookie = new Cookie(URLEncoder.encode("姓名","UTF-8"),URLEncoder.encode("张三","UTF-8"));
        //设置cookie的访问路径
        cookie.setPath("/TF_war_exploded/index");
        //设置有效期，>0有效期单位秒；=0表示该cookie失效；<0内存存储，浏览器关闭后消失
        cookie.setMaxAge(60);
        //Cookie响应给客户端
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
