class Solution {
    public int solution(int[] numbers) {
        // 진짜 말도 안되는 풀이를 발견함
        int answer = 45;
        for(int i : numbers) {
            answer -= i;
        }

        // 나는.. 이렇게 풀었는데 말이다...
        boolean[] isInput = new boolean[10];
        for(int i = 0; i < numbers.length; i++) {
            isInput[numbers[i]] = true;
        }
        
        int answer = 0;
        for(int i = 0; i < 10; i++) {
            if(isInput[i]) continue;
            answer += i;
        }
        return answer;
    }
}