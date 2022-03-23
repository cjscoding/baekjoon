import java.util.*;

class Solution {

    static HashMap<String, List<String>> map;
    public int solution(String[][] clothes) {

        map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            String value = clothes[i][0];
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(value);
        }

        // h : y, g (2 + 1)
        // e : b (1 + 1)
        // s : r, y, b (3 + 1)
        // 3 * 2 * 4 - 1 = 23 공식이용!

        int answer = 1;
        for(String k : map.keySet()) {
            answer *= map.get(k).size() + 1;
            // System.out.println(map.get(k).size());
        }

        return answer - 1;
    }
}
