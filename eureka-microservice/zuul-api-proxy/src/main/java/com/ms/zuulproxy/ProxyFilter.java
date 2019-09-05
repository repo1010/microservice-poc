package com.ms.zuulproxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import com.netflix.zuul.exception.ZuulException;

public class ProxyFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		Boolean isProcessing = false;
		RequestContext ctx = getCurrentContext();
		String param = ctx.getRequest().getParameter("prodname");
		if (param!= null && param.equals("milk"))
			isProcessing = true;
		return isProcessing;
		
	}

	@Override
	public Object run() throws ZuulException {

		System.out.println("Calling a Filter");
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
