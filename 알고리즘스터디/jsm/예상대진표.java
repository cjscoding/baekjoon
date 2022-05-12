class Solution {        

    static int answer, size;
    public int solution(int n, int a, int b) {
        answer = 1;
        size = n / 2;
        go(n / 2, a, b);

        return answer;
    }

    static void go(int n, int a, int b) {
        if(!isOk(n, a, b)) {
            go(get(n,a), a, b);
        }   

        while (size != 1) {
            answer++;
            size = size / 2;
        }   
    }

    static boolean isOk(int n, int a, int b) {
        if((a <= n && b > n) || (a > n && b <= n))
            return true;
        return false;
    }

    static int get(int n, int a) {
        size = size / 2;

        if(a <= n) return n - size;
        return n + size;
    }

}
