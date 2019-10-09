package com.g.domain;

public class User {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //演示BeanUtils.setProperty()方法，BeanUtils.getProperty()方法
    //在BeanUtilsTest类中进行测试
    public void setLalala(String name) {
        this.username = name;
    }

    public String getLalala() {
        return this.username;
    }
}
