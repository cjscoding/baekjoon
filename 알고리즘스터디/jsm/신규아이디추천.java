public class 신규아이디추천 {
    class Solution {

        public String solution(String new_id) {
            String answer = "";

            // 1단계
            new_id = new_id.toLowerCase();

            // 2단계
            String str = "~`!@#$%^&*()+={}[]:;'\"<>,?/|\\";
            String[] noUse = str.split("");

            for (int i = 0; i < new_id.length(); i++) {
                for (int j = 0; j < str.length(); j++) {

                    if (new_id.contains(noUse[j])) {
                        new_id = new_id.replaceAll("\\" + noUse[j], "");
                    }
                }
            }

            // 3단계
            String[] idArr = new_id.split("");
            int start = 0, end = 0;
            for (int i = 0; i < new_id.length() - 1; i++) {
                if (idArr[i].equals(".") && idArr[i + 1].equals(".")) {
                    idArr[i] = "";
                }
            }

            new_id = "";
            for (int i = 0; i < idArr.length; i++) {
                new_id += idArr[i];
            }

            // 4단계
            if (new_id.startsWith("."))
                new_id = new_id.substring(1);
            if (new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length() - 1);

            // 5단계
            if (new_id.equals(""))
                new_id = "a";

            // 6단계
            if (new_id.length() > 15) {
                new_id = new_id.substring(0, 15);
                if (new_id.endsWith("."))
                    new_id = new_id.substring(0, new_id.length() - 1);
            }
            
            // 7단계
            while (new_id.length() < 3) {
                String lastStr = new_id.substring(new_id.length() - 1);
                new_id += lastStr;
            }

            answer = new_id;
            return answer;
        }
    }
}
