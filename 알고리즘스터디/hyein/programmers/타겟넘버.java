import java.util.*;

class Solution {  
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        DFS(0, 0, numbers, target);
        return answer;
    }
    
    private static void DFS(int idx, int sum, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        DFS(idx + 1, sum + numbers[idx], numbers, target);
        DFS(idx + 1, sum - numbers[idx], numbers, target);
    }
}