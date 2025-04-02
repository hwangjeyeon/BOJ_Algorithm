import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 3가지 방향이 있다. 오른쪽, 아래, 우하대각선 방향이다
 * 2. dp를 이용해서 앞으로 나아가는 3가지 방향의 반대 방향을 비교해서 가장 큰값을 선택한 뒤 현재 위치의 배열값을 더하면된다
 * 3. 단 맨 좌측과 맨 상측은 각각 위, 좌 한가지 방향씩만 탐색하면된다
 * 4. 미리 맨 좌측과 상측을 갱신해주고, 1부터 시작하는 n,m 순회를 통해 dp를 최댓값으로 갱신한다
 * 5. 최조 도착지인 dp[n-1][m-1]의 값을 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }

        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1],(Math.max(dp[i-1][j], dp[i][j-1]))) + arr[i][j];
            }
        }

        bw.write(dp[n-1][m-1] + "");

        br.close();
        bw.close();
    }

}
