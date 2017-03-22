/**
 * 
 */
package com.hsyl.mall.inter;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ML
 *
 */
public interface MallUserService {
	
	JSONObject userRegister(JSONObject json)throws Exception;
	
	JSONObject userLogin(JSONObject json)throws Exception;
	
	JSONObject checkUserExist(JSONObject json)throws Exception;
	
	JSONObject changeUserInfo(JSONObject json)throws Exception;

}
