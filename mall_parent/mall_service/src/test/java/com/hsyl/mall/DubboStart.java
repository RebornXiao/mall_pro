package com.hsyl.mall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.hsyl.mall.inter.MallUserService;

public class DubboStart {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath*:spring-mybatis-dubbo.xml"});
		context.start();

		MallUserService bean = (MallUserService) context.getBean("mallUserService");
		JSONObject json =  new JSONObject();
		json.put("userAccount", "12345@qq.com");
		json.put("password", "2344");
		json.put("userName", "张三");
		json.put("accountType", 0);
//		JSONObject resultJson = bean.userRegister(json);
		
		
		JSONObject resultJson = bean.userLogin(json);
		System.out.println("*********IN:"+resultJson.toString());
		
		while(true){
			Thread.sleep(1234567890);
		}

	}
}
