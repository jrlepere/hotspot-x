package com.jrlepere.hotspot_rest_api;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrlepere.hotspot_component_interface.CallableMethod;
import com.jrlepere.hotspot_component_interface.Container;
import com.jrlepere.hotspot_component_interface.Method;
import com.jrlepere.hotspot_rest_api.project.ContainerNode;
import com.jrlepere.hotspot_rest_api.project.IProjectNode;
import com.jrlepere.hotspot_rest_api.project.MethodNode;

@RestController
public class AppController {

	private static ContainerNode projectRoot;
	private final static IdComponentMapper idComponentMapper
			= new IdComponentMapper();
	private final static MethodCallTimeCollection methodCallTimesCollection
			= new MethodCallTimeCollection();
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<Integer> register(@RequestBody CallableMethod callableMethod) {
		Container[] methodPath = callableMethod.getPath();
		// validate length
		setProjectRootIfNull(methodPath[0]);
		// validate first is root
		int i = 1;
		IProjectNode currentNode;
		for (currentNode = projectRoot; i < methodPath.length; i ++) {
			Container nextComponent = methodPath[i];
			if (currentNode.containsChildComponent(nextComponent)) {
				currentNode = currentNode.getChildNode(nextComponent);
			} else {
				ContainerNode nextNode = new ContainerNode(currentNode, nextComponent);
				currentNode.addChild(nextNode);
				currentNode = nextNode;
				idComponentMapper.add(currentNode.getId(), currentNode);
			}
		}
		
		Method method = callableMethod.getMethod();
		MethodNode methodNode;
		if (currentNode.containsChildComponent(method)) {
			methodNode = (MethodNode) currentNode.getChildNode(method);
		} else {
			methodNode = new MethodNode(currentNode, method);
			idComponentMapper.add(methodNode.getId(), methodNode);
			methodCallTimesCollection.registerMethod(methodNode.getId());
			currentNode.addChild(methodNode);
		}
		return new ResponseEntity<Integer>(methodNode.getId(), HttpStatus.OK);
	}
	
	private static void setProjectRootIfNull(Container root) {
		if (projectRoot == null) {
			projectRoot = new ContainerNode(null, root);
			idComponentMapper.add(projectRoot.getId(), projectRoot);
		}
	}
	
	@RequestMapping("/notify")
	public void notify(@RequestParam("id") Integer methodId) {
		methodCallTimesCollection.addMethodCall(methodId);
	}
	
	@RequestMapping("/rootComponentId")
	@CrossOrigin(origins = "http://localhost:4200")
	public Integer getRootComponentId() {
		return projectRoot.getId();
	}
	
	@RequestMapping("/childComponentIds")
	@CrossOrigin(origins = "http://localhost:4200")
	public Integer[] getChildComponentIds(@RequestParam("id") Integer componentId) {
		Collection<Integer> childComponentIds
				= idComponentMapper.getComponent(componentId).getChildComponentIds();
		return childComponentIds.toArray(new Integer[childComponentIds.size()]);
	}
	
	@RequestMapping("/methodCallTimes")
	@CrossOrigin(origins = "http://localhost:4200")
	public MethodCallTimes methodCallTimes(@RequestParam("id") Integer componentId) {
		MethodCallTimes methodCallTimes = new MethodCallTimes();
		Collection<MethodNode> methodNodes = idComponentMapper.getComponent(componentId).getMethodNodes();
		Map<Integer, Method> methodMap = new HashMap<>();
		Collection<MethodCall> methodCalls = new LinkedList<>();
		for (MethodNode methodNode : methodNodes) {
			Integer methodId = methodNode.getId();
			if (methodCallTimesCollection.hasMethodCalls(methodId)) {
				methodMap.put(methodId, (Method) methodNode.getProjectComponent());
				for (Date time : methodCallTimesCollection.getMethodCallTimes(methodId)) {
					methodCalls.add(new MethodCall(methodId, time));
				}
			}
		}
		
		methodCallTimes.setMethodMap(methodMap);
		methodCallTimes.setMethodCalls(methodCalls.toArray(new MethodCall[methodCalls.size()]));
		
		return methodCallTimes;
	}
	
}
