package proc_hello;

import java.io.IOException;





public class class_main {
	// //Prints Hello World!
	public static void main (String[] args) throws IOException
	{
		System.out.println("Hello World!"); // print command
		
		String name = Questions.WhatIs("Your name");
		MessageHello.HelloMessage(name);
		MessageHello.NiceToMeetMessage(name);
		MessageHello.GoodbyeMessage(name);
		
		return;
	}
}
