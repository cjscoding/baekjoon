import java.util.*;
class Solution {
    HashMap<String, ArrayList<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(String i : info) {
            String[] temp = i.split(" ");
            String[] lang = { temp[0], "-" };
            String[] job = { temp[1], "-" };
            String[] career = { temp[2], "-" };
            String[] food = { temp[3], "-" };
            int value = Integer.parseInt(temp[4]);
            
            input(lang, job, career, food, value);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] data = query[i].split(" and ");
            String[] last = data[3].split(" ");
            data[3] = last[0];
            int value = Integer.parseInt(last[1]);
            String key = String.join(" ", data);

            int cnt = 0;
            if(map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                int lowerBound = lowerBinarySearch(list, value);
                cnt = list.size() - lowerBound;
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
    
    private void input(String[] lang, String[] job, String[] career, String[] food, int value) {
        for(String l : lang) {
            for(String j : job) {
                for(String c : career) {
                    for(String f : food) {
                        String[] data = { l, j, c, f };
                        String key = String.join(" ", data);
                        ArrayList<Integer> list = map.getOrDefault(key, new ArrayList<>());
                        list.add(value);
                        map.put(key, list);
                    }
                }
            }
        }
    }
    
    private int lowerBinarySearch(ArrayList<Integer> list, int value) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(value <= list.get(mid)) {
                right = mid;
            } else left = mid + 1;
        }
        
        return left;
    }
}