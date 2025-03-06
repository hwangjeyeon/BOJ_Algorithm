import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. bfs로 구하기에는 제약조건이 많이 걸린다. 한 방향으로 쭉 목적지까지 가는 경우의 수를 구하는 문제는 DFS적합하다
 * 2. 하지만 단순히 dfs로 풀면 시간초과가 발생할 것이다 따라서 처음에 백트래킹으로 해결했는데 시간초과가 발생했다
 * 3. 이 문제는 DP를 같이 활용해야하는 문제다. 목적지까지 도달한 후, 이전에 돌아갔을 때 아직 탐색하지 않은 상하좌우 방향을 탐색한다.
 * 4. 따라서 배열의 크기가 커질 수록 기하급수적으로 경우의 수가 많아지므로 실패한다. 백트래킹도 결국 자신이 왔던 길만 배제하는 것이기 때문에 시간초과 개선이 안된다
 * 5. 따라서 방문배열을 없애고 DP를 활용해서 경로를 누적해서 합산하는 것으로 해결하면 된다
 * 6. 처음에는 -1로 초기화한다. DP를 방문배열의 대역으로도 활용하기 위함이다. 매 DFS의 첫 시작은 현재 위치를 0으로 초기화해준다
 * 7. 만약 상하좌우 방향이 범위를 벗어나지 않고 내리막길 조건이 가능하면 DP의 값이 0보다 큰지 확인한다
 * 8. 크다면 그 DP의 값을 현재 DP에 더해주고, 아니라면 DFS로 탐색을 진행한다
 * 9. 만약 다음 지점이 목적지라면 현재 위치에 단순히 1을 더해주고, 7~8번을 그대로 진행한다
 * 10. DFS 결과는 시작지점의 DP다. 따라서 그 결과를 그대로 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    static int[][] dp;
    static int m;
    static int n;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }



        bw.write(dfs(0,0)+"");

        br.close();
        bw.close();
    }

    private static int dfs(int y, int x) {
        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            if(isRange(ny, nx) && arr[ny][nx] < arr[y][x]){
                if(ny == m-1 && nx == n-1){
                    dp[y][x] += 1;
                }
                if(dp[ny][nx] >= 0){
                    dp[y][x] += dp[ny][nx];
                }else{
                    dp[y][x] += dfs(ny, nx);
                }

            }
        }
        return dp[y][x];
    }

    private static boolean isRange(int ny, int nx){
        return ny >= 0 && ny < m && nx >= 0 && nx < n;
    }

}
