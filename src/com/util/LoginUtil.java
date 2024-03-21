package com.util;

import java.util.HashMap;
import java.util.Map;

public class LoginUtil {

static Map<String,String> map=new HashMap<>();
	
	public static Map<String,String> data()
	{
		map.put("admin", "admin@123");
		return map;
	}
	
	
	public static boolean verifyUsername(String userName) {
		Map<String,String> map=data();
		for(String key:map.keySet())
		{
			if(key.equals(userName))
			{
				return true;
			}
		}
		return false;
	}


	public static boolean login(String userName, String password) {
		Map<String,String> map=data();
		
		String sysPass=map.get(userName);
		if(sysPass.equals(password))
		{
			return true;
		}
		return false;
	}

}
