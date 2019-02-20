package com.jrlepere.hotspot_rest_api;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MethodCallTimeCollection {

	private Map<Integer, Queue<Date>> methodCallTimes;
	
	public MethodCallTimeCollection() {
		this.methodCallTimes = new HashMap<>();
	}
	
	public void registerMethod(int methodId) {
		methodCallTimes.put(methodId, new LinkedList<Date>());
	}
	
	public void addMethodCall(int methodId) {
		// verify registered
		methodCallTimes.get(methodId).add(new Date());
	}
	
	public boolean hasMethodCalls(int componentId) {
		return methodCallTimes.containsKey(componentId)
				&& methodCallTimes.get(componentId).size() > 0;
	}
	
	public Date[] getMethodCallTimes(int componentId) {
		return methodCallTimes.get(componentId).toArray(new Date[methodCallTimes.size()]);
	}
	
}
