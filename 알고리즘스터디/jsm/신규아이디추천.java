public class 신규아이디추천 {
    class Solution {

        public String solution(String new_id) {
            String answer = "";

            // 1단계: 모든 대문자를 대응되는 소문자로 치환
            new_id = new_id.toLowerCase();

            // 2단계: 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
            String str = "~`!@#$%^&*()+={}[]:;'\"<>,?/|\\";
            String[] noUse = str.split("");
            // for(int j = 0; j < str.length(); j++) {
            // System.out.println(noUse[j]);
            // }

            for (int i = 0; i < new_id.length(); i++) {
                for (int j = 0; j < str.length(); j++) {
                    // System.out.println(j);

                    if (new_id.contains(noUse[j])) {
                        // Dangling meta character '+' near index 0 -> 앞에 // 붙여야함
                        new_id = new_id.replaceAll("\\" + noUse[j], "");
                    }
                }
            }

            // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            String[] idArr = new_id.split("");
            int start = 0, end = 0;
            for (int i = 0; i < new_id.length() - 1; i++) {
                // String tmp = String.valueOf(new_id.charAt(i));
                if (idArr[i].equals(".") && idArr[i + 1].equals(".")) {
                    idArr[i] = "";
                }
            }

            new_id = "";
            for (int i = 0; i < idArr.length; i++) {
                new_id += idArr[i];
            }

            // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
            if (new_id.startsWith("."))
                new_id = new_id.substring(1); // 인덱스 하나 쓸떄는 1, 2, 3.. 순
            if (new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length() - 1); // 0 ~ 14 까지 자르기

            // 5단계: 빈문자열이면 a
            if (new_id.equals(""))
                new_id = "a";

            // 6단계: 15글자 초과 자르기
            // System.out.println(new_id.length());
            if (new_id.length() > 15) {
                new_id = new_id.substring(0, 15);
                if (new_id.endsWith("."))
                    new_id = new_id.substring(0, new_id.length() - 1); // 마지막 문자 . 인지 확인
            }
            // 7단계: 3자리 이하면 마지막 복사
            // System.out.println(new_id.substring(new_id.length() - 1));
            while (new_id.length() < 3) {
                String lastStr = new_id.substring(new_id.length() - 1);
                new_id += lastStr;
            }

            // System.out.println(new_id);

            answer = new_id;
            return answer;
        }
    }
}
