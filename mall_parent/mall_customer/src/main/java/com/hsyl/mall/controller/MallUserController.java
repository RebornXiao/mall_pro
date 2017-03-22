package com.hsyl.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hsyl.mall.inter.MallUserService;

@Controller
@RequestMapping(value="user")
public class MallUserController {
	
	@Autowired
	private MallUserService service;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public String userLogin(@RequestBody String req){
		JSONObject resultJson = new JSONObject();
		JSONObject setJson = JSONObject.parseObject(req);
		System.out.println("登录入参："+setJson.toString());
		try {
			resultJson=service.userLogin(setJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("登录出参："+resultJson.toString());
		return resultJson.toString();
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	@ResponseBody
	public String userRegister(@RequestBody String req){
		JSONObject resultJson = new JSONObject();
		JSONObject setJson = JSONObject.parseObject(req);
		System.out.println("注册入参："+setJson.toString());
		try {
			resultJson=service.userRegister(setJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("注册出参："+resultJson.toString());
		return resultJson.toString();
	}

}
