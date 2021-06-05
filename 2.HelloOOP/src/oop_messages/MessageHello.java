package oop_messages;





/**
 *	Hello message.
 *	Ask a person hello.
 */
public class MessageHello extends Message {
	public MessageHello(String name) {
		print("Hello "+name);
		return;
	}
}
