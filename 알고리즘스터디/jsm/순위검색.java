import java.util.*; // import 실수

class Solution {
    
    // static 실수
    static Map<String, List<Integer>> map; // 조건 String, 점수 list
    public int[] solution(String[] info, String[] query) {
        
        int[] answer = new int[query.length];
        
        // 1. 조합으로 경우의 수 만들기
        map = new HashMap<String, List<Integer>>(); // 통과 리스트
        for(int i = 0; i < info.length; i++) {
            String[] str = info[i].split(" ");
            setList(0, "", str);
        }
            
        // 2. 점수를 기준으로한 정렬
        for(String key : map.keySet())
            Collections.sort(map.get(key));
        
        // 3. 이진탐색 - 효율을 위해
        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] pass = query[i].split(" "); // 합격 조건
            // map 에 합격 조건에 부합하는 key가 있다면 이진탐색 실행
            answer[i] = map.containsKey(pass[0]) ? binarySearch(pass[0], Integer.parseInt(pass[1])) : 0; // parse 철자 실수
        }
        
        return answer;
    }
    
    
    static int binarySearch(String key, int score) {
        
        // 합격 조건에 맞는 지원자 리스트 가져오기
        List<Integer> list = map.get(key); 
        int start = 0, end = list.size() - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return list.size() - start; // 조건 만족 지원자 수
        
    }
    
    // 지원자 합격가능 리스트 생성 함수
    static void setList(int idx, String str, String[] info) {
        
        if(idx == 4) {
            // key값 중 새로운 값이라면
            if(!map.containsKey(str)) { 
                List<Integer> list = new ArrayList<>();
                map.put(str, list); // key, value 생성
            }
            // str (key) 가져와서 value 추가
            map.get(str).add(Integer.parseInt(info[4]));
            return;
        }
        
        setList(idx + 1, str + "-", info);
        setList(idx + 1, str + info[idx], info);
        
    }
    
}
