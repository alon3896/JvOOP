package oop_questions;

import java.io.IOException;





public class QuestionWhatIs extends Question {

	@Override
	public String ask(String question) throws IOException {
		
		super.print(question+"?"+System.lineSeparator());
		String input = reader.readLine();
		return(input);
	}
}
