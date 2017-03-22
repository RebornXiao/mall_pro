/**
 * 
 */
package com.hsyl.mall.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hsyl.mall.dao.MallUserMapper;
import com.hsyl.mall.inter.MallUserService;
import com.hsyl.mall.pojo.MallUser;
import com.hsyl.mall.util.EncryptTool;
import com.hsyl.mall.util.GenerateUId;

/**
 * @author yhyi
 *
 */
@Service("mallUserService")
public class MallUserServiceImpl implements MallUserService {

	@Autowired
	private MallUserMapper mapper;

	/**
	 * 用户注册
	 * 
	 */
	public JSONObject userRegister(JSONObject json) throws Exception {
		JSONObject resultJson = new JSONObject();

		if (!json.containsKey("userAccount")) {
			resultJson.put("msg", "缺少参数用户账号");
			resultJson.put("status", 0);
			return resultJson;
		}
		if (!json.containsKey("password")) {
			resultJson.put("msg", "缺少参数用户密码");
			resultJson.put("status", 0);
			return resultJson;
		}
		if (!json.containsKey("accountType")) {
			resultJson.put("msg", "缺少参数账号类型");
			resultJson.put("status", 0);
			return resultJson;
		}
		String userAccount = json.getString("userAccount");
		String userPassword = json.getString("password");
		Integer type = json.getInteger("accountType");

		int account = mapper.selectUserAccount(userAccount); // 查询该用户是否存在在数据库中
		if (account > 0) {
			resultJson.put("msg", "该账号已经被注册");
			resultJson.put("status", 2);
			return resultJson;
		} else {
			MallUser user = new MallUser();
			user.setUserId(GenerateUId.generateShortUuid());
			if (json.containsKey("userName")) {
				user.setUserName(json.getString("userName"));
			}
			if (json.containsKey("nickName")) {
				user.setNickName(json.getString("nickName"));
			}
			user.setCteateDate(new Date()); // 创建时间
			user.setUserPasswoed(EncryptTool.md5Base64Url(userPassword));
			user.setUserPhoto("http://");
			user.setUserLeve(1); // 用户级别为1级
			if (json.containsKey("userPhone")) {
				user.setUserPhone(json.getString("userPhone"));
			}
			user.setUserAccount(userAccount);
			user.setAccountType(type);
			mapper.insert(user); // 将用户的信息添加到数据库中
			resultJson.put("msg", "用户信息注册成功!");
			resultJson.put("status", 1);
		}
		return resultJson;
	}

	/**
	 * 
	 * 用户登录
	 */
	public JSONObject userLogin(JSONObject json) throws Exception {
		JSONObject resultJson = new JSONObject();
		if (!json.containsKey("userAccount")) {
			resultJson.put("msg", "缺少参数用户账号");
			resultJson.put("status", 0);
			return resultJson;
		}
		// 1.先判断该用户是否在数据库中存在
		String userAccount = json.getString("userAccount");
		int account = mapper.selectUserAccount(userAccount); // 查询该用户是否存在在数据库中
		if (account > 0) {
			// 2.当用户的信息存在数据库中的时候
			String password = EncryptTool.md5Base64Url(json.getString("password"));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userAccount", userAccount);
			map.put("userPasswoed", password);
			int result = mapper.selectUserIsExist(map);
			if (result > 0) {
				resultJson.put("msg", "用户登录成功!");
				resultJson.put("status", 1);
				return resultJson;
			} else {
				resultJson.put("msg", "用户密码错误!");
				resultJson.put("status", 2);
				return resultJson;
			}
		} else {
			resultJson.put("msg", "请先注册再登录!");
			resultJson.put("status", 3);
			return resultJson;
		}
	}

	/**
	 * 检测用户是否在数据库
	 */
	public JSONObject checkUserExist(JSONObject json) throws Exception {
		JSONObject resultJson = new JSONObject();
		String userAccount = json.getString("userAccount");
		int account = mapper.selectUserAccount(userAccount); // 查询该用户是否存在在数据库中
		if (account > 0) {
			resultJson.put("msg", "该账号已被注册!");
			resultJson.put("status", 1);
			return resultJson;
		}
		resultJson.put("msg", "该账号还没有被注册!");
		resultJson.put("status", 2);
		return resultJson;
	}

	/**
	 * 修改用的基础信息
	 */
	public JSONObject changeUserInfo(JSONObject json) throws Exception {
		JSONObject resultJson = new JSONObject();
		String userAccount = json.getString("userAccount");
		int account = mapper.selectUserAccount(userAccount); // 查询该用户是否存在在数据库中
		if (account > 0) {
			MallUser user = new MallUser();
			if (json.containsKey("userName")) {
				user.setUserName(json.getString("userName"));
			}
			if(json.containsKey("nickName")){
				user.setNickName(json.getString("nickName"));
			}
			if(json.containsKey("brithDate")){
				SimpleDateFormat format = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date birth = format.parse(json.getString("brithDate"));
				user.setBrithDate(birth);
			}
			if(json.containsKey("userPasswoed")){
				user.setUserPasswoed(json.getString("userPasswoed"));
			}
			if(json.containsKey("userPhoto")){
				user.setUserPhoto(json.getString("userPhoto"));
			}
			if(json.containsKey("userPhone")){
				user.setUserPhone(json.getString("userPhone"));
			}
			user.setUserAccount(userAccount);
			int result = mapper.updateByPrimaryKeySelective(user);
			if(result>0){
				resultJson.put("msg", "用户信息修改成功!");
				resultJson.put("status", 1);
				return resultJson;
			}else{
				resultJson.put("msg", "用户信息修改失败!");
				resultJson.put("status", 0);
				return resultJson;
			}
		}
		resultJson.put("msg", "账号错误!");
		resultJson.put("status", 2);
		return resultJson;
	}

}
