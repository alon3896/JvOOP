package proc_hello;

import java.io.IOException;

import oop_messages.MessageGoodbye;
import oop_messages.MessageHello;
import oop_messages.MessageNiceToMeet;
import oop_questions.QuestionWhatIs;





public class class_main {
	// //Prints Hello World!
	public static void main (String[] args) throws IOException
	{
		System.out.println("Hello World!"); // print command
		
		String name = new QuestionWhatIs().WhatIs("Your name");
		new MessageHello(name);
		new MessageNiceToMeet(name);
		new MessageGoodbye(name);
		
		return;
	}
}
