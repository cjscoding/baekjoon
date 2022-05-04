import java.util.*;
import java.util.Map.Entry;

class Solution {
    public List<String> solution(String[] orders, int[] course) {
        
        // 각 손님의 코스 조합 구해서 map에 저장
        map = new HashMap<>();
        for(String o : orders) {
            String[] menus = o.split("");
            Arrays.sort(menus);
            int N = menus.length;
            
            for(int c : course) {
                String[] tmp = new String[c];
                getList(tmp, menus, c, 0, 0);            
            }        
        }
        
        // map에 있는 해당 코스 있나 확인
        map.forEach((k, v) -> {
            String[] menus = k.split("");
            l: for(String o : orders) {
                for(String m : menus) 
                    if(!o.contains(m)) continue l;

                int n = map.get(k);
                map.replace(k, n + 1);
            }
        });

        List<String> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if(v > 1) list.add(k);
        });
        
        // 그중 가장 큰 value 저장
        List<String> answer = new ArrayList<>();
        for(int c : course) {
            int max = 0;
            for(String l : list) {
                if(l.length() == c) {
                    max = Math.max(map.get(l), max);
                }
            }

            for(Entry<String, Integer> e : map.entrySet()) {
                String k = e.getKey();
                int v = e.getValue();
                if(k.length() == c && v == max) 
                   answer.add(k);
            }
            
        }
        
        // 오름차순 정렬
        Collections.sort(answer);
        
        return answer;
    }
    
    static Map<String, Integer> map;
    static void getList(String[] tmp, String[] menus, int M, int start, int idx) {
           
        if(idx == M) {
            String str = "";
            
            for(String t : tmp)
                str += t;
            
            // map에 있는지 확인
            if(!map.containsKey(str)) map.put(str, 0);            
            
            return;
        }
        
        for(int i = start; i < menus.length; i++) {
            tmp[idx] = menus[i];
            getList(tmp, menus, M, i + 1, idx + 1);
        }
    }
}
