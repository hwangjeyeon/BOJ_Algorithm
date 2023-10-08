import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정: 이전 11053 방식에서 부등호 하나만 바꿔주면 된다. 11053은 왼쪽부터 자신까지 점차 증가해야 하므로 arr[i] > arr[j]였으나, 여기는 감소해야 하므로 arr[j] < arr[i]가 되어야 한다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */




public class Main {

    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(N == 1){
            bw.write(1 + "");
        }else{
            dp[1] = 1;
            int ans = 0;
            for(int i=2; i<N+1; i++){
                dp[i] = 1;
                for(int j=1; j<i; j++){
                    if(arr[i] < arr[j] && dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                    }
                }
                ans = Math.max(ans,dp[i]);
            }
            bw.write(ans + "");
        }
        bw.close();

    }

}
