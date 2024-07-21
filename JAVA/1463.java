import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 점화식만 잘 짜면 된다
 * 2. 먼저 3번째 경우를 한다고 생각하고 dp[i]에 dp[i-1] + 1을 해주자
 * 3. 2번의 점화식이 나오는 이유는 이전 값에서 -1을 하는 한번의 경우를 더하는 것이기 때문이다
 * 4. 이어서 2와 3이 동시에 나오는 6으로 나누어 떨어지는 경우 dp[i/3] + 1과 dp[i]를 비교하고, 이어서 dp[i/2] + 1를 비교하여 가장 작은 것을 넣어주자
 * 5. 아닌 경우 3, 또 아닌 경우 2와 나누어 떨어지는지 확인하고 각각 위 식을 하나씩 가져와서 비교해준다
 * 6. 완성한 dp의 dp[n]을 출력하면 정답이 된다.
 *
 * 해결방법:
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
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 1000001; i++) {
            dp[i] = dp[i-1] + 1;
            if(i%6 == 0){
                dp[i] = Math.min(Math.min(dp[i/3] + 1, dp[i]),dp[i/2]+1);
            }else if(i%3== 0){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }else if(i%2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
        }

        bw.write(dp[n]+"");

        br.close();
        bw.close();
    }

}

