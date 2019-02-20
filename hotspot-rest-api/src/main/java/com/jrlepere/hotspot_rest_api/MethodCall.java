package com.jrlepere.hotspot_rest_api;

import java.util.Date;

public class MethodCall {

	private int methodId;
	private Date callTime;
	
	public MethodCall() {}
	
	public MethodCall(int methodId, Date callTime) {
		this.methodId = methodId;
		this.callTime = callTime;
	}
	
	public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
	}
	
}
