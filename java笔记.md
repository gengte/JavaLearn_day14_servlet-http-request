# java笔记

## Servlet [bili](https://www.bilibili.com/video/av66880352/?p=114)

1. [菜鸟](https://www.runoob.com/servlet/servlet-intro.html)
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

## Response

## ServletContext

1. 概念
2. 获取：
    1. 通过request对象 request.getServletContext();
    2. 通过HttpServlet this.getServletContext();
3. 功能
    1. 获取MIME类型
    2. 域对象：共享数据
        * setAttribute(String name, Object value)
        * getAttribute(String name)
        * removeAttribute(String name)
        * 注意：ServletContext对象范围是所有用户所有请求的数据
    3. 获取文件的真实（服务器）路径

## Session

## Cookie 客户端会话

1. 原理：响应头set-cookie和请求头cookie
2. 使用

    ```
        new Cookie(String name, String value)
        response.addCookie(Cookie cookie)
        Cookie[] cookies = request.getCookies()
    ```

## day14_test 登录案例 [bili](https://www.bilibili.com/video/av66880352/?p=138)

1. login.html页面，输入用户名和密码，登录按钮
    * username
    * password
    * form submit button
2. 通过输入的用户名、密码查询数据库
    * **Druid数据库连接池**技术
    * **JdbcTemplate**技术封装JDBC
    * **BeanUtils**使用BeanUtils.populate()方法封装javaBean
3. 查询用户存在，返回User对象，显示successServlet登录成功页面
4. 查询不存在，返回Null，显示failServlet登录失败页面
5. **注意**，模块已删除，其中的文件移动到day14_ser..模块中会产生一系列问题：
    * 包路径问题
    * 使用的库文件夹：
        1. /web/WEB-INF/lib
        2. /libs
    * 检查File/Project Structure配置
    * 检查iml文件中orderEntry节点中库路径问题
    * 修改运行配置项中Tomcat相关设置
    * 改web/login.html中form action路径

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
        1. setProperty(Object bean, String name, Object value)
        2. getProperty(Object bean, String name)
        3. populate(Object bean, Map<String, ? extends Object> properties)

## redis [bili](https://www.bilibili.com/video/av66880352/?p=287)

1. [redis中文网](https://www.redis.net.cn/)
2. Key Value形式存储，Value可存放的数据类型
    * 字符串
    * 哈希
    * 列表
    * 集合
    * 有序集合
3. Jedis
    * Java客户端
    * jedis的jar包
    * 使用：
        1. [server](G:\redis-2.4.5-win64\redis-server.exe)
        2. java code

            ```
               //1.获取连接
               Jedis jedis = new Jedis("localhost", 6379);
               //2. 操作
               jedis.set("username", "zhangsan");
               //3. 关闭连接
               jedis.close();
            ```

    * 方法：
        * 字符串 set get
        * 哈希 hset hget
        * 列表 lpush rpush lpop rpop lrange
        * 集合 sadd smembers
        * 有序集合 zadd zrange
    * Jedis连接
        * JedisPool
        * JedisPoolUtils工具类

