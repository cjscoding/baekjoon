import java.util.*;
class Solution {
    static int[][] arr;
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        
        arr = new int[rows][columns]; 
        
        // arr 배열 초기화
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                arr[r][c] = r * columns + c + 1;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        // queries 만큼 실행
        for(int[] q : queries) {
            int[][] tmp = new int[rows][columns]; // 임시 저장 배열

            int r1 = q[0] - 1, c1 = q[1] - 1;
            int r2 = q[2] - 1, c2 = q[3] - 1;
            
            int min = go(tmp, r1, c1, r2, c2);
            answer.add(min);
            
        }

        return answer;
    }
    
    static int go(int[][] tmp, int r1, int c1, int r2, int c2) {
        
        int min = arr[r1][c1];
        
        // section 1: r1 고정
        for(int c = c1; c < c2; c++) {
            min = Math.min(min, arr[r1][c]);
            tmp[r1][c + 1] = arr[r1][c];
        }
        
        // section 2: c2 고정
        for(int r = r1; r < r2; r++) {
            min = Math.min(min, arr[r][c2]);
            tmp[r + 1][c2] = arr[r][c2];
        }
        
        // section 3: r2 고정
        for(int c = c2; c > c1; c--) {
            min = Math.min(min, arr[r2][c]);
            tmp[r2][c - 1] = arr[r2][c];
        }
        
        // section 4: c1 고정
        for(int r = r2; r > r1; r--) {            
            min = Math.min(min, arr[r][c1]);
            tmp[r - 1][c1] = arr[r][c1];
        }
        
        // 바뀐 부분 arr에 저장
        for(int r = r1; r < r2 + 1; r++) {
            for(int c = c1; c < c2 + 1; c++) {
                if(tmp[r][c] != 0)
                    arr[r][c] = tmp[r][c];
            }
        }
        
        return min;
    }
}
