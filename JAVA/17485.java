import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. DP를 활용하는데, 방향까지 고려해서 해결하면 되는 문제다
 * 2. 점화식은 간단하다. 이전 행에서 주어진 위치에 따른 방향들끼리 비교하면 되는 문제다
 * 3. 이후 마지막 라인에서 가장 작은 열의 값을 정답으로 찾고 출력하면 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m*3)
 * 공간복잡도: O(n*m)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][][] dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 987654321);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(j == 0){
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                }else if(j == m-1){
                    dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + arr[i][j];
                }else{
                    dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][0]) + arr[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[n-1][i][j]);
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
