import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. DP를 활용하는 문제다. 처음에는 1차원을 생각했는데, 점화식이 쉽게 뽑히지 않았다
 * 2. 2차원 DP를 활용하는 문제다. 각 숫자에서 1,2,3인 경우의 수를 합해서 출력하면 되는 문제였다
 * 3. 1~3까지는 1로 통일되며 이후부터는 1,2,3각각 i-1, i-2, i-3번째 1, 1+2, 1+2+3한 결과를 누적하면 된다
 * 4. 테스트케이스동안 n이 주어지면 그 n번째의 1,2,3의 값을 합해서 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int sum = dp[n][1] + dp[n][2] + dp[n][3];
            bw.write(sum +"\n");
        }
        
        br.close();
        bw.close();
    }

}
