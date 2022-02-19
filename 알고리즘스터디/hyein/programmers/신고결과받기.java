import java.util.*;

class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> ids = new HashMap<>();
        for(int i = 0; i < id_list.length; i++) {
            ids.put(id_list[i], i);
        }

        HashMap<String, HashSet<String>> map = new HashMap<>();

        for(int i = 0; i < report.length; i++) {
            String[] input = report[i].split(" ");
            HashSet temp = map.getOrDefault(input[1], new HashSet<>());
            temp.add(input[0]);
            map.put(input[1], temp);
        }

        int[] answer = new int[id_list.length];
        for(String id : map.keySet()) {
            HashSet<String> temp = map.getOrDefault(id, new HashSet<>());
            if(temp.size() < k) continue;

            for(String reportId : temp) {
                int idx = ids.get(reportId);
                answer[idx]++;
            }
        }

        return answer;
    }
}