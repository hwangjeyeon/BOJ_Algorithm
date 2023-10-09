import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * dp[i] = i개 살때의 최대값,
 *
 * dp[2] = arr[2];
 * dp[2] = arr[1] + arr[1];
 *
 * dp[3] = arr[3];
 * dp[3] = arr[2] + arr[1];
 * dp[3] = arr[1] + arr[1] + arr[1];
 *
 * dp[4] = arr[4]
 * dp[4] = arr[3] + arr[1]
 * dp[4] = arr[2] + arr[1] + arr[1]
 * dp[4] = arr[1] + arr[1] + arr[1] + arr[1]
 *
 * dp[i] = Math.max(dp[i], arr[j]+dp[i-j])
 * 1. 각 장을 살때를 dp 메모이제이션 바텀업 방식으로 풀어준다.
 * 2. 이때 각 목표 N을 살 때를 생각해보면 dp[i] = Math.max(dp[i]...) 을 통해 dp[i]에 최댓값을 계속 넣어준다
 * 3. 내가 1장 살때부터 i장 살때를  arr[j]라고 하고 그때 나는 i-j장 살 수 있기 때문에 i-j장 살 수 있는 방법 중 최댓값인 dp[i-j]을 더해서 비교하는 방식으로 가장 비싼 경우를 발견한다
 *
 * 처음 내가 생각했던 방식이 틀려서 힌트를 봤다.. dp에서 점화식 뽑아내는 과정은 정말 많은 노력을 해야될 것 같다...
 * 시간복잡도: O(N^2)
 * 공간복잡도: O(N)
 *
 */




public class Main {

    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        if(N == 1){
            bw.write(N*arr[1] + "");
        }else{
            dp[1] = arr[1];
            for(int i=2; i<N+1; i++){
                for(int j=1; j<=i; j++){
                    dp[i] = Math.max(dp[i], arr[j]+dp[i-j]);
                }
            }

            bw.write(dp[N] + "");
        }
        bw.close();


    }

}
