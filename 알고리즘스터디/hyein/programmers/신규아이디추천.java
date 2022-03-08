class Solution {
    public String solution(String new_id) {
        // 1. 대문자를 소문자로 치환
        String answer = new_id.toLowerCase();
        
        // 2. 특수문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3. 마침표 제거
        answer = answer.replaceAll("\\.+", ".");
        
        // 4. 처음이나 끝 마침표 제거
        answer = answer.replaceAll("^[.]|[.]$", "");
        
        // 5. 빈 문자열이라면 'a' 추가
        if(answer.equals("")) answer = "a";

        // 6. 15글자 제한
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        // 7. 2자 이하일때
        if(answer.length() <= 2) {
            char last = answer.charAt(answer.length()-1);
            int size = 3 - answer.length();
            for(int i = 0; i < size; i++) {
                answer += last;
            }
        }
        return answer;
    }
}