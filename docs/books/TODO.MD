### 程序员代码面试指南：IT名企算法与数据结构题目最优解

### gitblit-1.8.0

### Maven项目的SpringMVC静态文件访问
```
	方法1：ContextConfig文件中
	<mvc:resources mapping="/oms/**" location="/oms/" />
	方法2：ContextConfig文件中
	public class WebConfig extends WebMvcConfigurerAdapter {
		public void addResourceHandlers(final ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/demo/**").addResourceLocations("/views/");
		}

	启动问题：	
	tomcat7插件会抱错找不到src\main\webapp。
	但jetty不会抱错，但是而且访问WebContent下面的文件会找不到
	因为maven项目默认目录是src\main\webapp。
	最后maven项目只能把html文件放到src\main\webapp下面。

	Refer
	http://www.baeldung.com/spring-mvc-static-resources
```

### Question about SpringMVC
- How GlobalExceptionHandler works
- How can access a controller, or process?
