package oop_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import oop_messages.Message;





public abstract class Question extends Message {
	protected BufferedReader reader;
	public Question() {
		reader = new BufferedReader( new InputStreamReader( System.in ) );
	}
	public abstract  String ask(String question) throws IOException ;
}
