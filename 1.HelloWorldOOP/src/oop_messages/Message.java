package oop_messages;




/**
 * Base message class.
 * Print message to standard IO. 
 */
public class Message {
	public void print(String message) {
		System.out.print(message +System.lineSeparator());
	}
}
