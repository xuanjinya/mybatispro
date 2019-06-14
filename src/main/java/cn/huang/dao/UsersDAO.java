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

    private SqlSession getSession() {
        //4.通过factory打开会话：sqlsession
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    //查询数据的方法
    public List<Users> findAll() {
        try {
            list = getSession().selectList("findUser");
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
            user = getSession().selectOne("findUser", new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    /*
     * 添加一个用户到数据库
     * */
    public Users addUser(Users user) {
        try {
            //返回值：是insert执行过程中影响的行数
            getSession().insert("adduser", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return user;
    }

    /*
     * 修改用户资料
     * */
    public Users updateUsers(Users user) {
        try {
            getSession().update("updateUser", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return user;
    }
    public void  delUsers(Integer id) {
        try {
            getSession().delete("delUser", id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
