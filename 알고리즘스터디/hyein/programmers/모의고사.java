import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                int length = pattern[j].length;
                if(pattern[j][i % length] == answers[i]) scores[j]++;
            }
        }
        
        int max = 0;
        ArrayList<Integer> students = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(scores[i] > max) {
                students.clear();
                max = scores[i];
                students.add(i);
            }
            else if(scores[i] == max) students.add(i);
        }
        
        Collections.sort(students);
        int[] answer = new int[students.size()];
        for(int i = 0; i < students.size(); i++) {
            answer[i] = students.get(i) + 1;
        }
        return answer;
    }
}