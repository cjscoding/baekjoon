import java.util.*;

class k진수에서소수개수구하기 {
    static boolean[] primes;

    public int solution(int n, int k) {
        int answer = 0;

        char[] number = transform(n, k);
        int idx = 0;
        while(true) {
            while(idx < number.length && number[idx] == '0') idx++;
            if(idx >= number.length) break;

            StringBuilder sb = new StringBuilder();
            while(idx < number.length && number[idx] != '0') {
                sb.append(number[idx++]);
            }

            if(isPrime(Long.parseLong(sb.toString()))) answer++;
        }


        return answer;
    }

    private static char[] transform(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString().toCharArray();
    }

    private static boolean isPrime(long n) {
        if(n == 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}