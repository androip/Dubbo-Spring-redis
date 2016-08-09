package com.jp.dubbo_Service.service;

import java.util.List;

import com.entity.User;

public interface IProcessData {  
    public String deal(String data);  
    public String cacheTest(String key);
    public String cacheSerilizerTest(Integer key);
    public User cacheSerilizerObj(User key);
	List<User> cacheSerilizerListObj(List<User> users);
} 