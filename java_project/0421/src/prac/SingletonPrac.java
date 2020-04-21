package prac;

final class SingletonPrac {
	private static SingletonPrac s = new SingletonPrac();

	private SingletonPrac() {
	}

	public static SingletonPrac getinstance() {
		if (s == null)
			s = new SingletonPrac();
		return s;
	}
}
