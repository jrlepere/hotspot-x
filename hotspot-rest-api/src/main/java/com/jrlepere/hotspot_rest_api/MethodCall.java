package com.jrlepere.hotspot_rest_api;

import java.util.Date;

public class MethodCall {

	private int methodId;
	private Date callTime;
	
	public MethodCall(int methodId, Date callTime) {
		this.methodId = methodId;
		this.callTime = callTime;
	}
	
}
