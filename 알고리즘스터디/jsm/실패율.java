import java.util.*;

class Solution {
    
    static class Stage implements Comparable<Stage> {
        int stageN;
        Double failRate;
        
        public Stage(int stageN, Double failRate) {
            this.stageN = stageN;
            this.failRate = failRate;
        }
        
        // 나 - 비교대상 : 오름차순
        // 비교대상 - 나 : 내림차순
        @Override
        public int compareTo(Stage o) {
            if(this.failRate == o.failRate) 
                return this.stageN - o.stageN;
            
            else return o.failRate.compareTo(this.failRate);
        }
    }
    
    // N: 전체 스테이지,  stages: 유저별 진행중인 스테이지
    public int[] solution(int N, int[] stages) {
                
        int[] clearArr = new int[N + 1]; // 스테이지별 클리어한 유저 수
        for(int i = 0; i < stages.length; i++) {
            int stage = stages[i];
            for(int j = 0; j < stage; j++) {
                clearArr[j]++;
            }
        }
        
        for(int i = 0; i < clearArr.length; i++) {
            System.out.println(clearArr[i]);
        }
        
        List<Stage> list = new ArrayList<>();
        double failRate = 0.0;
        for(int i = 1; i < clearArr.length; i++) {
            if(clearArr[i - 1] == 0) list.add(new Stage(i, 0.0));
            else {
                failRate = (double)(clearArr[i - 1] - clearArr[i]) / clearArr[i - 1];
                list.add(new Stage(i, failRate));
            }
        }
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            Stage s = list.get(i);
            System.out.println(s.stageN + " , " + s.failRate);
        }
        
        int[] answer = new int[N];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stageN;
        }
        return answer;
    }
}
