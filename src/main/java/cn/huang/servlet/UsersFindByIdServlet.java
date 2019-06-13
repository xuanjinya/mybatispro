package cn.huang.servlet;

import cn.huang.dao.UsersDAO;
import cn.huang.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 19:35
 * @Describe: 通过id实现查询单个用户功能
 */
@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {

    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Users user = usersDAO.findById(Integer.parseInt(id));
        req.setAttribute("user", user);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
