
public class ex03 {

	public static void main(String[] args) {
		Solution sol=new Solution();
		String dartResult="";
		System.out.println(sol.solution("1S2D*3T"));
		
 	}
}

//점수 0~10, SDT 점수^1,2,3
//옵션 *바로전 점수 2배 #점수 마이너스
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int index=dartResult.indexOf("S");
        
        int score=dartResult.charAt(0)-'0';
        System.out.println("score:"+score);
        
        
        return answer;
    }
}