package com.jrlepere.hotspot_rest_api;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrlepere.hotspot_component_interface.CallableMethod;
import com.jrlepere.hotspot_component_interface.Container;
import com.jrlepere.hotspot_rest_api.project.ContainerNode;
import com.jrlepere.hotspot_rest_api.project.IProjectNode;

@RestController
public class AppController {

	private IProjectNode projectRoot;
	private final IdComponentMapper idComponentMapper
			= new IdComponentMapper();
	private final MethodCallTimeCollection methodCallTimesCollection
			= new MethodCallTimeCollection();

	@RequestMapping(value="/init", method = RequestMethod.POST)
	public void init(@RequestBody Container rootContainer) {
		System.out.println(rootContainer);
		projectRoot = new ContainerNode(null, (Container) rootContainer);
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<Integer> register(@RequestBody CallableMethod callableMethod) {
		// validate length
		// validate last is Method
		// validate first is root
		// validate none first and none last are all Containers
//		int i = 1;
//		IProjectNode currentNode;
//		for (currentNode = projectRoot; i < methodPath.length-1; i ++) {
//			ProjectComponent nextComponent = methodPath[i];
//			if (currentNode.containsChildComponent(nextComponent)) {
//				currentNode = currentNode.getChildNode(nextComponent);
//			} else {
//				ContainerNode nextNode = new ContainerNode(currentNode,
//						(Container) nextComponent);
//				currentNode.addChild(nextNode);
//				currentNode = nextNode;
//			}
//		}
//		// validate currentNode does not already have method registered
//		MethodNode methodNode = new MethodNode(currentNode, (Method) methodPath[i]);
//		methodCallTimesCollection.registerMethod(methodNode.getId());
//		currentNode.addChild(methodNode);
//		return methodNode.getId();
		System.out.println(callableMethod);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	
	@RequestMapping("/notify")
	public void notify(@RequestParam("id") Integer methodId) {
		methodCallTimesCollection.addMethodCall(methodId);
	}
	
	@RequestMapping("/rootComponentId")
	public int getRootComponentId() {
		return projectRoot.getId();
	}
	
	@RequestMapping("/childComponentIds")
	public Integer[] getChildComponentIds(@RequestParam("id") Integer componentId) {
		Collection<Integer> childComponentIds
				= idComponentMapper.getComponent(componentId).getChildComponentIds();
		return childComponentIds.toArray(new Integer[childComponentIds.size()]);
	}
	
	
	@RequestMapping("/temp")
	public MethodCallTimes methodCallTimes(@RequestParam("id") Integer componentId) {
		return null;
	}
	
}
