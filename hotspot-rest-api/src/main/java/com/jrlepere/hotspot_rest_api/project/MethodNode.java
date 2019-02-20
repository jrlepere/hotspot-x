package com.jrlepere.hotspot_rest_api.project;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import com.jrlepere.hotspot_component_interface.Method;
import com.jrlepere.hotspot_component_interface.ProjectComponent;

public class MethodNode extends ProjectNode {

	private Method method;
	
	public MethodNode(IProjectNode parent, Method method) {
		super(parent);
		this.method = method;
	}
	
	public void addChild(IProjectNode child) { }
	
	public IProjectNode getChildNode(ProjectComponent component) {
		return null; //TODO: raise exception
	}
	
	public ProjectComponent getProjectComponent() {
		return method;
	}
	
	public Collection<Integer> getChildComponentIds() {
		return new LinkedList<>();
	}

	public Collection<Method> getMethods() {
		return new LinkedList<Method>(Arrays.asList(method));
	}
	
	public boolean containsChildComponent(ProjectComponent component) {
		return false;
	}

}
