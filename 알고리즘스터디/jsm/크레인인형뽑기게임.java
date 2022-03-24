import java.util.*;

class Solution {

    static int[][] map;
    static int answer;
    public int solution(int[][] board, int[] moves) {
        
        answer = 0;
        map = board;
        List<Integer> result = new ArrayList<>();
        
        // 크레인 위치 확인
        for(int i = 0; i < moves.length; i++) {
            int pick = go(moves[i] - 1);
            if(pick != 0) result.add(pick);
        }
             
        remove(result);

        return answer;
        
    }
    
    static int go(int c) {
        
        for(int r = 0; r < map.length; r++) {
            if(map[r][c] == 0) continue;
            else {
                int pick = map[r][c];
                map[r][c] = 0;
                return pick;
            } 
        }
        return 0;
        
    }
    
    static void remove(List<Integer> result) {
        
        for(int i = 0; i < result.size() - 1; i++) {           
            if(result.get(i) != result.get(i + 1)) continue;

            result.remove(i);
            result.remove(i);
            answer += 2;
            
            remove(result);               
        }
    }
    
}
