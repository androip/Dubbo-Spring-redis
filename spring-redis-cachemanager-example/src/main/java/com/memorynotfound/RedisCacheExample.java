package com.memorynotfound;

import java.io.IOException;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@ImportResource({"classpath:applicationConsumer.xml"})
@EnableCaching
public class RedisCacheExample {
    public static void main(String[] args) throws IOException {
    	ApplicationContext cxt = new ClassPathXmlApplicationContext(new String[]{"applicationProvider.xml"});
    	
//    	MusicService musicService = cxt.getBean(MusicService.class);
//      System.out.println("message: " + musicService.play("trumpet"));
//      System.out.println("message: " + musicService.play("trumpet"));
//      System.out.println("message: " + musicService.play("guitar"));
//      System.out.println("message: " + musicService.play("guitar"));
        System.out.println("Done.");
        System.in.read(); 
    }

}
