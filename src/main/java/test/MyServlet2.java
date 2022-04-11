package test;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-03-30-20:12
 */
public class MyServlet2 extends GenericServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("GenericServlet init.....");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet......");
    }
}
