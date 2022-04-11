package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-03-31-21:48
 */
@WebServlet(value = "/ss")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过request对象获取Session对象
        HttpSession session = req.getSession();
        session.setAttribute("name","张三");
        req.setAttribute("password","123456");
        resp.sendRedirect("/TF_war_exploded/index");
        System.out.println(session.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
