package com.jrlepere.test_project;

import com.jrlepere.hotspot_java_interface.Hotspot;

public class Calculator {

	private static final String[] CALCULATOR_CLASS_PATH =
			new String[]{"com", "jrlepere", "test_project", "Calculator.java", "Calculator"};
	public static final Object CONSTRUCTOR = Hotspot.register(CALCULATOR_CLASS_PATH, "Calculator", new String[] {"int", "int"});
	public static final Object ADD = Hotspot.register(CALCULATOR_CLASS_PATH, "add", new String[] {});
	public static final Object SUB = Hotspot.register(CALCULATOR_CLASS_PATH, "subtract", new String[] {});
	public static final Object MUL = Hotspot.register(CALCULATOR_CLASS_PATH, "multiply", new String[] {});
	
	
	private int x, y;
	
	public Calculator(int x, int y) {
		Hotspot.notify(CONSTRUCTOR);
		this.x = x;
		this.y = y;
	}
	
	public int add() {
		Hotspot.notify(ADD);
		return x + y;
	}
	
	public int subtract() {
		Hotspot.notify(SUB);
		return x - y;
	}
	
	public int multiply() {
		Hotspot.notify(MUL);
		return x * y;
	}
	
}
