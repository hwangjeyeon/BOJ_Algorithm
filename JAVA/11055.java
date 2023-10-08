import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정: 이번에는 dp[i]를 증가하는 부분수열의 합으로 정해서 풀었다.
 * 1. dp[1] = arr[1]로 초기화하며, arr[i] > arr[j]으로 증가하는 수열 조건 완성, dp[i] <= dp[j]조건으로 합이 더 큰 것을 찾는 메모이제이션 바텀 업 방식의 DP로 풀었다.
 * 2. LIS는 중복되는 값은 무시해야 하며, 입력값이 N이 1000까지 들어오기 때문에 int형은 오버플로우가 발생한다 따라서 long형을 써야한다.
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        dp = new long[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(N == 1){
            bw.write(arr[1] + "");
        }else{
            dp[1] = arr[1];
            long ans = dp[1];
            for(int i=2; i<N+1; i++){
                for(int j=1; j<i; j++){
                    if(arr[i] > arr[j] && dp[i] <= dp[j]) {
                        dp[i] = dp[j];
                    }
                }
                dp[i] += arr[i];
                ans = Math.max(dp[i], ans);
            }
            bw.write(ans + "");
        }
        bw.close();

    }

}
