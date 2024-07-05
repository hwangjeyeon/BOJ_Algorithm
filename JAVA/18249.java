import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 직접 노드를 그려서 4번째 경우까지 확인했을 때, 피보나치 점화식이 나오는 것을 확인할 수 있다.
 *
 * 해결방법:
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
        long[] dp = new long[191230];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 191230; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % (1000000007);
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }

        br.close();
        bw.close();
    }

}

