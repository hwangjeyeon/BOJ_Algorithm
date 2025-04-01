import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. long타입의 dp배열 이용해서 피보나치 수열 정리하면 된다
 * 2. 입력받은 n위치의 dp값을 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 46; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int n = Integer.parseInt(br.readLine());
        bw.write(dp[n]+"");

        br.close();
        bw.close();
    }

}
