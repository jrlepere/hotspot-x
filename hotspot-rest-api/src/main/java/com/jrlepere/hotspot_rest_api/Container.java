package com.jrlepere.hotspot_rest_api;

import java.util.Queue;

public abstract class Container extends ProjectComponent {

	private String name;
	
	public Container(String name) {
		super(name);
	}
	
	public Queue<MethodCall> getMethodCalls() {
		return null;
	}
	
}
