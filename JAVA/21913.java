import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 엄청 헷갈리는 문제다. 먼저 DP를 이용하는 문제고, long타입으로 DP 배열을 사용해야한다
 * 2. 문제에서 주어진 비행점수를 구하는 방법을 근거로 상승비행과 하강비행의 누적결과를 보관하는 dp를 분리하고, 마지막에 합산하여 비교한다.
 * 3. 상승비행은 시작점에서 비행을 시작하는 것이다. 따라서 위/오른쪽 방향으로 전진하며, 이전의 결과를 누적한다
 * 4. 맨 왼쪽과 맨 바닥은 한쪽 경로로만 갱신하도록 바꿔준다
 * 5. 하강비행은 상승 비행과 조금 다르게 생각해야한다. 하강 비행은 끝 지점을 기준으로 하며, 역으로 끝지점에서 이전 위치로 역방향 탐색을 한다
 * 6. 따라서 현재 DP의 위치에서 어떤 선택을 할 것인지 비교하면 된다. 즉 아랫방향으로 갈 것인이 오른쪽 방향으로 갈 것인지 비교하면 된다
 * 7. 맨 오른쪽과 맨 바닥을 다시 한쪽 방향으로만 탐색하고 이외에는 탐색하며 갱신한다
 * 8. 이제 모든 지점을 탐색하며 상승비행과 하강비행의 합이 가장 큰 지점을 찾는다. 모든 지점을 탐색하는 이유는 상승 비행은 정방향 하강비행은 역방향으로 누적한 결과이기 떄문이다
 * 9. 따라서 같은 위치의 값을 합산하는 이유도 그 지점이 상승비행에서 하강비행으로 변경한 지점이며, 변경할 때 위치가 변하지 않는다는 조건도 그 지점의 값이 상승,하강 모두 중복되는 것을 활용하면 된다
 * 10. max는 long타입이며, 0을 최솟값으로 하면 안된다. 음수가 있기 때문에 -10_000_000_001L를 초기값으로 한다
 * 11. 완성한 max를 출력하면 정답이 된다.
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
        long[][] dpUp = new long[n][m];
        dpUp[n-1][0] = arr[n-1][0];
        for (int i = 1; i < m; i++) {
            dpUp[n-1][i] = dpUp[n-1][i-1] + arr[n-1][i];
        }
        for (int i = n-2; i >= 0; i--) {
            dpUp[i][0] = dpUp[i+1][0] + arr[i][0];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                dpUp[i][j] = Math.max(dpUp[i+1][j], dpUp[i][j-1]) + arr[i][j];
            }
        }

        long[][] dpDown = new long[n][m];
        dpDown[n-1][m-1] = arr[n-1][m-1];

        for (int i = n-2; i >= 0; i--) {
            dpDown[i][m-1] = dpDown[i+1][m-1] + arr[i][m-1];
        }

        for (int i = m-2; i >= 0; i--) {
            dpDown[n-1][i] = dpDown[n-1][i+1] + arr[n-1][i];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                dpDown[i][j] = Math.max(dpDown[i+1][j], dpDown[i][j+1]) + arr[i][j];
            }
        }

        long ans = -10_000_000_001L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dpUp[i][j] + dpDown[i][j]);
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
