class Solution {
    public String solution(String[] seoul) {
        int position = -1;
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                position = i;
                break;
            }
        }
        
        String answer = "김서방은 " + position + "에 있다";
        return answer;
    }
}