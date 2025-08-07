import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp 써서 풀 수있는 문제다
 * 2. 팩토리얼 값을 계산한다음, 오버플로우를 방지하기 위해 0이 뒷자리에 나오면 0을 제거하는 방식으로 풀었다
 * 3. 또한 동일하게 오버플로우 발생하지 않도록 10^12을 나눴고, 10만을 모듈러 연산해서 최종 5자리만 출력하도록 풀었다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    private static final long MOD = 1_000_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        long ans = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] * i;
            while(dp[i] % 10 == 0){
                dp[i] /= 10;
            }
            dp[i] %= MOD;
        }
        ans = dp[n] % 1_000_00;

        bw.write(String.format("%05d", ans));
        
        br.close();
        bw.close();
    }
}
