package proc_hello;



public class MessageHello {
	private static void print(String message) {
		System.out.print(message +System.lineSeparator());
	}
	
	public static void	HelloMessage(String name) {
		print("Hello "+name);
	}

	public static void	NiceToMeetMessage(String name) {
		print("Nice to meet you "+name);
	}

	public static void GoodbyeMessage(String name) {
		print("Good bye "+name);
	}
}
