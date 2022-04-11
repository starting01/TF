package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-04-01-19:53
 */
@WebServlet(value = "/servletContext")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.使用this.getServletContext
        ServletContext servletContext = this.getServletContext();
        //2.使用request.getServletContext
        ServletContext servletContext1 = req.getServletContext();
        //3.使用session.getServletContext
        ServletContext servletContext2 = req.getSession().getServletContext();
        servletContext.setAttribute("name","yqf");
        System.out.println("this.getServletContext："+servletContext);
        System.out.println("request.getServletContext："+servletContext1);
        System.out.println("session.getServletContext："+servletContext2);
        System.out.println("真实路径："+servletContext.getRealPath("/"));
        System.out.println("上下文路径："+servletContext.getContextPath());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
