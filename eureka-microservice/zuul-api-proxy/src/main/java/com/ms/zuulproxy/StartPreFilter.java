package com.ms.zuulproxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import java.time.Instant;

import com.netflix.zuul.exception.ZuulException;

public class StartPreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;

	}

	@Override
	public Object run() throws ZuulException {

		Instant start = Instant.now();
		RequestContext ctx = getCurrentContext();
		ctx.set("start", start);
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
