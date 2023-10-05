import java.io.*;
import java.util.StringTokenizer;


/**
 * 풀이 과정: 점화식을 뽑아내면 간단히 풀리는 문제, 이런 문제는 연습을 통해 쉽게 뽑아내는 능력을 길러야 할 것 같다.
 * 점화식을 혼자서 완벽하게 뽑아내는데 실패했다. 점화식까지의 규칙은 뽑아냈으나, 점화식으로 전환하는 과정을 성공시키지 못했다 -> 관련 문제를 더 풀어보면서 실력을 키우자
 * 실패했던 풀이들: 
 * 1. 이전 dp와의 숫자 갯수 규칙이 있을 것이라 판단 -> 찾아내지 못함
 * 2. 0다음에는 0또는 1, 1 다음에는 무조건 0이 와야한다는 규칙을 찾아냄 -> 점화식으로 구현하지 못함 -> 반대로 생각했다면 풀렸을 텐데라는 아쉬움...
 * 정답 풀이: 
 * - 거꾸로 생각하면 된다
 * 1. 맨 뒤, 즉 n이 0이면 n-1은 0또는 1이 와도 된다 -> 즉 dp[n-1]은 0이 n에 오는 경우 -> dp[n-1]에는 맨 뒤에만 0이 오고 그 이전 메모이제이션으로 들어있는 모든 값들
 * 2. 맨 뒤, 즉 n이 1이면 n-1이는 무조건 0이 와야한다. 이어서 그 다음 n-2는 0또는 1이 와도 된다 -> 즉 dp[n-2]는 n=1, n-1 = 0이 오는 경우를 말한다
 * 3. 이렇게해서 뽑아낸 점화식은 dp[n] = dp[n-1] + dp[n-2]
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
        dp = new long[n+1];
        br.close();
        if(n <= 2){
            bw.write(1+ "");
        }else{
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            for(int i=4; i<n+1; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
            bw.write(dp[n] + "");
        }
        bw.close();

    }

}
