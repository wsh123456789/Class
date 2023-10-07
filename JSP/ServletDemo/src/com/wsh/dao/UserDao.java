package com.wsh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wsh.bean.User;
import com.wsh.utils.DButil;

public class UserDao {

    public boolean loginByNameAndPwd(String username, String password) {

        boolean flag = false;
        //和数据库创建连接
        Connection conn = DButil.getConn();
        //准备sql语句
        String sql = "select * from user where username = ? and password = ?";
        //预编译
        PreparedStatement st = null;
        //结果集
        ResultSet rs = null;
        //编译  执行sql语句
        try {
            st = conn.prepareStatement(sql);
            //赋值
            st.setString(1,username);
            st.setString(2,password);
            //执行sql语句
            rs = st.executeQuery();
            //处理结果
            while (rs.next()) {
                flag = true;
                break;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //关闭连接
        DButil.close(conn, st, rs);


        return flag;
    }


    // 查询所有用户的信息
    public ArrayList<User> queryUsers() {
        // 创建集合存储数据
        ArrayList<User> userList = new ArrayList<>();


        // 获取连接
        Connection conn = DButil.getConn();

        // 准备sql语句
        String sql = "select * from user where status != 0";

        // 预编译
        PreparedStatement st = null;
        // 结果集
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);

            // 执行sql语句
            rs = st.executeQuery();


            // 处理结果
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setVersion(rs.getInt("version"));
                user.setStatus(rs.getInt("status"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DButil.close(conn,st,rs);

        return userList;
    }

    public int queryTotalNum() {

        // 总条数
        int totalNum = 0;

        // 获取连接
        Connection conn = DButil.getConn();

        // 准备sql语句
        String sql = "select count(id) from user where status != 0";

        // 预编译
        PreparedStatement st = null;
        // 结果集
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);

            // 执行sql语句
            rs = st.executeQuery();

            // 处理结果
            while (rs.next()){
                totalNum = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        DButil.close(conn,st,rs);
        return totalNum;
    }

    // 分页查询
    public List<User> queryUsersPage(int page, int pageCount) {
        // 创建集合存储数据
        ArrayList<User> userList = new ArrayList<>();

        // 获取连接
        Connection conn = DButil.getConn();

        // 准备sql语句
        String sql = "select * from user where status = 1 order by id limit ?,?";

        // 预编译
        PreparedStatement st = null;
        // 结果集
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);

            // 赋值
            st.setInt(1,(page - 1) * pageCount);
            st.setInt(2, pageCount);
            // 执行sql语句
            rs = st.executeQuery();

            // 处理结果
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
                user.setVersion(rs.getInt("version"));
                user.setStatus(rs.getInt("status"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DButil.close(conn,st,rs);

        return userList;
    }

    public boolean addUsers(User user) {

        boolean flag = false;

        // 获取数据库连接
        Connection conn = DButil.getConn();

        String sql = "insert into user (username,password,age,sex,version,status) values(?,?,?,?,?,?)";

        // 预编译
        PreparedStatement st = null;

        // 结果集
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);

            // 执行sql语句
            st.setString(1,user.getUsername());
            st.setString(2,user.getPassword());
            st.setInt(3,user.getAge());
            st.setString(4,user.getSex());
            st.setInt(5, 100);
            st.setInt(6,1);
            st.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButil.close(conn,st, null);

        return flag;
    }

    // 物理删除
    /*public boolean deleteUsers(Integer id) {

        boolean flag = false;

        // 获取数据库连接
        Connection conn = DButil.getConn();

        String sql = "delete from user where id = ?";

        // 预编译
        PreparedStatement st = null;

        // 结果集
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);

            // 执行sql语句
            st.setInt(1,id);
            st.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButil.close(conn,st, null);

        return flag;
    }*/

    // 逻辑删除
    public boolean deleteUsers(Integer id) {

        boolean flag = false;

        // 获取数据库连接
        Connection conn = DButil.getConn();

        String sql = "update user set status = 0 where id = ?";

        // 预编译
        PreparedStatement st = null;

        // 结果集
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);

            // 执行sql语句
            st.setInt(1,id);
            st.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DButil.close(conn,st, null);

        return flag;
    }

    public Integer updateUsers(User user) {

        Integer line = 0;
        Connection conn = DButil.getConn();

        String sql = "update user set username = ?, password = ?,age = ?, sex = ?  where id = ?";

        PreparedStatement st = null;

        ResultSet rs = null;

        try {
            st = conn.prepareStatement(sql);
            st.setString(1,user.getUsername());
            st.setString(2,user.getPassword());
            st.setInt(3,user.getAge());
            st.setString(4,user.getSex());
            st.setInt(5,user.getId());
            line = st.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        DButil.close(conn,st, null);
        return line;

    }

    public User getUserById(Integer id) {

        User user = new User();
        Connection conn = DButil.getConn();

        // 准备sql语句
        String sql = "select * from user where id = ?";

        // 预编译
        PreparedStatement st = null;

        // 结果集
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setSex(rs.getString("sex"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean getUserByIdAndName(Integer id, String username) {
        boolean flag = false;
        //和数据库创建连接
        Connection conn = DButil.getConn();
        //准备sql语句
        String sql = "select * from user where  and id != ? and username = ?";
        //预编译
        PreparedStatement st = null;
        //结果集
        ResultSet rs = null;
        //编译  执行sql语句
        try {
            st = conn.prepareStatement(sql);
            //赋值
            st.setInt(1,id);
            st.setString(2,username);
            //执行sql语句
            rs = st.executeQuery();
            //处理结果
            while (rs.next()) {
                flag = true;
                break;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        //关闭连接
        DButil.close(conn, st, rs);


        return flag;
    }
}
