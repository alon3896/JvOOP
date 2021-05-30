package oop_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import oop_messages.Message;




public class QuestionWhatIs extends Message {
	
	public String WhatIs(String question) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		
		super.print(question+"?"+System.lineSeparator());
		String input = reader.readLine();
		return(input);
	}
}
