
public class ex02 {

	public static void main(String[] args) {
		Solution2 sol=new Solution2();
		int x=18;
		System.out.println(sol.solution(x));
		
 	}
}

class Solution2 {
    public boolean solution(int x) {
    	int temp=x;
    	int n=0;
    	int sum=0;
    	boolean answer=false;
    	while(temp>0) {
    		n=temp%10;
    		temp/=10;
//    		System.out.println(n+"\t");
    		sum+=n;
    	}
//    	System.out.println(sum+"\n");
    	if(x%sum==0)
    		answer = true;
        
        return answer;
    }
}