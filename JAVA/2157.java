import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(nm)
 *
 */

public class Main {

    static int[] white;
    static int[] black;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] score = new int[n+1][n+1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            score[a][b] = Math.max(score[a][b], c);
        }

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[1][1] = 0;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int l = 1; l < j; l++) {
                    if(score[j-l][j] == 0 || dp[i-1][j-l] == Integer.MIN_VALUE){
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-l] + score[j-l][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m + 1; i++) {
            ans = Math.max(dp[i][n], ans);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
