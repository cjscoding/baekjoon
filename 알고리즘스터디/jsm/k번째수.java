import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] c : commands) {
            int start = c[0] - 1;
            int end = c[1] - 1;
            int target = c[2] - 1;

            if (start == end)
                answer.add(array[start]);
            else {
                List<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(array[i]);
                }
                Collections.sort(list);

                answer.add(list.get(target));
            }
        }
        return answer;
    }
}
