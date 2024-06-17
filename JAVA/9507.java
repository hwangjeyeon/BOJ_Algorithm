import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 점화식대로 먼저 dp를 만들고 테스트케이스별로 주어진 dp[n]의 값을 출력하면 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(t)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[69];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 69; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4];
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");


        }

        br.close();
        bw.close();
    }



}

