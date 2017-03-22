package com.hsyl.mall.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author yhyi
 * @function 将url后面的参数变成json格式字符串
 *
 */
public class UrlParamFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unused")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		int i=0;
		String email = request.getParameter("Email");
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
