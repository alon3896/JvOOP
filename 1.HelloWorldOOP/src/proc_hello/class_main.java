package proc_hello;

import java.io.IOException;

import oop_messages.Message;
import oop_messages.MessageGoodbye;
import oop_messages.MessageHello;
import oop_messages.MessageNiceToMeet;
import oop_questions.Question;
import oop_questions.QuestionWhatIs;





public class class_main {
	// //Prints Hello World!
	public static void main (String[] args) throws IOException
	{
		// print text to std io.
		System.out.println("Hello World!");
		
		//	Allocate new "What is" question and ask it. 
		Question what_is = new QuestionWhatIs();
		String name = what_is.ask("your name");
		
		//	Present hello and nice to meet messages.
		new MessageHello(name);
		new MessageNiceToMeet(name);
		
		//	Ask for 'favorite color' and print good choice.
		String color = what_is.ask("your favorit color");
		new Message().print(color + "is a good choice thank you!");
		
		//	Say good by.
		new MessageGoodbye(name);
		
		return;
	}
}
