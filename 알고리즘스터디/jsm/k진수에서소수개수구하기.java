class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 진수 변환 -> long 타입으로
        String val = Long.toString(n, k);

        // 소수 찾기
        String[] nums = val.split("0");
        for(String num : nums) {
            if(num.equals("")) continue;
            if(isPrime(num)) {
                if(val == num || val.contains("0" + num + "0") 
                   || val.contains(num + "0") || val.contains("0" + num)) answer++;
            }
        }
        return answer;
    }

    static boolean isPrime(String num) {
        long val = Long.parseLong(num);

        if(val < 2) return false;
        if(val == 2) return true;

        for(int i = 2; i <= Math.sqrt(val); i++)
            if(val % i == 0) return false;

        return true;
    }
}
