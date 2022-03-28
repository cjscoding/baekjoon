package Lv2;

import java.util.Arrays;

public class 주식가격 {
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int[] prices = new int[] {1,2,3,2,3};
		int[] answer = solution.solution(prices);
		System.out.println(Arrays.toString(answer));
	}	
}

class Solution {
    
	public int[] solution(int[] prices) {
    	
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++){
            int cnt = 0;
            for(int j = i+1; j < prices.length; j++){
            	cnt++;
            	if(prices[i] > prices[j])
            		break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}

class Solution2 {
    
	public int[] solution(int[] prices) {
    	
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int cnt = 0;
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] <= prices[j])
                    cnt += 1;
                else{
                    cnt += 1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
