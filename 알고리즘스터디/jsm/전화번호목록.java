import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book[i].length(); j++) {
                String str = phone_book[i].substring(0, j);
                if(hm.containsKey(str))
                    return false;
            }
        }
        
        return true;
    }
}
