package com.jrlepere.hotspot_rest_api;

import java.util.Queue;

public interface IProjectComponent {

	public Queue<MethodCall> getMethodCalls();
	public String getName();
	
}
