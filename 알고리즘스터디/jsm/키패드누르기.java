import java.util.*;

class Solution {

    static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static HashMap<Integer, Point> hm;
    static String answer;
    public String solution(int[] numbers, String hand) {

        answer = "";

        // 00 01 02
        // 10 11 12
        // 20 21 22
        // 30 31 32

        int n = 1;
        hm = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Point p = new Point(i,  j);
                hm.put(n, p);
                n++;
            }
        }
        hm.put(0, new Point(3, 1));

        L = new Point(3, 0);
        R = new Point(3, 2);
        go(numbers, hand);

        return answer;
    }

    static Point L, R;
    static void go(int[] n, String h) {

        for(int i = 0; i < n.length; i++) {
            // 1, 4, 7 -> L 출력
            if(n[i] == 1 || n[i] == 4 || n[i] == 7) {
                answer += "L";
                L = hm.get(n[i]);
            }
            // 3, 6, 9 -> R 출력
            else if(n[i] == 3 || n[i] == 6 || n[i] == 9) {
                answer += "R";
                R = hm.get(n[i]);
            }
            // 그 외 -> 거리 계산해서 비교
            else {
                Point cur = hm.get(n[i]);
                int gapL = Math.abs(cur.r - L.r) + Math.abs(cur.c - L.c);
                int gapR = Math.abs(cur.r - R.r) + Math.abs(cur.c - R.c);

                // 만약 같은 거리라면, h 확인
                if(gapL == gapR) {
                    // left -> L
                    if(h.equals("left")) {
                        answer += "L";
                        L = hm.get(n[i]);
                    }
                    // right -> R 
                    else if(h.equals("right")) {
                        answer += "R";
                        R = hm.get(n[i]);
                    }
                }
                else if(gapL > gapR) {
                    answer += "R";
                    R = hm.get(n[i]);
                }
                else if(gapL < gapR) {
                    answer += "L";    
                    L = hm.get(n[i]);
                }
            }

        }

    }
}
