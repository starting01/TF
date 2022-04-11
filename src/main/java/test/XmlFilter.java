package test;


import javax.servlet.*;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-04-01-20:50
 */
public class XmlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("web.xml文件配置");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--end--");
    }

    @Override
    public void destroy() {

    }
}
