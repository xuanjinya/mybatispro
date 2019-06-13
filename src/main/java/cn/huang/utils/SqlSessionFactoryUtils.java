package cn.huang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 15:51
 * @Describe: 实现SqlSessionFactoryUtils的初始化，获取SqlSessionFactory，以及关闭session的方式
 */
public class SqlSessionFactoryUtils {
    //1.配置文件的路径：resource:mybatis-config.xml
    private static String RESOURCE = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    //将获取到sqlSession存到ThreadLocal中
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /*
     * 创建一个初始化SqlSessionFactory的方法
     * */

    public static void initSqlSessionFactory() {
        try {
            //2.得到配置文件的输入流：Inputstream
            InputStream is = Resources.getResourceAsStream(RESOURCE);
            //初始化sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    //3.获取工厂对象的方法,为了在UsersDao.java中通过factory打开会话：sqlsession
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    //关闭Sqlsession的方法
    public static void close() {
        SqlSession session = threadLocal.get();
        if (session != null) {
            session.close();
            threadLocal.set(null);

        }
    }
}
