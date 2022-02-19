import java.util.*;

class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> in = new HashMap<>();
        TreeMap<String, Integer> times = new TreeMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");
            if(input[2].equals("IN")) {
                String[] time = input[0].split(":");
                int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                in.put(input[1], minute);
            }
            else if(input[2].equals("OUT")) {
                String[] time = input[0].split(":");
                int endTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                int startTime = in.get(input[1]);
                times.put(input[1], times.getOrDefault(input[1], 0) + (endTime - startTime));
                in.remove(input[1]);
            }
        }

        int endTime = 23 * 60 + 59;
        for(String car : in.keySet()) {
            int startTime = in.get(car);
            times.put(car, times.getOrDefault(car, 0) + (endTime - startTime));
        }


        int[] answer = new int[times.size()];
        int idx = 0;
        for(String car : times.keySet()) {
            int time = times.get(car);
            int fee = fees[1];

            if(time > fees[0]) {
                time -= fees[0];
                fee += Math.ceil((double)time / fees[2]) * fees[3];
            }

            answer[idx++] = fee;
        }

        return answer;
    }
}