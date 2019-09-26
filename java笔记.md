# java笔记

## Servlet

1. 概念
2. 步骤
3. 执行原理
4. 生命周期
    1. 初始化
    2. 提供服务 service()
    3. 销毁 destroy()
5. Servlet3.0注解配置
    无需创建web.xml
6. Servlet体系结构
    Servlet接口-GenericServlet抽象类-HttpServlet抽象类
    * GenericServlet:实现Servlet接口，只将service()方法作为抽象
        * 定义类继承GenericServlet类，重写service()方法即可
    * HttpServlet:对http协议进行封装，简化操作
        * 定义类继承HttpServlet类，重写doGet()或者doPost()方法
7. Servlet相关配置
    1. urlpartten:Servlet访问路径
        1. 可定义多个@WebServlet("/demo3","/demo33")
        2. 定义规则：
            1. /xxx
            2. /xxx/xx:多层
            3. /*
            4. /xxx/*
            5. *.do

## HTTP

## Request

1. 获取请求行数据
    * 获取请求方式
    * 获取虚拟目录
    * 获取Servlet路径
    * 获取请求参数
    * 获取请求URI
    * 获取请求URL
    * 获取协议及版本
    * 获取客户机IP
2. 获取请求头数据
    * getHeader()
3. 获取请求体数据

## day14_test 登录案例

1. login.html页面，输入用户名和密码，登录按钮
    * username
    * password
    * form submit button
2. 通过输入的用户名、密码查询数据库
    * Druid数据库连接池技术
    * JdbcTemplate技术封装JDBC
    * 使用BeanUtils.populate()方法封装javaBean
3. 查询用户存在，返回User对象，显示successServlet登录成功页面
4. 查询不存在，返回Null，显示failServlet登录失败页面

## JavaBean

1. 使用BeanUtils工具类简化数据封装
    1. JavaBean:标准的Java类
        1. 要求：
            1. public class
            2. 空参构造器
            3. private 成员变量
            4. public setter和getter方法
        2. 功能：封装数据
    2. 概念：
        成员变量；
        属性；
        getUsername() --> Username --> username
    3. 方法：
        1. setProperty()
        2. getProperty()
        3. populate()
