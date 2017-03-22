package com.hsyl.mall;

import com.hsyl.mall.base.RedisUtil;

public class TestRedis {
	
	public static void main(String[] args) {
		new RedisUtil("127.0.0.1",6379);
		RedisUtil.set("NAME", "zhangsan");
	}

}
