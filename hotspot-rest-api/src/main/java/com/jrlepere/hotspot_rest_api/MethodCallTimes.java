package com.jrlepere.hotspot_rest_api;

import java.util.HashMap;
import java.util.Map;

import com.jrlepere.hotspot_component_interface.Method;

public class MethodCallTimes {

	private Map<Integer, Method> methodMap;
	private MethodCall[] methodCalls;
	
	public MethodCallTimes() {
		methodMap = new HashMap<>();
		methodCalls = new MethodCall[0];
	}
	
	public Map<Integer, Method> getMethodMap() {
		return methodMap;
	}
	
	public void setMethodMap(Map<Integer, Method> methodMap) {
		this.methodMap = methodMap;
	}
	
	public MethodCall[] getMethodCalls() {
		return methodCalls;
	}
	
	public void setMethodCalls(MethodCall[] methodCalls) {
		this.methodCalls = methodCalls;
	}
	
}
