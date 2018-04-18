# lookthings

![jdk](https://img.shields.io/badge/JDK-%3E%3D1.8-blue.svg?longCache=true&style=flat-square)
![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?longCache=true&style=flat-square)
![mybatis](https://img.shields.io/badge/mybatis-v3.2.7-yellowgreen.svg?longCache=true&style=flat-square)
![tomcat](https://img.shields.io/badge/tomcat-%3E%3D8-red.svg?longCache=true&style=flat-square)
![spring](https://img.shields.io/badge/spring-v4.0-green.svg?longCache=true&style=flat-square)
![Packagist](https://img.shields.io/packagist/l/doctrine/orm.svg?longCache=true&style=flat-square)

项目名称 LOOKTHINGS，基于 maven 搭建的多模块 SSM 后端平台。

## 特性：

- maven 多模块 SSM 框架
- 用户常用登录设置
- 用户配置节目单信息和影片信息
- 用户 BLOG 功能

## 如何运行

- 环境配置
  - JDK1.8
  - maven >=3.5
  - tomcat 8
  - spring 4.0
  - mybatis 3.2.7
  - alibaba java guideLine plugins
- 开发工具
  - idea

### 结构说明

```html
├── .idea
├── lookthings-core            common，通用模块，用于工具类，枚举类集合
├── lookthings-com.lookthings.users           用户模块
├── lookthings-web             web，与外部接口
|    └── src
|         ├── main
|         ├── java
|         ├── resources    后端所有配置信息文件
|         └── webapp       web交互
├── src
├── CODE_OF_CONDUCT.md        代码行为
├── CONTRIBUTING.md           贡献者规范
├── lookthings.impl
├── LICENSE                   开源声明
├── pom.xml                   maven依赖文件
└── README.md                 说明文件
```

### 文档

- [git提交归档和git分支规范](./CONTRIBUTING.md)
- [行为准则](./CODE_OF_CONDUCT.md)
- [前端页面功能模块](https://github.com/CharlesMaxwellYoung/lookthings/wiki/lookthings-%E4%B8%BB%E8%A6%81%E5%8A%9F%E8%83%BD%E6%A8%A1%E5%9D%97%EF%BC%88%E5%89%8D%E7%AB%AF%E9%A1%B5%E9%9D%A2%EF%BC%89)

### 许可证

[MIT](./LICENSE)
