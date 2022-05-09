class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            sum = i % Math.sqrt(i) == 0 ? sum - i : sum + i;
        }

        return sum;
    }
}