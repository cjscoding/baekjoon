import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0];
            int[] subArray = new int[length + 1];
            for(int j = 0; j <= length; j++) {
                subArray[j] = array[commands[i][0] + j - 1];
            }
            
            Arrays.sort(subArray);
            answer[i] = subArray[commands[i][2]-1];
        }
        
        return answer;
    }
}