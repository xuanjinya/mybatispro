package cn.huang.servlet;

import cn.huang.dao.UsersDAO;
import cn.huang.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: Yaking
 * @Date: 2019/6/14 14:32
 * @Describe:
 */
@WebServlet("/updateusers")
public class UsersUpdateServlet extends HttpServlet {

    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户更新后的数据
        String id = req.getParameter("id");
        String nickname = req.getParameter("nickname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");
        //创建用户对象
        Users user = new Users(Integer.parseInt(id), nickname, Integer.parseInt(age), gender, phone, email, new Date(), remark);
        //提交更新
        usersDAO.updateUsers(user);
        //查看更新后的用户数据
        resp.sendRedirect("/detail?id=" + user.getId());
    }
}
