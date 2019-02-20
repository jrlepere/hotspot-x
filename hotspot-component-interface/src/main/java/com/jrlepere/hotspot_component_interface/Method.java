package com.jrlepere.hotspot_component_interface;

import java.util.Arrays;

public class Method implements ProjectComponent {

	private String name;
	private String[] paramTypes;
	
	public Method() {}
	
	public Method(String name, String[] paramTypes) {
		this.name = name;
		this.paramTypes = paramTypes;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setParameters(String[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	
	public String[] getParameters() {
		return paramTypes;
	}
	
	public boolean equals(Object otherMethod) {
		return (otherMethod instanceof Method)
				&& this.name.equals(((Method) otherMethod).name)
				&& Arrays.equals(this.paramTypes, ((Method) otherMethod).paramTypes);
	}
	
	public String toString() {
		return "{name=" + name + ",paramType=" + Arrays.toString(paramTypes) + "}";
	}

}
