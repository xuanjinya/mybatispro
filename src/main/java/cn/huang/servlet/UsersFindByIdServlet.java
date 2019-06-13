package cn.huang.servlet;

import cn.huang.dao.UsersDAO;
import cn.huang.entity.Users;
import org.apache.log4j.Logger;

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

    /*创建对应的日志对象
    * 通过不同的级别进行日志的记录【DEBUG,WARN,INFO,LOG】
    * */
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);

    private UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        log.info("获取到查询参数ID："+id);
        Users user = usersDAO.findById(Integer.parseInt(id));
        log.info("查询完成，查询的数据为："+user);
        req.setAttribute("user", user);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
