package com.wsh.bean;

// 实体类
public class User {

    // 用户id
    private Integer id;

    // 用户名
    private  String username;

    // 用户密码
    private  String password;

    // 用户年龄
    private Integer age;

    // 用户性别
    private String sex;

    // 用户版本
    private Integer version;

    // 用户信息状态
    private  Integer status;

    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String sex, Integer version, Integer status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.version = version;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", version='" + version + '\'' +
                ", status=" + status +
                '}';
    }
}
