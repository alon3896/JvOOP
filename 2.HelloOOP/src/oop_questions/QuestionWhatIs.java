package oop_questions;

import java.io.IOException;





public class QuestionWhatIs extends Question {
	//	Constructor.
	public QuestionWhatIs() {
		super();
	}
	// Implementation of abstract method.
	@Override
	public String ask(String question) throws IOException {
		
		super.print(question+"?"+System.lineSeparator());
		String input = super.reader.readLine();
		return(input);
	}
}
