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
 * @Date: 2019/6/13 20:12
 * @Describe:
 */
@WebServlet("/addusers")
public class UserAddServlet extends HttpServlet {

    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要添加的用户数据
        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        String nickname = req.getParameter("nickname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        //根据用户数据创建一个用户对象
       Users user = new Users(username, userpass, nickname, Integer.parseInt(age), gender, email, phone, new Date(), new Date(), new Date(), 0);
/*      Users user = new Users();
        user.setName(username);
        user.setUserpass(userpass);
        user.setNickname(nickname);
        user.setAge(Integer.parseInt(age));
        user.setGender(gender);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCreateTime(new Date());
        user.setLastLogin(new Date());
        user.setUpdateTime(new Date());
        user.setRemark("null");
        user.setUserStatus(1);*/
        //将用户对象添加到数据库中
        Users number = usersDAO.addUser(user);
        //查看刚新增的用户数据
        System.out.println("---------------"+number.getId());
        resp.sendRedirect("/detail?id="+number.getId());
    }
}
