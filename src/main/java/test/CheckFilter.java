package test;

import servletProject.entity.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-04-02-0:00
 */
@WebFilter(value = "/showAll")
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        Admin msg = (Admin) session.getAttribute("msg");
        if(msg != null){
            session.setAttribute("msg",msg);
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect(request.getContextPath()+"/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
