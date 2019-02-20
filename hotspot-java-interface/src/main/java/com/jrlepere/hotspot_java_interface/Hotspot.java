package com.jrlepere.hotspot_java_interface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.jrlepere.hotspot_component_interface.CallableMethod;
import com.jrlepere.hotspot_component_interface.Container;

public class Hotspot {
	
	private static final Map<CallableMethod, String> idMap = new HashMap<>();
	
	private static final String postUrl = "http://localhost:8080/";
	private static final Gson gson = new Gson();
	private static final HttpClient httpClient = HttpClientBuilder.create().build();
	
	public static Object register(String[] methodPath, String methodName, String[] methodParamTypes) {
		CallableMethod callableMethod = new CallableMethod(methodPath, methodName, methodParamTypes);
		final String relativePath = "register";
		HttpPost post;
		HttpResponse response;
		try {
			post = getHttpPost(relativePath, callableMethod);
			response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			idMap.put(callableMethod, EntityUtils.toString(entity, "UTF-8"));	
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return callableMethod;
	}
	
	public static void notify(Object callableMethod) {
		final String relativePath = "register";
		System.out.println(idMap.get(callableMethod));
		// get id
	}
	
	private static HttpPost getHttpPost(String relativePath, Object entity) throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(postUrl + relativePath);
		StringEntity postingString = new StringEntity(gson.toJson(entity));
		post.setEntity(postingString);
		post.setHeader("Content-type", "application/json");
		return post;
	}
	
}