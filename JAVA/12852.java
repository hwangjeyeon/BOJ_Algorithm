import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. DP문제다. 너무 안풀어서 그런가 조금 어려웠다
 * 2. 그냥 단순하게 탑다운보다는 바텀업으로 풀면된다. dp[i] = dp[i-1] + 1는 모든 경우 가능하며, 조건을 만족하는 경우 dp[i/3] + 1과 현재 값 중 최솟값으로 교체한다
 * 3. dp[i/2] + 1도 동일하게 적용된다
 * 4. 이후 dp[n]을 출력하고 n은 무조건 해당되니 출력한다
 * 5. 이후 now를 n으로 초기화하고 1보다 큰동안 반복하며 현재의 now를 출력한다
 * 6. now는 다음 3가지 조건중 1번 2번 3번 조건 순으로 if-else문을 통해 변경해준다
 * 7. 1번은 now%3 == 0 && dp[now/3] == dp[now]-1 조건을 만족시키면 now/=3, 나머지도 동일하게 now/=2와 now--로 출력한다
 * 8. 이렇게 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        dp = new int[1_000_001];

        for (int i = 2; i < 1_000_001; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3] + 1);
            }
            if(i%2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }
        int now = n;
        bw.write(dp[n]+"\n" + n + " ");
        while(now > 1){
            if(now % 3 == 0 && dp[now/3] == dp[now] - 1){
                now /= 3;
            }else if(now % 2 == 0 && dp[now/2] == dp[now] - 1){
                now /= 2;
            }else{
                now--;
            }
            bw.write(now+" ");
        }


        br.close();
        bw.close();
    }

}
