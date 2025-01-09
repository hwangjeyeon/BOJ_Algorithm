import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 선택지는 두가지가 있다. 가장 큰 막대와 가장 작은 막대를 왼쪽 오른쪽 가운데중 한 곳에 두는 것을 선택하는 것이다
 * 2. 가장 큰 막대를 선택할 경우, 고민할 거리가 많아진다. 따라서 가장 작은 막대인 길이가 1인 막대를 놓는다고 가정한다
 * 3. 1인 막대를 왼쪽에 넣는다면, 변경되는 값은 막대의 개수와 왼쪽에서 보이는 막대의 개수일 것이다.
 * 4. 1인 막대를 오른쪽에 넣는다면 변경되는 값은 막대의 개수와 오른쪽에서 보이는 막대의 개수일 것이다
 * 5. 1인 막대를 중간에 넣는다면 변경되는 값은 막대의 개수일 것이다. 그리고 이것은 양끝을 제외한 개수일 것이다
 * 6. 이것을 정리하면 다음과 같은 점화식으로 나타낼 수 있다 dp[i][j][k] += dp[i-1][j][k-1] + dp[i-1][j-1][k] + (dp[i-1][j][k]*(i-2))
 * 7. 이렇게 미리 DP식을 구해둔 뒤, 테스트케이스에 맞춰서 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(21^3)
 * 공간복잡도: O(21^3)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][][] dp = new long[21][21][21];
        dp[1][1][1] = 1;
        for (int i = 2; i < 21; i++) {
            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < 21; k++) {
                    dp[i][j][k] += dp[i-1][j][k-1] + dp[i-1][j-1][k] + (dp[i-1][j][k]*(i-2));
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write(dp[n][l][r]+"\n");
        }

        br.close();
        bw.close();
    }

}
