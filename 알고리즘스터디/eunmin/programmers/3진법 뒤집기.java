package Lv1;

import java.util.Arrays;

public class Lv1_3진법뒤집기 {
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int n = 125;
		int answer = solution.solution(n);
		System.out.println(answer);
	}	
}

class Solution {
    public int solution(int n) {
        
    	int answer = 0;
        String result = "";
    	
        int a = n;
        int b = n;
        
        while(a > 2) {
        	b = a%3;
        	a /= 3;

        	result += b;
        }
        result += a;
        
//      return Integer.parseInt(result, 3); //신기
        
        int c = 1;
        for(int i = result.length()-1; i >= 0; i--) {
        	answer += (result.charAt(i)-'0')*c;
        	c *= 3;
        }
        
        return answer;
    }
}
