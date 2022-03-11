class Solution {
    String[][] keypad = {
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"},
        {"*", "0", "#"}
    };
    
    public String solution(int[] numbers, String hand) {
        String[] hands = new String[numbers.length];
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int i = 0; i < numbers.length; i++) {
            int[] next = findPosition(Integer.toString(numbers[i]));
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                hands[i] = "L";
                left = next;
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                hands[i] = "R";
                right = next;
            }
            else {
                int leftDist = Math.abs(left[0] - next[0]) + Math.abs(left[1] - next[1]);
                int rightDist = Math.abs(right[0] - next[0]) + Math.abs(right[1] - next[1]);
                if(leftDist < rightDist) {
                    hands[i] = "L";
                    left = next;
                }
                else if(leftDist > rightDist) {
                    hands[i] = "R";
                    right = next;
                }
                else {
                    if(hand.equals("right")) {
                        hands[i] = "R";
                        right = next;
                    }
                    else {
                        hands[i] = "L";
                        left = next;
                    }
                }
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(String h : hands) answer.append(h);
        return answer.toString();
    }
    
    private int[] findPosition(String value) {
        int[] next = new int[2];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                if(keypad[i][j].equals(value)) {
                    next[0] = i;
                    next[1] = j;
                    return next;
                }
            }
        }
        
        return next;
    }
}