package com.jrlepere.hotspot_component_interface;

import java.util.Arrays;

public class CallableMethod {

	Container[] path;
	Method method;
	
	public CallableMethod() { }
	
	public CallableMethod(Container[] path, Method method) {
		this.path = path;
		this.method = method;
	}
	
	public CallableMethod(String[] methodPath, String methodName, String[] methodParamTypes) {
		path = new Container[methodPath.length];
		for (int i = 0; i < methodPath.length; i ++) {
			path[i] = new Container(methodPath[i]);
		}
		method = new Method(methodName, methodParamTypes);
	}
	
	public Container[] getPath() {
		return path;
	}
	
	public void setPath(Container[] path) {
		this.path = path;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public void setMethod(Method method) {
		this.method = method;
	}
	
	public String toString() {
		return "{path=" + Arrays.toString(path) + ",method=" + method + "}";
	}
	
}
