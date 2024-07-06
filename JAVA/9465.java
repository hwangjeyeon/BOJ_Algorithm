import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 위에는 왼쪽 대각선 아래와 그 왼쪽 값중 큰 값에 자기자신을 더한 것, 아래는 그 반대의 경우이다. 
 * 2. 해당 점화식을 토대로 초기값만 자기자신으로 하고 마지막 n번째 위치에서 위와 아래중 더 큰값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int j = 2; j < n + 1; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
            }

            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");

        }

        br.close();
        bw.close();
    }

}

