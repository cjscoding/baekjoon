import java.util.*;

class Solution {
  
    public int[] solution(String[] id_list, String[] report, int k) {
      
        int[] answer = new int[id_list.length];
      
        // 유저이름, 타겟 이름
        HashMap<String, List<String>> userMap = new HashMap<>();
        HashMap<String, Integer> cntMap = new HashMap<>();
        
        // id_list: 모든 유저        
        for(int i = 0; i < id_list.length; i++) {
            List<String> list = new ArrayList<>();
            userMap.put(id_list[i], list);
            cntMap.put(id_list[i], 0);
        }
        
        // 신고자 id_list에서 찾아서 타겟 이름 넣기     
        int cnt;
        for(int i = 0; i < report.length; i++) {
            String str[] = report[i].split(" ");
            if(!userMap.get(str[0]).contains(str[1])) {
                userMap.get(str[0]).add(str[1]);
            
                cnt = cntMap.get(str[1]);
                cnt++;
                cntMap.replace(str[1], cnt); // 타겟 신고 당한 횟수 올리기
            }
        }
                
        // k 이상 신고 당한 유저 추출
        String str = "";
        for(int i = 0; i < id_list.length; i++) {
            int tmp = cntMap.get(id_list[i]);
            if(k <= tmp) str += id_list[i] + " ";
        }
        
        // 추출된 유저를 신고한 신고자에게 통보수 출력
        String target[] = str.split(" ");
        for(int i = 0; i < id_list.length; i++) {
            List<String> list = userMap.get(id_list[i]);
            for (String l : list) {
                for(String t : target) {
                    if(l.equals(t)) answer[i]++;
                }
            }
        }
      
        return answer;
      
    }
  
}
