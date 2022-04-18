import java.util.*;

class Solution {
    public String solution(String s) {
        
        String answer = "";
        
        String[] words = s.split(" ");
        
        for(String w : words) {
            if(w.equals("")) {
                answer += " ";
            } else {
                answer += String.valueOf(w.charAt(0)).toUpperCase() 
                    + w.substring(1).toLowerCase() + " ";
            }
        }
      
        answer = answer.trim();
        if(s.substring(s.length() - 1).equals(" "))
            answer += " ";
        
        return answer;
    }
}
