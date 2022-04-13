import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>();
        res = new int[2];
        set = new HashSet<>();
        comb(numbers, 0, 0);

        for (Integer s : set) {
            // System.out.println(s);
            answer.add(s);
        }
        Collections.sort(answer);
        return answer;
    }

    static int[] res;
    static Set<Integer> set;

    // 조합
    static void comb(int[] nums, int start, int idx) {
        if (idx == 2) {
            int tmp = 0;
            for (int r : res) {
                tmp += r;
                // System.out.print(r);
            }
            set.add(tmp);
            // System.out.println();
            return;
        }

        for (int i = start; i < nums.length; i++) {
            res[idx] = nums[i];
            comb(nums, i + 1, idx + 1);
        }
    }
}
