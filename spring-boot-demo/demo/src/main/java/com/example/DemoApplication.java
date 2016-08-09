package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ComponentScan//组件扫描   
//@Configuration//配置控制   
//@EnableAutoConfiguration//启用自动配置   
@ImportResource({"classpath:applicationConsumer.xml"}) //加入spring的bean的xml文件 	
@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Spring Boot Started!");
	}
}
