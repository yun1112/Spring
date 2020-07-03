public class ex01 {

	public static void main(String[] args) {
		Solution1 sol=new Solution1();
		String s="AB";
		int n=1;
		System.out.println(sol.solution(s, n));
		
 	}
}

class Solution1 {
    public String solution(String s, int n) {
        String answer = "";
        char temp;
        for(int i=0;i<s.length();i++){
        	temp=(char) (s.charAt(i)+n);
        	answer+=temp;
        }
        return answer;
    }
}