package com.jrlepere.test_project;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;

public class App {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		Scanner in = new Scanner(System.in);
		Calculator calc = new Calculator(0, 0);
		while (true) {
			System.out.print("Operation: ");
			String input = in.nextLine().trim().toLowerCase();
			if (input.equals("a")) {
				calc.add();
			} else if (input.equals("s")) {
				calc.subtract();
			} else if (input.equals("m")) {
				calc.multiply();
			} else if (input.equals("q")) {
				break;
			}
		}
		in.close();
	}
	
}
