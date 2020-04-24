package inheritance;

public class Speaker {
	private int volumeRate;

	void showCurrentState() {
		System.out.println("볼륨 크기:" + this.volumeRate);
	}

	void setVolume(int vol) {
		this.volumeRate = vol;
	}

}
