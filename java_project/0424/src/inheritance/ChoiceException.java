package inheritance;

public class ChoiceException extends Exception {
	public ChoiceException() {
		super("유효하지 않은 값이 선택되었습니다");
	}
}
