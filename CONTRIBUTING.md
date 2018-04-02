# 贡献于EVELEN
我们希望您能够lookthings做出贡献，并帮助它们共同进步！

[TOC]

## 分支建立原则

### 主分支 `master`

- master 为主分支，要保护它的稳定性，随时可用来上线。
- 我们不应该直接在 master 分支上直接提交代码，而是从其它分支的合并。

### 开发分支 develop

- develop 为开发分支，一般包含正在开发的所有新特性，用于测试环境部署和测试。
- 我们不应该直接在 develop 分支上直接提交代码，也不应该把未经测试的代码合并进来，应该尽量保持测试环境干净可用。
- 当 develop 太“脏”以至于不能继续测试之后，可以考虑重新从 master 拉取一次。

### 特性分支 feature

- _分支命名_: feature/ 开头的为特性分支，命名规则为 feature/some_amazing_funs-yourname-date。举例来讲，如天宇10月18日要开发一个通讯录改进的功能，可以自建分支为 feature/contacts_advance-ty-1018。
- 一般 feature 分支应仅包含一个特性，上线（合并至 master）部署验证无误后即可删除。记得及时将 feature 分支 push 至远端。
- 如果合并至 develop 或 master 时发现在 fork 此特性分支之后分支已合并了很多其它分支的提交，请先执行 git rebase，这样能提交历史更加整洁。

### 预上线分支 release
- _分支命名_: release/ 开头的为预发布分支，命名规则为 release/date。举例来讲，如果10月18日要准备封一个预上线分支，则命名为 release/1018。
- 上线后即可删除。

### 快速修复分支 hotfix
- _分支命名_: hotfix/ 开头的为修复分支，它的命名规则与 feature 分支类似。
- 一般我们如果发现紧急线上 bug，可以将线上代码临时回滚，从最新的 master 分支建立 hotfix 分支，提交修复代码、测试无误后，合并至 develop 和 master。
- 上线验证无误后，即可将 hotfix 分支删除。

## 提交规则

本文参照[阮一峰的网络日志](http://www.ruanyifeng.com/blog/2016/01/commit_message_change_log.html)

### 1.Commit message 的作用

- **提供更多的历史信息，方便快速浏览。**
- **可以过滤某些commit（比如文档改动），便于快速查找信息。**
- **可以直接从commit生成Change log。**

### 2.Commit message 的格式

> 每次提交，Commit message 都包括三个部分：Header，Body 和 Footer。

```javascript
<type>(<scope>): <subject>
// 空一行
<body>
// 空一行
<footer>
```

- Header

  Header部分只有一行，包括三个字段：`type`（必需）、`scope`（可选）和`subject`（必需）。

  - **type**

    > 用于说明 commit 的类别，只允许使用下面7个标识。
    ```html
    feat：新功能（feature）
    fix：修补bug
    docs：文档（documentation）
    style： 格式（不影响代码运行的变动）
    refactor：重构（即不是新增功能，也不是修改bug的代码变动）
    test：增加测试
    chore：构建过程或辅助工具的变动
    ```
    > 或者采用emoji表情来标识提交类型

    `feat`----->:sparkles:`星星代码（:sparkles:）`

    `fix`------>:bug:`bug代码（:bug:）`

    `docs`------>:memo:`memo代码（:memo:）`

    `style`------>:art:`art代码（:art:）`

    `refactor`------>:hammer:`hammer代码（:hammer:）`

    `test`------>:white_check_mark:`white_check_mark代码（:white_check_mark:）`

    `chore`------>:green_heart:`green_heart代码（:green_heart:）`
    ​
    更多的表情提交规范可以参照：[emoji 表情指南](http://www.techug.com/post/github-emoji-usage-tips.html)
  - scope**

    > 用于说明 commit 影响的范围，比如数据层、控制层、视图层等等，视项目不同而不同。

  - **subject**

    > 是 commit 目的的简短描述，不超过50个字符。

    ```
    以动词开头，使用第一人称现在时，比如change，而不是changed或changes
    第一个字母小写
    结尾不加句号（.）
    ```

- Body

  Body 部分是对本次 commit 的详细描述，可以分成多行。下面是一个范例。

  ```javascript

  More detailed explanatory text, if necessary.  Wrap it to 
  about 72 characters or so. 

  Further paragraphs come after blank lines.

  - Bullet points are okay, too
  - Use a hanging indent
  ```

  ​

- Footer 

  Footer 部分只用于两种情况

  - **不兼容变动**

    如果当前代码与上一个版本不兼容，则 Footer 部分以`BREAKING CHANGE`开头，后面是对变动的描述、以及变动理由和迁移方法,例如

    ```javascript
    BREAKING CHANGE: isolate scope bindings definition has changed.

        To migrate the code follow the example below:

        Before:

        scope: {
          myAttr: 'attribute',
        }

        After:

        scope: {
          myAttr: '@',
        }

        The removed `inject` wasn't generaly useful for directives so there should be no code using it.
    ```

    ​

  - **关闭 Issue**

    如果当前 commit 针对某个issue，那么可以在 Footer 部分关闭这个 issue 。

    ```
    Closes #234
    ```

    or

    ```
    Closes #123, #245, #992
    ```

    ​
