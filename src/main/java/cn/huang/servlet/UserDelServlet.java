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
 * @Date: 2019/6/14 15:57
 * @Describe:
 */
@WebServlet("/deluser")
public class UserDelServlet extends HttpServlet {
    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取参数
        String id = req.getParameter("id");
        String type = req.getParameter("type");
        //执行删除或则锁定
        if ("lock".equals(type)) {
            //指定锁定操作，update操作
            Users user = new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(1);

            usersDAO.updateUsers(user);
        } else if("del".equals(type)){
            //执行删除操作
            usersDAO.delUsers(Integer.parseInt(id));
        }else {
            Users user = new Users();
            user.setId(Integer.parseInt(id));
            user.setUserStatus(0);
            usersDAO.updateUsers(user);
        }
        //跳转到首页
        resp.sendRedirect("/index");
    }


}



