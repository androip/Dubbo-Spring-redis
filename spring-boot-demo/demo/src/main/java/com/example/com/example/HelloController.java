package com.example.com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.jp.dubbo_Service.service.IProcessData;

//import com.jp.dubbo_Service.service.IProcessData;

@RestController
public class HelloController {
	@Autowired
	IProcessData demoService;
	
	@RequestMapping("/Hello")
	public String Hello() {
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/applicationConsumer.xml");
//		IProcessData demoService = (IProcessData) context.getBean("demoService");
        String hello = demoService.deal("Hello");   
	  
	    System.out.println(Thread.currentThread().getName() + "Sever result:"+hello);  
		System.out.println("Rest 'Hello'");
	    return "This is return by spring-boot,url:/Hello ";
	}
	
	
	
	@RequestMapping("/greeting/{id}")
	public String greeting(@PathVariable String id) {
		String hello = demoService.cacheTest(id); 
	    return "This is return by spring-boot url:/greeting";
	}

	@RequestMapping("/ser/{id}")
	public String ser(@PathVariable Integer id) {
		String hello = demoService.cacheSerilizerTest(id); 
	    return "This is return by spring-boot url:/ser";
	}
	
	@RequestMapping("/user/{id}")
	public String user(@PathVariable Integer id) {
		System.out.println("----Controller----");
		User user = new User("jp",id);
		demoService.cacheSerilizerObj(user); 
	    return "This is return by spring-boot url:/user";
	}
	
	@RequestMapping("/listuser/{id}")
	public String listuser(@PathVariable Integer id) {
		System.out.println("----Controller----");
		List<User> users = new ArrayList<User>();
		User user = new User("jp",id);
		users.add(user);
		demoService.cacheSerilizerListObj(users); 
	    return "This is return by spring-boot url:/userlist";
	}
}
