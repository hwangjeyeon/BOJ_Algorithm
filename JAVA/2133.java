import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 일단 기본적으로 홀수인 경우는 절대 경우의 수가 나오지 않는다. 타일의 크기가 짝수로만 이루어져있기 때문이다
 * 2. 0은 아무것도 안하는 경우인 1가지 경우만 존재하며, 2는 3가지 존재한다
 * 3. 기본적인 점화식은 dp[i] += dp[i-2] * dp[2]이다
 * 4. 여기서 추가적으로 하나를 더 고려해야하는데 현재 인덱스에서 0이상인 동안 4만큼 빼면서 dp[i] = dp[i] + (dp[j] * 2)를 해주면 된다
 * 5. 완성한 dp[n]을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 3; i < n + 1; i++) {
            if(i%2 == 1){
                continue;
            }
            dp[i] += dp[i-2]*dp[2];
            for (int j = i-4; j >= 0; j-=2) {
                dp[i] = dp[i] + (dp[j] * 2);
            }
        }


        bw.write(dp[n]+"");
        
        br.close();
        bw.close();
    }

}
