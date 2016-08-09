package com.jp.dubbo_Service.service.impl;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.jp.dubbo_Service.service.IProcessData;


@Service
public class ProcessDataImpl implements IProcessData {
 
//	@SuppressWarnings("rawtypes")
//	@Autowired
//	private RedisTemplate redisTemplate;
	
    public String deal(String data) {  
        System.out.println("-----This is dubbo service ["+data+"]-----");
        return "Finished:" + data;  
    } 
  
    @Cacheable(value="TestCache",key="#root.args[0]")
    public String cacheTest(String key){
    	System.out.println("-----This is dubbo service :cacheTest ["+key+"]-----");
//    	System.out.println(redisTemplate);
//    	@SuppressWarnings("unchecked")
//		ValueOperations<Integer, String> valueops = redisTemplate.opsForValue();
//    	String val = key+"_val";
//		valueops.set(key, val);
    	return key.toString();
    }
    
    @Cacheable(value="TestCache",key="'Test_'.concat(#root.args[0])")
    public String cacheSerilizerTest(Integer key){
    	System.out.println("-----This is dubbo service :cacheTest ["+key+"]-----");
//    	System.out.println(redisTemplate);
//    	@SuppressWarnings("unchecked")
//		ValueOperations<Integer, String> valueops = redisTemplate.opsForValue();
//    	String val = key+"_val";
//		valueops.set(key, val);
    	return key.toString();
    }

	@Override
	@CachePut(value = "User", key = "'user.'.concat(#result.getId())")
	public User cacheSerilizerObj(User user) {
		System.out.println("=========This is dubbo service :userTest:"+ user.getName());
		return user;
	}

	@Override
	@CachePut(value = "User", key = "'userlist.'.concat(#result.get(0).getId())")
	public List<User> cacheSerilizerListObj(List<User> users) {
		// TODO Auto-generated method stub
		System.out.println("=========This is dubbo service :userTest:"+ users.get(0).getName());
		return users;
		
	}
 
    
}  