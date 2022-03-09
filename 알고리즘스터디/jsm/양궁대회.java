class Solution {

    // {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0} : 점수 형태
    static int m = 11;
    public int[] solution(int n, int[] info) {
        
        ryan = new int[m];
        max = 0;
        min = 987654321;
        
        back(n, info, 0, 0);
    
        return result;
    }
    
    static int ryan[], max, min, result[] = {-1};
    static void back(int n, int[] apeach, int start, int cnt) {
        
        if(cnt == n) {
            int a = 0, r = 0;
            
            // k 점수에 더 많이 맞추면 k점을 가져감
            for(int i = 0; i < n; i++) {                              
                int score = m - 1 - i;
                
                if(ryan[i] == 0 && apeach[i] == 0) continue; // 둘다 한발도 못맞추면 둘다 0점
                
                if(ryan[i] <= apeach[i]) a += score; // 동일한 개수를 맞추거나 어피치가 더 높은 경우
                
                if(ryan[i] > apeach[i]) r += score; // 라이언이 더 높은 경우               
            }
            
            
            if(r > a) { // 라이언이 이길 경우
                int gap = Math.abs(r - a);
                if(max < gap) { // 가장 큰 점수 차이일 경우
                    max = gap;
                    // for(int i = 0 ; i < m; i++) { // 결과값으로 저장
                    //     result[i] = ryan[i];
                    // }
                    result = ryan.clone();

                }
                
                if(max == gap) { // 가장 큰 점수 차이의 경우 중
                    // 작은 점수가 많은 경우
                    // for (int i = 0; i < m; i++) { 
                    //     if(ryan[i] < result[i]) {
                    //         result = ryan.clone();
                    //     }
                    // }
                    for (int i = m - 1; i >= 0; i--) { 
                        if(ryan[i] > result[i]) {
                            result = ryan.clone();
                        } 
                        else if(ryan[i] < result[i]) break;
                    }
                }          
            }
            return;
        }
        
        for(int i = start; i < m; i++) { // 중복 조합 
            // m - i 점수판에 apeach[i] 개
            ryan[i]++;
            back(n, apeach, i, cnt + 1);
            ryan[i]--;
        }
        
    }
}
