import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 2중 포문 DP로 풀면 된다
 * 2. 단순히 B면 J, O면 B, J면 O인지 확인하고 맞다면 값을 개인한다
 * 3. 최솟값을 구해야하므로 Integer.MAX_VALUE로 초기화하되, 맨 처음값은 0으로 한다
 * 4. dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j)) 점화식을 통해 값을 갱신한다
 * 5. 만약 dp[n-1]이 Integer.MAX_VALUE라면 ans를 -1로 초기화화고 아니면 dp[n-1]로 값을 갱신한다
 * 6. 완성한 ans를 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = -1;
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[j] + (i - j) * (i - j), dp[i]);
                }else if(arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[j] + (i - j) * (i - j), dp[i]);
                }else if(arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[j] + (i - j) * (i - j), dp[i]);
                }
            }
        }
        if(dp[n-1] == Integer.MAX_VALUE){
            ans = -1;
        }else{
            ans = dp[n-1];
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
