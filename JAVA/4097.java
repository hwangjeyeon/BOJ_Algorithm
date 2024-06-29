import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 총합산 금액이 int형 범위를 넘어설 수 있으므로 long타입으로 지정해주었따
 * 2. 처음값은 자기자신이고 이전 dp와 비교해서 더 큰값을 넣어준다.
 * 3. 점화식은 다음과 같다. dp[i] = Math.max(money[i] + dp[i-1], money[i]);
 * 4. 마지막에 n만큼 순회해서 초기값이 -10001인 ans와 비교하고 가장 큰 값을 넣어주고 출력하면 정답이 된다. 
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

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            long[] money = new long[n];
            for (int i = 0; i < n; i++) {
                money[i] = Long.parseLong(br.readLine());
            }
            long ans = -10001;
            long[] dp = new long[n];
            dp[0] = money[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(money[i] + dp[i-1], money[i]);
            }

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, dp[i]);
            }
            bw.write(ans+"\n");
        }


        br.close();
        bw.close();
    }


}

