package com.org.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class LogFilter extends ZuulFilter{

	Logger LOG=LoggerFactory.getLogger(this.getClass());	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context= RequestContext.getCurrentContext();
		HttpServletRequest request=context.getRequest();
		LOG.info("Zuul LOG--- {} request to {}",request.getMethod(),request.getRequestURL());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}
	
	
}
