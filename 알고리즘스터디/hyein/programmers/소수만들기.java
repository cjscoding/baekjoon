class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                for(int k = 0; k < nums.length; k++) {
                    if(i != j && j != k && i != k) {
                        if(isPrime(nums[i] + nums[j] + nums[k])) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer / 6;
    }
    
    private boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}