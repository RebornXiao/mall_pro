/**
 * 
 */
package com.hsyl.mall.util;

import java.io.UnsupportedEncodingException;  
import org.apache.commons.codec.binary.Base64;  
import org.apache.commons.codec.digest.DigestUtils;  

/**
 * @author yhyi
 * @function 使用base64+MD5加密方式
 *
 */
public class EncryptTool {
	
	  public static String md5Base64Url(String str){  
	        //先进行MD5加密,加密完成字符串继续进行base64加密。  
	        String res = "";  
	        byte[] bytesMd5 = DigestUtils.md5(str);  
	          
	        Base64 base64 = new Base64();  
	      
	        //base64 加密  
	        byte[] byteBase64 = base64.encode(bytesMd5);  
	        res = new String(byteBase64);  
	        return res;  
	    }  
	      
	    // md5+base64+url  
	    public static String encodeToUrlString(String str){   
	        String rev = "";  
	        try{  
	            str = java.net.URLEncoder.encode(str, "UTF-8");  
	        }catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        byte[] bytesMd5 = DigestUtils.md5(str);  
	        Base64 base64 = new Base64();  
	        byte[] byteBase64 = base64.encode(bytesMd5);  
	        rev = new String(byteBase64);  
	        return rev;  
	    }  

}
