package oop_messages;




/**
 * Base message class.
 * Print message to standard IO. 
 */
public class Message {
	public Message (){
		super();
		System.out.println(this.toString());
		return;
	}
	public void print(String message) {
		System.out.print(message +System.lineSeparator());
		return;
	}
}
