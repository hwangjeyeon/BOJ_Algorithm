import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dfs + dp 문제다. DFS나 bfs에 dp를 활용하는 유형의 문제를 학습할 때 풀면 좋은 문제인듯하다
 * 2. n이 3이기 때문에 공격 유형타입이 정해져 있다. 총 6가지 경우를 미리 구해두자
 * 3. arr은 3으로 초기화해둔다. 만약 3보다 작은 경우는 그냥 체력을 0으로 민들기 위함이다
 * 4. dp는 각 scv의 각 체력에서의 누적 공격 횟수이고, 최대 체력의 크기로 선언한다
 * 5. ans는 최대크기로 선언해서 최대정답값을 찾도록 하자
 * 6. ans의 크기가 depth보다 작거나 같으면 return, dp[a][b][c]가 0이 아니라 방문했는데, dp[a][b][c] <= depth인 경우도 return한다
 * 7. 6번의 경우는 ans보다 큰 depth를 찾을 필요가 없기 때문이다 우리는 최소 공격 횟수를 찾고 있기 떄문이다
 * 8. 이 모든 조건에 해당하지 않는 경우, dp[a][b][c]에는 depth를 넣는다. 참고로 a,b,c는 각 scv의 체력이다
 * 9. 이후 a,b,c가 모두 0이면 종료조건이므로 ans를 depth와 비교해 더 작은 값으로 변경하고 종료하낟
 * 10. 아닐 경우 6가지 공격패턴에 따라 체력이 감소한 배열과 depth+1을 리턴한다. 이때 음수의 값은 피하기 위해 Math.max로 0과 비교해서 넘겨준다
 *
 * 해결방법:
 *
 * 시간복잡도: O(60^3)
 * 공간복잡도: O(60^3)
 *
 */

public class Main {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[][][] dp;
    static int[][] type = {{-9,-3,-1,}, {-9, -1, -3}, {-3, -9,-1}, {-3, -1, -9}, {-1, -3, -9}, {-1, -9, -3}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[61][61][61];
        dfs(arr, 0);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void dfs(int[] arr, int depth) {
        if(ans <= depth){
            return;
        }
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        if(dp[a][b][c] != 0 && dp[a][b][c] <= depth){
            return;
        }
        dp[a][b][c] = depth;

        if(a == 0 && b == 0 && c == 0){
            ans = Math.min(ans, depth);
            return;
        }
        for (int i = 0; i < 6; i++) {
            dfs(new int[]{Math.max(a + type[i][0], 0),
                    Math.max(b + type[i][1],0),
                    Math.max(c + type[i][2], 0)}, depth+1);
        }

    }


}
