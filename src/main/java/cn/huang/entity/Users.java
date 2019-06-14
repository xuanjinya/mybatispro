package cn.huang.entity;

import java.util.Date;

/**
 * @Author: Yaking
 * @Date: 2019/6/12 15:35
 * @Describe: 用户的实体类
 */

/*
 * mybatis-config.xml如果需要能正常工作，需要以下几个步骤：
 * 1.配置文件的路径：resource:mybatis-config.xml
 * 2.得到配置文件的输入流：Inputstream
 * 3.构建一个工厂：sqlSessionFactory
 * 4.通过factory打开会话：sqlsession
 * 5.执行配置好的sql语句。
 * */
public class Users {
    private Integer id; //账户Id
    /*  private String username; //账户名*/
    private String name; //账户名
    private String userpass;//密码
    private String nickname;//昵称
    private Integer age;//年龄
    private String gender;//性别
    private String phone;//电话
    private String email;//邮箱
    private Date createTime;//创建时间
    private Date updateTime; //账户最后修改时间
    private Date lastLogin; //用户的最后登陆时间
    private Integer userStatus; //用户的账号状态，0：正常 1：锁定 2：删除
    private String remark; //用户的备注信息

    public Users() {
    }

    public Users(Integer id, String name, String userpass, String nickname, Integer age, String gender, String phone, String email, Date createTime, Date updateTime, Date lastLogin, Integer userStatus, String remark) {
        this.id = id;
//        this.username = username;
        this.name = name;
        this.userpass = userpass;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLogin = lastLogin;
        this.userStatus = userStatus;
        this.remark = remark;
    }

    public Users(String name, String userpass, String nickname, Integer age, String gender, String email, String phone, Date createTime, Date updateTime, Date lastLogin, Integer userStatus) {
        this.name = name;
        this.userpass = userpass;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.lastLogin = lastLogin;
        this.userStatus = userStatus;
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

/*    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
