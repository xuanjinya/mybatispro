package cn.huang.listener;

import cn.huang.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 16:13
 * @Describe: 初始化SqlSession的监听器
 */
@WebListener
public class InitSqlSessionListener implements ServletContextListener {
    //容器初始化的方法
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("to start...");
        //初始化我们的SqlSessionFactory对象
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }

    //容器销毁的方法
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("to end...");
        //关闭SqlSession对象
        SqlSessionFactoryUtils.close();
    }
}
