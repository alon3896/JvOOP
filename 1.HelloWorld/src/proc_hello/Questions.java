package proc_hello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;





public class Questions {
	private static void print(String message) {
		System.out.print(message +System.lineSeparator());
	}

	
	public static String WhatIs(String question) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		
		print(question+"?"+System.lineSeparator());
		String input = reader.readLine();
		return(input);
	}
}
