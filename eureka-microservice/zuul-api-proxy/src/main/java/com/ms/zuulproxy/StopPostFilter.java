package com.ms.zuulproxy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.netflix.zuul.exception.ZuulException;

public class StopPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;

	}

	@Override
	public Object run() throws ZuulException {

		Instant stop = Instant.now();
		RequestContext ctx = getCurrentContext();
		Instant start = (Instant) ctx.get("start");
		long millisecdifference = ChronoUnit.MILLIS.between(start, stop);
		System.out.println("Call took " + millisecdifference + "milli seconds");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
