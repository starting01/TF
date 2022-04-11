package test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-04-01-20:42
 */
@WebFilter(value = "/servlet")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--MyFilter--");
        //将请求继续
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--END--");
    }

    @Override
    public void destroy() {

    }
}
