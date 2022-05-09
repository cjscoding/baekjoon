import java.util.*;

class Solution {
    
    public List<Integer> solution(int[] fees, String[] records) {
             
        int N = records.length;
        
        // 1. 차량번호에 따른 입출차시간 저장
        HashMap<String, List<String>> info = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String[] tmp = records[i].split(" ");
            String key = tmp[1], value = tmp[0];
            if(!info.containsKey(key)) {
                info.put(key, new ArrayList<String>());
            }           
            info.get(key).add(value);
        }
           
        // 2. 시간 계산
        HashMap<Integer, Integer> time = new HashMap<>();
        info.forEach((key, value) -> {
            int hour = 0, min = 0;
            
            // value의 size가 홀수일 경우 출차시간 추가
            if(value.size() % 2 == 1)
                info.get(key).add("23:59");
            
            for(int i = 0; i < value.size(); i += 2) {
                String[] in = info.get(key).get(i).split(":");
                String[] out = info.get(key).get(i + 1).split(":");
                int h = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
                int m = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
                
                if(m < 0) {
                    m += 60;
                    h -= 1;
                }
                hour += h;
                min += m;
            }
            time.put(Integer.parseInt(key), hour * 60 + min);       
        });
        
        List<Integer> sort = new ArrayList<>(time.keySet());
        Collections.sort(sort);
        
        List<Integer> answer = new ArrayList<>();
        sort.forEach((key) -> {           
            int fee = 0;
            int value = time.get(key);
            // 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구
            if(value <= fees[0]) answer.add(fees[1]);            
            else { // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림                
                fee += fees[1];                
                if((value - fees[0]) % fees[2] != 0)
                    fee += ((value - fees[0]) / fees[2] + 1) * fees[3];
                else fee += ((value - fees[0]) / fees[2]) * fees[3];
                
                answer.add(fee);
            }
        });
        
        return answer;
    }
}
