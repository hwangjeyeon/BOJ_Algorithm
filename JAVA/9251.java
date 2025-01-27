import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LCS 개념을 알고 있으면 쉽게 풀 수 있는 문제다
 * 2. 두 문자을 두고, 각 자릿수를 이중포문으로 모두 비교한다
 * 3. 같다면 dp[i-1][j-1] +1을 하고 같지 않다면 dp[i-1][j]와 dp[i][j-1] 중 더 큰 값으로 한다
 * 4. 최대길이를 구해야하므로 초기값이 0인 max 변수를 선언한 다음 비교해서 최댓값으로 갱신한다
 * 5. 완성한 max를 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int n = s1.length();
        int m = s2.length();
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }


        bw.write(max+"");
        
        br.close();
        bw.close();
    }
}
