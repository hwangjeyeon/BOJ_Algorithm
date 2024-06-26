import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 1,2,5,7원을 사용해서 만들 수 있는 최소이므로 현재 숫자의 1,2,5,7 이전의 숫자들과 비교해서 가장 작은 수에다가 +1을 하면 정답이 된다.
 * 2. 이전 선택들에다가 1,2,5,7을 한번만 더하는 경우가 최소가 되기 떄문이다
 * 3. 점화식: dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7])))+1; 
 * 4. 1~7까지는 미리 초기화해두어야한다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;
        for (int i = 8; i < n + 1; i++) {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7])))+1;
        }


        bw.write(dp[n]+"");


        br.close();
        bw.close();
    }


}

