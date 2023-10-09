import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정:
 * - 이전 11052 문제와 비슷하다 -> max를 min으로 바꾸고 dp[i]를 두번째 for문에 들어오기 전에 목표 i만큼 들어있는 카드팩에서 뽑는 경우인 dp[i] = arr[j]로 초기화해준다
 * dp[i] = Math.min(dp[i], arr[j]+dp[i-j])
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
                dp[i] = arr[i];
                for(int j=1; j<i; j++){
                    dp[i] = Math.min(dp[i], arr[j]+dp[i-j]);
                }
            }

            bw.write(dp[N] + "");
        }
        bw.close();


    }

}
