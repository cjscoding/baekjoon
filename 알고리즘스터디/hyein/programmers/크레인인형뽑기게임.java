import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int answer = 0;
        for(int move = 0; move < moves.length; move++) {
            int dollIdx = findDoll(board, moves[move]-1);
            if(dollIdx == -1) continue;
            
            int doll = board[dollIdx][moves[move]-1];
            board[dollIdx][moves[move]-1] = 0;
            
            if(!basket.isEmpty() && basket.peek() == doll) {
                answer += 2;
                basket.pop();
            }
            else basket.push(doll);
        }
        
        return answer;
    }
    
    private int findDoll(int[][] board, int move) {
        int idx = 0;
        while(idx < board.length && board[idx][move] == 0) idx++;
        
        if(idx == board.length) return -1;
        else return idx;
    }
}