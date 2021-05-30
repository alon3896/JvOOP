package oop_questions;

import oop_messages.Message;





public class Question extends Message {
	protected void print(String message) {
		super.print(message + "?");
	}
}
