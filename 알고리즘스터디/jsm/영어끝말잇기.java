import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        if(words[0].length() < 2) return new int[] {1, 1};
        
        for(int i = 1; i < words.length; i++) {

            String cur = words[i]; // 현재 단어
            String curInit = cur.substring(0, 1); // 현재 단어의 앞글자
            String preEnd = words[i - 1]
                            .substring(words[i - 1].length() - 1); // 전 단어의 끝글자
            
            int num = i % n + 1; // 번호
            int turn = i / n + 1; // 차례
            // 1. 앞단어의 끝자리와 일치
            if(!curInit.equals(preEnd)) return new int[] {num, turn};
            // 2. 한글자 x
            if(cur.length() < 2) return new int[]{num, turn};                
            // 3. 이미 했던거 x
            for(int j = 0; j < i; j++) {
                if(words[j].equals(cur)) return new int[]{num, turn};
            }
          
        }
        
        return new int[]{0, 0};
    }
}
