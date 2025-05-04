import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1_000_000_009라는 점화식이 나오며, 그 이전에는 1,2, 2, 3, 3, 6의 값을 가진다
 * 2. 이를 이용하여 미리 세팅하고 입력값에 대해 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[100_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for (int i = 7; i < 100_001; i++) {
            dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1_000_000_009;
        }

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(dp[a] + "\n");
        }

        br.close();
        bw.close();
    }
}
