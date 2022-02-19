class 양궁대회 {
    static int[] answer;
    static int max;

    public int[] solution(int n, int[] info) {
        max = 0;
        answer = new int[11];
        DFS(0, n, new int[11], info);

        if(max == 0) {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }

    private static void DFS(int idx, int n, int[] me, int[] info) {
        if(idx == 10) {
            // 1. 총 점수 구하기
            int myScore = 0;
            int yourScore = 0;
            for(int i = 0; i < 11; i++) {
                if(me[i] > info[i]) myScore += (10 - i);
                else if(me[i] < info[i]) yourScore += (10 - i);
                else if(me[i] == info[i] && me[i] != 0) yourScore += (10 - i);
            }

            // 2. 내가 질 경우 pass
            if(myScore <= yourScore) return;
            // 3. 최고점이 아니라면 pass
            if(myScore - yourScore < max) return;

            // 4. 최고점 갱신했을때는 리턴
            if(myScore - yourScore > max) {
                max = myScore - yourScore;
                answer = me;
                if(n != 0) answer[10] += n;
                return;
            }

            // 5. 같을때는 더 낮은 점수를 찾음
            boolean isLow = false;
            for(int i = 10; i >= 0; i--) {
                if(me[i] == answer[i]) continue;
                if(me[i] > answer[i]) {
                    isLow = true;
                }
                break;
            }

            if(isLow) {
                answer = me;
                if(n != 0) answer[10] += n;
            }

            return;
        }

        int[] next = new int[11];
        for(int i = 0; i < 11; i++) {
            next[i] = me[i];
        }
        DFS(idx + 1, n, next, info);

        if(info[idx] + 1 <= n) {
            next[idx] = info[idx] + 1;
            DFS(idx + 1, n - (info[idx] + 1), next, info);
        }
    }
}