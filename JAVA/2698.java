import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 규칙성을 잘 파악하면 되는 문제다
 * 2. 맨뒤에 어떤 비트가 붙느냐에 따라 결과가 달라진다
 * 3. 만약 0이 붙으면 항상 인접한 비트의 개수가 증가하지 않고, 1이 붙으면 이전에 0이었던 인접비트의 개수가 그대로이고 1이면 인접 비트의 개수가 늘어난다
 * 4. 이점을 이용해서 점화식을 세우면 dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1]인 식과 dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j-1][1]이라는 식이 나온다
 * 5. 별도로 dp[i][j][1]일때 j가 0이면 dp[i-1][j][0]만 해당된다 아니면 인덱스 오류난다
 * 6. 이후 n과 k를 받아서 각 dp의 값을 받아 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[101][101][2];
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1];
                    if (j == 0) {
                        dp[i][j][1] = dp[i-1][j][0];
                    }else{
                        dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j-1][1];
                    }
                }
            }
        }

        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            bw.write((dp[n][k][0] + dp[n][k][1]) + "\n");
        }
        
        br.close();
        bw.close();
    }
}
