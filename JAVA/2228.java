import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 누적합 + DP문제다.
 * 2. 바텀업 방식이 도저히 떠오르지 않아 탑다운으로 접근해서 풀었던 문제다
 * 3. 일단 구간의 속한 수의 합을 구하는 문제이므로 구간합으로 미리 계산해두면 편하겠다고 생각했다
 * 4. 따라서 구간합 배열을 만들어서 입력값을 구간합으로 계산해서 저장했다
 * 5. 처음에는 조합을 생각했다. 하지만 구간이라는 범위가 존재하기도 하고, 선택하지 않는 경우와 선택하는 경우 2가지라고 했을 때, 2^100이 되므로 선택을 포기했다
 * 6. 시간복잡도 이슈니까 해결할 수 있는 방법은 dp가 아닐까 생각했다. 근데 대체 어떻게 선언해야할지 감이 오지 않았다
 * 7. 그러다가 n번째 수가 m번째 구간에 속하는 경우와 속하지 않는 경우를 구분해서 최대 합을 DP에 누적하는 방식이라면 풀 수 있지 않을까 라는 생각을 했다
 * 8. 따라서 dp[n+1][m+1]을 선언했다.
 * 9. 이어서 모든 배열의 최솟값인 -32768 * 100으로 초기화한다
 * 10. 그리고 방문배열을 똑같은 크기로 선언한다. 중복 선택되는 경우를 방지하기 위함이다.
 * 11. topDown 방식이므로 n과 m을 인수로 넘겨주며 시작한다. m이 0인 경우는 0을 리턴해서 현재 n이 어떤 구간에도 속하지 않아, 합산에 포함되지 않도록 한다
 * 12. 만약 아직 확인해야할 구간 m이 남아있는 상태에서 n이 0보다 작다면 해당 경우는 합산되면 안된다. 따라서 최솟값으로 리턴시켜서 최댓값 갱신을 하지 못하도록 막는다
 * 13. 방문한 경우 그냥 dp[n][m]을 넘겨줘서 중복 연산하지 않도록 한다
 * 14. 이어서 방문체크를 하고, 현재 n이 m의 범위에 포함되는 경우와 포함되지 않는 경우를 구분한다
 * 15. n이라는 수가 m번째 구간에 속하지 않으면, 더이상 확인할 것이 없다. 그냥 m은 그대로 유지한 채 n-1한 값을 인수로 넘겨주는 topDown을 실행한다. 그리고 그 결과가 dp[n][m]에 저장된다.
 * 16. 왜냐하면 n의 수가 어떤 구간에도 속하지 않으면 합에 포함되지 않기 때문이다. 따라서 포함되는 다른 수를 찾아서 그 결과를 리턴받으면 된다
 * 17. 속하는 경우는 구간을 나눠가며, 합산을 구해야한다. n부터 0보다 클때까지 감산 포문을 돌면서 dp[n][m]을 채워나간다
 * 18. 최댓값을 갱신하는 방식으로 dp[n][m]을 채워나간다. i번째 수까지가 범위의 영역이라고 했을 때, 다음 구간의 합산도 구해야하므로 topDown 재귀식을 실행한다
 * 19. 이때, 조건 2의 인접해 있지 않아야 한다는 조건을 만족하기 위해 i-2를 인수로 넘겨준다. 또한 m-1으로 현재 구간과 겹치지 않도록 한다
 * 20. 그리고 현재 구간의 합산도 구해야한다 sum[n] - sum[i-1]로 미리 구해둔 누적합을 이용해서 합산을 구하면 된다
 * 21. 이렇게 완성한 dp[n][m]을 리턴하며, topDown하는 방식으로 구현하면 된다
 * 22. 최종적으로 완성한 dp[n][m]을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2*m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int n;
    static int m;
    static int[] arr;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        sum = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = arr[i] + sum[i-1];
        }
        dp = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -32768*100;
            }
        }
        topDown(n,m);
        bw.write(dp[n][m]+"");

        br.close();
        bw.close();
    }

    private static int topDown(int n, int m) {
        if(m == 0){
            return 0;
        }
        if(n < 0){
            return -32768*100;
        }
        if(visited[n][m]){
            return dp[n][m];
        }

        visited[n][m] = true;
        dp[n][m] = topDown(n-1, m);
        for (int i = n; i > 0; i--) {
            dp[n][m] = Math.max(dp[n][m], topDown(i-2, m-1)+(sum[n] - sum[i-1]));
        }
        return dp[n][m];
    }
}
