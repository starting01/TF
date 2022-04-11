package servletProject.servlet;

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
import java.io.PrintWriter;
import java.util.List;

/**
 * @author yqf
 * @create 2022-03-31-12:33
 */
@WebServlet(value = "/showAll")
public class ShowAllAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        //Admin adm = (Admin) session.getAttribute("msg");
        //if(adm != null ){
            List<Admin> admins = new AdminServiceImpl().showAllAdmin();
            //处理结果
            PrintWriter printWriter = resp.getWriter();
            if(admins != null){
                printWriter.println("<html>");
                printWriter.println("<head>");
                printWriter.println("<meta charset='utf-8'>");
                printWriter.println("<title>全部用户</title>");
                printWriter.println("</head>");
                printWriter.println("<body>");
                printWriter.println("<table>");
                printWriter.println("<tr><td>用户名</td><td>邮箱</td></tr>");
                for(Admin admin : admins){
                    printWriter.println("<tr><td>"+admin.getUsername()+"</td><td>"+admin.getEmail()+"</td></tr>");
                }
                printWriter.println("</table>");
                printWriter.println("</body>");
                printWriter.println("</html>");
            }
        //}else{
          //  resp.sendRedirect("/TF_war_exploded/login.html");
        //}

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
