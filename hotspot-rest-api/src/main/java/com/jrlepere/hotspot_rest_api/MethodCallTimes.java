package com.jrlepere.hotspot_rest_api;

import java.util.Map;

import com.jrlepere.hotspot_component_interface.Method;

public class MethodCallTimes {

	private Map<Integer, Method> methodMap;
	private MethodCall[] methodCalls;
	
	public void addMethodMap(int methodId, Method method) {
		methodMap.put(methodId, method);
	}
	
	public void setMethodCalls() {
		
	}
	
}
