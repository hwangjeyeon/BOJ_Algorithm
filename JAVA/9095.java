import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 1, 2, 3일 경우 나올 수 있는 경우의 수를 모두 구한다
 * 2. 이때 나오는 규칙은 i-3, i-2, i-1이 된다. 4와 7일 기준으로 테스트 해보면 된다
 * 3. dp[i] = dp[i-3] + dp[i-2] + dp[i-1]이 정답이며, 미리 만들어 두고, 테스트 코드 돌리면서 n인덱스 값을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(T)
 * 공간복잡도: O(n)
 *
 */



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }

        

        br.close();
        bw.close();
    }
}

