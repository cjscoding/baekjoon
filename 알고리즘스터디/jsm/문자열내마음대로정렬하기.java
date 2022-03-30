import java.util.*;

class Solution {

    static class Info implements Comparable<Info> {
        String word, pick;

        public Info(String word, String pick) {
            this.word = word;
            this.pick = pick;
        }

        @Override
        public int compareTo(Info o) {            
            if(this.pick.equals(o.pick))
                return this.word.compareTo(o.word);

            return this.pick.compareTo(o.pick);            
        }

    }

    public String[] solution(String[] strings, int n) {

        List<Info> list = new ArrayList<>();
        String[] answer = new String[strings.length];

        for(int i = 0; i < strings.length; i++) {
            String[] str = strings[i].split("");
            list.add(new Info(strings[i], str[n]));
        }
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).word;
            answer[i] = word;
        }

        return answer;

    }
}
