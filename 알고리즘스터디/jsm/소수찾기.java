import java.util.*;
class Solution {
    static int answer, N;
    static List<Integer> list;
    static String[] input;
    public int solution(String numbers) {        
        answer = 0;
        N = numbers.length();
        list = new ArrayList<>();
        input = numbers.split("");
        boolean[] visited = new boolean[N];
        String[] result;        
        
        for(int i = 1; i <= numbers.length(); i++) {
            result = new String[i];
            go(result, visited, i, 0);
        }
        return answer;
    }
    
    static void go(String[] result, boolean[] visited, int R, int idx) {
        if(idx == R) {
            int res = get(result);
            
            // 소수 판별 & 존재 여부
            if(isPrime(res) && !list.contains(res)) {
                list.add(res);
                answer++;
            }   
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                result[idx] = input[i];
                
                visited[i] = true;
                go(result, visited, R, idx + 1);
                visited[i] = false;
            }
        }
    }
    
    static int get(String[] result) {
        String res = "";
        for(String r : result) {
            res += r;
        }
        return Integer.parseInt(res);
     }
        
    static boolean isPrime(int res) {
        if(res < 2) return false;
        if(res == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(res); i++)
            if(res % i == 0) return false;
        return true;
    }
    
}
