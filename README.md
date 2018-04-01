# Eleven_Platform
[![apistatus](https://img.shields.io/github/license/mashape/apistatus.svg)]() [![Maven metadata URI](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg)]() [![Maven metadata URI](https://img.shields.io/badge/jdk-v1.8-yellowgreen.svg)]()

用来制作视频信息集合平台

本项目采用SSM构建多模块java项目，建议intellij idea工具进行编译,安装[![guidelines](https://img.shields.io/badge/intellij%20plugin-alibaba%20java%20coding%20guidelines-red.svg)]()插件
项目中命名规范参照alibaba coding guideline
### 本项目结构

```html
├── .idea
├── lookthings-core            common，通用模块，用于工具类，枚举类集合
├── lookthings-users           用户模块
├── lookthings-web               web，与外部接口
|    ├── src
|         ├── main
|         ├── java
|         ├── resources    后端所有配置信息文件
|         └── webapp       web交互
├── src
├── CODE_OF_CONDUCT.md        代码行为
├── CONTRIBUTING.md           贡献者规范
├── eleven.impl
├── LICENSE                   开源声明
├── pom.xml                   maven依赖文件
└── README.md                 说明文件
```



### 贡献者规范
[git提交归档和git分支规范](./CONTRIBUTING.md)

### 行为准则

[行为准则](./CODE_OF_CONDUCT.md)

### 开源声明

[MIT](./LICENSE)
