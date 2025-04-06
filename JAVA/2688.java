import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp로 해결하는 문제다.
 * 2. long타입의 2차원 dp로 해결했다. dp[자릿수][시작하는 수]
 * 3. 1자리는 모두 1이다
 * 4. 3중 포문으로 해결할 수 있다. dp[i][j] = dp[i-1][j] ~ dp[i-1][9]까지 라는 점을 이용해야한다
 * 5. 따라사 dp[i][j] += dp[i-1][k]로 3중 포문을 돌면서 값을 갱신한다. k는 j부터 시작하면 된다. 이전 수를 더하면 줄어들지 않는 수이기 때문에 j부터 시작한다
 * 6. 이후 T만큼 입력값에 대해서 dp[n][0] ~ dp[n][9]를 다 합산한다
 * 7. 그리고 그 합산값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(65*10*10)
 * 공간복잡도: O(65*10)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += dp[n][j];
            }
            bw.write(sum+"\n");
        }

        br.close();
        bw.close();
    }

}
