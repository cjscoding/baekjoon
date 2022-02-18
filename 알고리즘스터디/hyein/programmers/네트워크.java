class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++) {
            if(!visited[i]) {
                DFS(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void DFS(int n, int[][] computers) {
        visited[n] = true;

        for(int i = 0; i < computers.length; i++) {
            if(visited[i]) continue;
            if(computers[n][i] == 0) continue;
            if(n == i) continue;

            DFS(i, computers);
        }
    }
}