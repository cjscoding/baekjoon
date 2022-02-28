import java.util.*;

class Solution {
    static class Result {
        String id, text;

        public Result(String id, String text) {
            this.id = id;
            this.text = text;
        }

    }

    public String[] solution(String[] record) {

        List<Result> list = new ArrayList<>();
        Map<String, String> info = new HashMap<>();

        for(int i = 0; i < record.length; i++) {

            // split() 사용해서 배열 만들기
            String[] str = record[i].split(" ");
            //System.out.println(str[0] +" "+ str[1] +" "+ str[2]);

            if(str[0].equals("Enter")) {
                info.put(str[1], str[2]);
                list.add(new Result(str[1], "님이 들어왔습니다."));
            }

            else if(str[0].equals("Change")) {
                info.replace(str[1], str[2]);
            }


            else if(str[0].equals("Leave")) {
                list.add(new Result(str[1], "님이 나갔습니다."));
            }

        }

        String[] answer = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            String id = list.get(i).id;
            String text = list.get(i).text;
            answer[i] = info.get(id) + text;
        }

        return answer;
    }

}
