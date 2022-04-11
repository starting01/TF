package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yqf
 * @create 2022-03-30-2:56
 */
@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("提交的数据："+username+","+password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对request请求对象设置统一编码
        req.setCharacterEncoding("utf-8");
        //获取用户发送的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("提交的数据："+username+","+password);

        //响应数据给客户端
        //resp.setCharacterEncoding("utf-8"); //设置服务器端响应的编码格式
        //resp.setHeader("Content-Type","text/html;charset=utf-8");//设置客户端的
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(username+"  登陆成功");
    }
}
