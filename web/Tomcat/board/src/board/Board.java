package board;

public class Board {
//	String boardPw = request.getParameter("boardPw");
//	String boardTitle = request.getParameter("boardTitle");
//	String boardContent = request.getParameter("boardContent");
//	String boardUser = request.getParameter("boardUser");
	private String boardPw;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	
	
	@Override
	public String toString() {
		return "board [boardPw=" + boardPw + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardUser=" + boardUser + "]";
	}
	public Board(String boardPw, String boardTitle, String boardContent, String boardUser) {
		super();
		this.boardPw = boardPw;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardUser = boardUser;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	
	
	
}
