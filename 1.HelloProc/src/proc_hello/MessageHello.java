package proc_hello;




/**
 * Messages class.
 * Static message functions. 
 */
public class MessageHello {
	private static void print(String message) {
		System.out.print(message +System.lineSeparator());
		return;
	}
	
	public static void	HelloMessage(String name) {
		print("Hello "+name);
		return;
	}

	public static void	NiceToMeetMessage(String name) {
		print("Nice to meet you "+name);
		return;
	}

	public static void GoodbyeMessage(String name) {
		print("Good bye "+name);
		return;
	}
}
