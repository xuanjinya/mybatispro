package cn.huang.servlet;

import cn.huang.dao.UsersDAO;
import cn.huang.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 16:40
 * @Describe: 用于调用DAO中的数据
 */
@WebServlet("/index")
public class UsersFindServlet extends HttpServlet {

    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> list = usersDAO.findAll();
        System.out.println(list);
        for (Users users : list) {
            System.out.println(users);
        }

        req.setAttribute("usersList", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
