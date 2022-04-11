package servletProject.servlet;

import com.mysql.cj.xdevapi.Session;
import servletProject.entity.Admin;
import servletProject.service.AdminService;
import servletProject.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yqf
 * @create 2022-03-30-23:42
 */
@WebServlet(value = "/login" )
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //1.收参
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用业务逻辑层
        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.login(username,password);
        //3.处理结果
        //PrintWriter printWriter = resp.getWriter();
        if(admin != null){
            HttpSession session = req.getSession();
            session.setAttribute("msg",admin);
            resp.sendRedirect("/TF_war_exploded/showAll");
        }else{
           resp.sendRedirect("/TF_war_exploded/login.html");
        }
    }
}
