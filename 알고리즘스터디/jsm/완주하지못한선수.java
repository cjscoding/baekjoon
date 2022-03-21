import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<Integer, String> hm = new HashMap<>();
        for(int i = 0; i < participant.length; i++) {
            hm.put(i, participant[i]);
        }
                
        String answer = "";
        for(int i = 0; i < completion.length; i++) {
            for(Entry<Integer, String> e : hm.entrySet()) {
                if(e.getValue() == completion[i]) {
                    hm.remove(e.getKey());
                    continue l;
            }
        }
        
        for(Entry<Integer, String> e : hm.entrySet()) {
            answer = e.getValue();
        }
       
        return answer;
    }
}
