import java.util.*;

class Solution {
    public int solution(int n) {

        int cnt = Integer.bitCount(n);

        while(true) {
            n++;
            if(Integer.bitCount(n) == cnt) break;
        }

        return n;
    }

}
