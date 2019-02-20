package com.jrlepere.test_project;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class App {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		Calculator calc = new Calculator(0, 0);
		calc.add();
		calc.add();
	}
	
}
