// 2차원 누적합 문제.
// 이 문제로 누적합을 처음 알았는데, 완전 신기함!
// 원래라면 N*M을 K번 => O(N * M * K) 의 시간이 걸리는데,
// 누적합으로 구하면 표시할떄 O(K) + 누적합 구할때 O(N * M) = O(K + (N*M))의 시간으로 줄어든다. 엄청나!
class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;

        int[][] sum = new int[N+1][M+1];

        for(int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            switch(type) {
                case 1:
                    sum[r1][c1] -= degree;
                    sum[r1][c2+1] += degree;
                    sum[r2+1][c1] += degree;
                    sum[r2+1][c2+1] -= degree;
                    break;
                case 2:
                    sum[r1][c1] += degree;
                    sum[r1][c2+1] -= degree;
                    sum[r2+1][c1] -= degree;
                    sum[r2+1][c2+1] += degree;
                    break;
            }
        }

        // → 방향 누적합
        for(int i = 0; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                sum[i][j] = sum[i][j-1] + sum[i][j];
            }
        }

        // ↓ 방향 누적합
        for(int i = 0; i <= M; i++) {
            for(int j = 1; j <= N; j++) {
                sum[j][i] = sum[j-1][i] + sum[j][i];
            }
        }

        int answer = 0;
        // 원래 배열과 합침
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = board[i][j] + sum[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        return answer;
    }
}