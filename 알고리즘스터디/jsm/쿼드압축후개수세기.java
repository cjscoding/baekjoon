class Solution {
    
    static int one, zero;
    
    public int[] solution(int[][] arr) {
        one = 0;
        zero = 0;
 
        quad(arr, arr.length, 0, 0);
        
        return new int[]{zero, one};
    }
        
    static void quad(int[][] arr, int size, int r, int c){     
        int val = arr[r][c];
        
        // 압축 가능한지 체크
        if(isOk(arr, size, r, c, val)) {
            // 0인지 1인지 판단
            check(val);
            return; // 재귀
        }
        
        // 압축 불가능한 경우 size 감소
        size = size / 2;
        
        quad(arr, size, r, c);
        quad(arr, size, r, c + size);
        quad(arr, size, r + size, c);
        quad(arr, size, r + size, c + size);

    }
    
    static boolean isOk(int[][] arr, int size, int row, int col, int val) {
        for(int r = row; r < row + size; r++) 
            for(int c = col; c < col + size; c++)
                if(arr[r][c] != val) return false;
        return true;
    }
    
    static void check(int val) {
        if(val == 1) one++;
        else zero++;
    }
}
