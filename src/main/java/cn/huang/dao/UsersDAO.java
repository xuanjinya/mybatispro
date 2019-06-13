package cn.huang.dao;

import cn.huang.entity.Users;
import cn.huang.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 16:32
 * @Describe: 执行
 */
public class UsersDAO {
    private SqlSession sqlSession;
    private List<Users> list;
    private Users user;

    private SqlSession getSqlSession() {
        //4.通过factory打开会话：sqlsession
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    //查询数据的方法
    public List<Users> findAll() {
        try {
            list = getSqlSession().selectList("findUser");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    //查询单个用户，根据ID
    public Users findById(Integer id) {
        try {
            user = getSqlSession().selectOne("findUser", new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }

}
