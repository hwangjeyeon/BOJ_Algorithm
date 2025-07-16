import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp[i]를 arr[i]로 끝나는 증가하는 부분 수열의 개수로 정의하면 미리 1로 초기화하고 arr[i] < arr[j]일 때 
 * 부분 수열을 이어받도록 하면 정답이 된다
 * 
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    private static final long MOD = 998_244_353;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[5001];
        Arrays.fill(dp, 1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] += dp[j];
                    dp[i] %= MOD;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(dp[i]+" ");
        }

        br.close();
        bw.close();
    }

}
