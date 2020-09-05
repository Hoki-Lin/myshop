# myshop
> 项目采用分布式架构,将一个非常大的项目拆分成n个子模块,子模块通讯使用RPC进行远程调用。

## 项目目录结构

```
hoki-shop-parent
|---->hoki-shop-api		项目定义接口
|---->hoki-shop-common		项目公共工具
|---->hoki-shop-eurekaserver	注册中心
|---->hoki-shop-member		会员服务模块
|---->log			日志输出位置
|---->pom.xml			parent依赖文件
|---->README.md			项目说明
```

## 项目使用技术
1. 使用 SpringCloud Eureka作为注册中心、
2. Feign客户端调用工具、
3. 断路器Hystrix
4. 视图展示使用Freemarker、
5. 数据库层使用Mybatis框架、
6. 缓存使用Redis、
7. 数据库使用MySQL
8. 项目管理工具使用Maven、
9. 版本控制工具使用SVN、
10. 项目自动部署工具使用Jenkins
11. 消息中间件使用ActiveMQ、
12. 分布式任务调度系统使用XXLJOB、
13. 反向代理工具使用Nginx
14. 日志管理插件工具使用lombok、
15. 分布式日志收集使用Logstash、
16. 解析JSON框架使用FastJson
17. 数据安全加密使用MD5加盐和Base64、RSA、
18. 分布式文件存储系统FastDFS等。
19. 支付网关接口使用银联支付、第三方登录使用QQ授权等。

## 项目开发进度
1. 创建parent项目和会员服务项目,搭建eureka注册中心;
2. 对Redis的相关操作进行封装;
3. 使用Lombok插件简化开发, 并添加Log日志,通过AOP方式设置切入点进行日志信息打印;
4. 对mybatis的相关操作进行封装;
5. 完成会员模块中的注册服务,期间解决了jar冲突以及数据库驱动与本地数据库版本不一致的bug;
6. 对密码进行MD5加密,同时对密码进行加盐加密;
7. 
