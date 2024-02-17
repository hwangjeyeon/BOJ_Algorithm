import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - DP를 이용하여 해결하였다
 * - 내 이전 왼쪽 수와 오른쪽 수 중 더 큰 값과 자기 자신을 더한 값을 이차원 DP 배열의 자기 인덱스에 저장한다
 * - 이렇게 완성한 결과를 출력하는데 순회를 통해서 n행에서 가장 큰 값을 변수에 담고 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {


    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n+2][n+2];
        dp[1][1] = arr[1][1];
        dp[2][1] = arr[1][1] + arr[2][1];
        dp[2][2] = arr[1][1] + arr[2][2];
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
            }
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[n][i]);
        }

        bw.write(max+"");
        br.close();
        bw.close();
    }

}

