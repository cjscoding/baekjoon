class Solution {
    static int N, answer;
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        answer = 0;
        visited = new boolean[N];
        
        go(numbers, target, 0);
        
        return answer;
    }

    static boolean[] visited;
    static void go(int[] num, int t, int idx) {
        
        if(idx == N) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i])
                    sum += num[i];
                else
                    sum -= num[i];
            }
            if(sum == t)
                answer += 1;

            return;    
        }
        
        visited[idx] = true;            
        go(num, t, idx + 1);
        visited[idx] = false;
        go(num, t, idx + 1);
        
    }
}
