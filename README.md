# java-project-template
Java项目配置模板

## 版本说明
### V1
1. 添加pmd代码审查与spring-javaformat格式化插件
2. 添加git hook插件,将上面两个命令放在pre-commit hook执行
3. 复制alibaba p3c规则文件, 添加了几个 language="java" 属性, 兼容PMD 7

## IDEA设置
在`Editor - File and Code Templates - Includes - File Header` 配置以下class注释模板:
```java
/**
 * v1.0 fix me
 * 
 * @author ${USER}
 * @version 1.0
 * @since ${DATE} 
 */
```