package singleton;

public class PhoneBookManager {
	private static PhoneBookManager manager=new PhoneBookManager();
	private PhoneBookManager() {
		System.out.println("singleton instance created");
	}
	public static PhoneBookManager getInstance() {
		return manager;
	}
}

