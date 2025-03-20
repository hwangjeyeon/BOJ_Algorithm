import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp로 해결할 수 있는 문제다
 * 2. 다만 방향이 오, 왼, 아래 3방향이라서 조금 신경써야할 부분이 많다
 * 3. 대표적으로 오/아래, 왼/아래로 나눠서 생각해야한다. 왜냐하면 좌를 계산할 때 우는 이미 계산되지 않았기 때문이다
 * 4. 따라서 임시 배열을 하나 더 만든다. 대신 이때, 두가지 경우로 구분하기 위해 크기는 nm이 아닌 2m으로 한다
 * 5. 첫째 줄은 왼 -> 오 방향만 생각하자 즉 dp[0][i] = dp[0][i-1] + arr[0][i] 만 생각하면 된다
 * 6. 이어서 두번째 줄 부터는 왼, 오, 아래 3방향을 고려해야 한다. 따라서 왼쪽과 위쪽에서 오는 경우, 오른쪽과 위쪽에서 오는 경우로 구분지어서 최댓값을 갱신한다
 * 7. tmp[0][0] = dp[i-1][0] + arr[i][0] 으로 먼저 초기화한다
 * 8. 이어서 1부터 m까지 순회하며 tmp[0][j] = Math.max(tmp[0][j-1], arr[i-1][0]) + arr[i][j]로 갱신한다. 누적된 값의 왼쪽과 위에서 오는 경우 중 최댓값으로 갱신하는 것이다
 * 9. tmp[0][m-1] = dp[i-1][m-1] + arr[i][m-1]로 먼저 초기화한다
 * 10. 이어서 m-2부터 0까지 쑨회하며, tmp[1][j] = Math.max(tmp[0][j+1], dp[i-1][j]) + arr[i][j] 로 갱신한다
 * 11. 이후 0부터 m까지 순회하며 해당 줄의 최댓값을 갱신한다. dp[i][j] = Math.max(tmp[0][j], tmp[1][j])로 갱신하면 된다
 * 12. 이후 목적지까지 누적된 값인 dp[n-1][m-1]을 출력하면 정답이 된다.
 *
 * 해결방법:
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
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        int[][] tmp = new int[2][m];

        for (int i = 1; i < n; i++) {
            tmp[0][0] = dp[i-1][0] + arr[i][0];
            for (int j = 1; j < m; j++) {
                tmp[0][j] = Math.max(tmp[0][j-1], dp[i-1][j]) + arr[i][j];
            }

            tmp[1][m-1] = dp[i-1][m-1] + arr[i][m-1];
            for (int j = m-2; j >= 0; j--) {
                tmp[1][j] = Math.max(tmp[1][j+1], dp[i-1][j]) + arr[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(tmp[0][j], tmp[1][j]);
            }
        }

        bw.write(dp[n-1][m-1]+"");

        br.close();
        bw.close();
    }
}
