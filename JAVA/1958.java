import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 기존 LCS 개념을 확장해 3차원 DP와 3중포문을 돌리면 된다
 * 2. 3개의 문자열이 모두 같을 때 dp[i][j][k] = dp[i-1][j-1][k-1] + 1이 된다
 * 3. 다를 경우, dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]))이 된다.
 * 4. 점화식 연산을 처리 후, 매번 ans를 갱신하고 종료 후 출력해도 되고 아니면 그냥 dp[s1.length()][s2.length()][s3.length()]를 출력해도 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|s1|*|s2|*|s3|)
 * 공간복잡도: O(|s1|*|s2|*|s3|)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        int ans = 0;

        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                for (int k = 1; k < s3.length() + 1; k++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1) && s3.charAt(k-1) == s2.charAt(j-1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                    ans = Math.max(dp[i][j][k], ans);
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }


}
