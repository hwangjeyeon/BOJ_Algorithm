import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. DP와 누적합을 이용해서 푸는 문제다
 * 2. max변수와 dp를 arr[0]으로 초기화한다
 * 3. dp[j-1]이 음수면 0을 넣어주고, dp[j] = dp[j-1] + arr[j]로 dp를 갱신, max에는 dp[j]와 max를 비교하여 넣어준다
 * 4. max를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(T*n)
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int[] dp = new int[n];
            int max = arr[0];
            dp[0] = arr[0];
            for (int j = 1; j < n; j++) {
                 if(dp[j-1] < 0){
                     dp[j-1] = 0;
                 }
                 dp[j] = dp[j-1] + arr[j];
                 max = Math.max(max, dp[j]);
            }
            bw.write(max+"\n");
        }

        br.close();
        bw.close();
    }



}

