import java.util.*;

class Solution {

    static class Info {
        int idx, num;
        public Info(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Info> q = new LinkedList<>();
        int[] arr = new int[10];

        int max = 0;
        int cnt = 0;
        for(int i = 0; i < priorities.length; i++) {
            arr[priorities[i]]++;
            q.add(new Info(i, priorities[i]));
            if(max < priorities[i]) {
                max = priorities[i];
                cnt = i;
            }
        }
        // System.out.println("max: " + max);
        // System.out.println("cnt: " + cnt);

        for(int i = 0; i < cnt; i++) {
            q.add(q.poll());
        }

        int answer = 0;
        l: for(int i = max; i >= 1; i--) {
            if(arr[i] == 0) continue;
            int size = q.size();
            for(int j = 0; j < size; j++) {
                if(arr[i] == 0) continue;

                Info cur = q.poll();
                System.out.println(i  + " -> idx: " + cur.idx + " num: " + cur.num);
                if(cur.num == i) {
                    answer++;
                    arr[i]--;
                    if(cur.idx == location) break l;
                }
                else q.add(cur);
                System.out.println("answer: " + answer); 
            }

        }
        return answer;
    }
}
