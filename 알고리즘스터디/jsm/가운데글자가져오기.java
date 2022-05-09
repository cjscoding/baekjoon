class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        int half = length / 2;

        if(length % 2 == 0)            
            answer = s.substring(half - 1, half + 1);
        else 
            answer = String.valueOf(s.charAt(half));
        return answer;
    }
}
