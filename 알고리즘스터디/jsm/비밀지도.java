import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            tmp = new int[n];
            getBinary(n, arr1[i]);
            getBinary(n, arr2[i]);

            String str = "";
            for(int j = 0; j < n; j++) {
                // System.out.print(tmp[j]);
                if(tmp[j] == 1) str += "#";
                else str += " ";
            } 
            answer[i] = str;
        }  
        return answer;
    }

    static int[] tmp;
    static void getBinary(int n, int val) {

        List<Integer> list = new ArrayList<>();  

        while(val > 0) {
            int r = val % 2;
            list.add(r);

            val /= 2;
        }

        int idx = n - 1;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1) tmp[idx] = list.get(i);
            idx--;            
        }

    }

}
