import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        int cnt = 0;
        for(int i = 0; i < 6; i++) {
            if(lottos[i] != 0) break;
            cnt++;
        }
        
        int lowest = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = cnt; j < 6; j++) {
                if(win_nums[i] == lottos[j]) lowest++;
            }
        }
        
        int highest = lowest + cnt;
        int[] answer = new int[2];
        answer[0] = getRank(highest);
        answer[1] = getRank(lowest);
        
        return answer;
    }
    
    private static int getRank(int n) {
        if(n < 2) return 6;
        
        switch(n) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
        }
        
        return 0;
    }
}