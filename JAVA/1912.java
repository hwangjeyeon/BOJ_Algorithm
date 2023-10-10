import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 체인으로 옆을 잇는 생각을 통해서 풀었다.
 * - dp[i]는 dp[i-1]+arr[i] 즉 현재의 값과 이전까지 이어진 체인의 값을 현재의 arr[i]와 비교해서 더 큰 것을 넣어준다
 * - 따라서 점화식은,
 *         dp[i] = Math.max(arr[i]+dp[i-1], arr[i]);
 * 1. 위 과정을 통해서 지금까지 이어온 값이 현재보다 작으면 그 체인을 끊어버리고 현재 값으로 초기화 해버리는 점화식을 도출해내었다
 * 2. 그리고 ans의 값과 현재 dp[i]를 Math.max로 비교하여 더 큰 값을 ans에 넣는다
 * 3. 최종 ans를 출력한다
 *
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new long[n+1];
        int[] arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(n == 1){
            bw.write(arr[1] + "");
        }else{
            dp[1] = arr[1];
            long ans = dp[1];
            for(int i=2; i<n+1; i++){
                dp[i] = Math.max(arr[i]+dp[i-1], arr[i]);
                ans = Math.max(dp[i], ans);
            }
            bw.write(ans + "");
        }

        bw.close();

    }

}
