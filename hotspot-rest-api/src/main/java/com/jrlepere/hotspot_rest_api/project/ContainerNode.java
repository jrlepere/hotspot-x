package com.jrlepere.hotspot_rest_api.project;

import java.util.Collection;
import java.util.LinkedList;

import com.jrlepere.hotspot_component_interface.Container;
import com.jrlepere.hotspot_component_interface.Method;
import com.jrlepere.hotspot_component_interface.ProjectComponent;

public class ContainerNode extends ProjectNode {

	private Container container;
	private Collection<IProjectNode> children;
	
	public ContainerNode(IProjectNode parent, Container container) {
		super(parent);
		this.container = container;
		this.children = new LinkedList<>();
	}
	
	public void addChild(IProjectNode child) {
		children.add(child);
	}
	
	public IProjectNode getChildNode(ProjectComponent component) {
		for (IProjectNode child : children) {
			if (child.getProjectComponent().equals(component)) {
				return child;
			}
		}
		return null; //TODO: raise exception
	}
	
	public ProjectComponent getProjectComponent() {
		return container;
	}
	
	public Collection<Integer> getChildComponentIds() {
		LinkedList<Integer> ids = new LinkedList<>();
		for (IProjectNode child : children) {
			ids.add(child.getId());
		}
		return ids;
	}

	public Collection<Method> getMethods() {
		LinkedList<Method> methods = new LinkedList<>();
		for (IProjectNode child : children) {
			methods.addAll(child.getMethods());
		}
		return methods;
	}
	
	public Collection<Integer> getMethodIds() {
		LinkedList<Integer> methodIds = new LinkedList<>();
		for (IProjectNode child : children) {
			methodIds.addAll(child.getMethodIds());
		}
		return methodIds;
	}
	
	public Collection<MethodNode> getMethodNodes() {
		LinkedList<MethodNode> methodNodes = new LinkedList<>();
		for (IProjectNode child : children) {
			methodNodes.addAll(child.getMethodNodes());
		}
		return methodNodes;
	}
	
	public boolean containsChildComponent(ProjectComponent component) {
		for (IProjectNode child : children) {
			if (child.getProjectComponent().equals(component)) {
				return true;
			}
		}
		return false;
	}

}
