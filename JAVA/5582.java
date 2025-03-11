import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LCS 복기 문제다. LCS에 대한 개념을 적용하고 최대길이 구해서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(|S1|*|S2|)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int ans = 0;
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

}
