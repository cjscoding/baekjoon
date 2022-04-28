package Lv1;

import java.util.Arrays;

public class 실패율 {
	
	public static void main(String[] args) {
		
//		int[] answer = solution(5, new int[] {2,1,2,6,2,4,3,3});
		int[] answer = solution(4, new int[] {4,4,4,4,4});
		System.out.println(Arrays.toString(answer));
		
	}
	
	
    public static int[] solution(int N, int[] stages) {
        double[][] failureLate = new double[N+1][2];
        int[] answer = new int[N];
        
        for(int j = 1; j <= N; j++) {
            
        	int sum = 0;
            int fail = 0;
            
        	for(int i : stages) {
        		if(j <= i)
        			sum++;
        		if(j == i)
        			fail++;
        	}
        	
//        	System.out.println(j + " : " + fail + "/" + sum);
        	failureLate[j][0] = j;
        	failureLate[j][1] = sum == 0 ? 0 : (double) fail/sum;
        }
        
//        System.out.println(Arrays.deepToString(failureLate));
        
        Arrays.sort(failureLate, (o1, o2) -> {
        	if(o1[1] == o2[1])
        		return Double.compare(o1[0], o2[0]);
        	else
        		return -Double.compare(o1[1], o2[1]);
        });
        
//        System.out.println(Arrays.deepToString(failureLate));
        
        int idx = 0;
        for(int i = 0; i < N+1; i++) {
        	if(failureLate[i][0] == 0) continue;
        	answer[idx] = (int) failureLate[i][0];
        	idx++;
        }

        return answer;
    }
}
