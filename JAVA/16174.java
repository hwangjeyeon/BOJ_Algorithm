import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS + DP로 해결하는 문제다
 * 2. 방향이 우, 하 두가지만 존재하기 떄문에 재방문 가능성이 없으므로 방문배열이 필요없다
 * 3. bfs를 이용해서 두가지 방향에 대해서만 탐색 후, 마지막 지점에 도달하는 경우 ans 변수 값을 변경한다
 * 4. 하지만 단순히 bfs를 할 경우, 메모리 초과가 발생한다. 아마 방문배열이 없어서 큐의 크기가 커지기 때문에 작은 메모리 초과 범위에 따라 메모리 초과가 발생하는 것 같다
 * 5. 따라서 dp를 이용해야 한다. 이전에 우,하 방향으로만 갈 때 dp를 사용했던 것을 떠올려서 이동거리거 dp의 값보다 클 때만 큐에 넣어주고 교체하도록 하자
 * 6. 이렇게 하면 정답을 정상적으로 출력했을 때 정답이 된다.
 * 
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    static int[][] arr;
    static String ans = "Hing";
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        bfs(0,0,n, arr[0][0]);

        bw.write(ans);

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x, int n, int dis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,dis});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[2] == -1){
                ans = "HaruHaru";
                return;
            }

            int ny = now[0] + arr[now[0]][now[1]];
            int nx = now[1];

            if(ny >=0 && ny < n && nx>=0 && nx< n && dp[ny][nx] < now[2]){
                q.add(new int[]{ny, nx, arr[ny][nx]});
                dp[ny][nx] += now[2];
            }

            ny = now[0];
            nx = now[1] + arr[now[0]][now[1]];
            if(ny >=0 && ny < n && nx>= 0 && nx< n && dp[ny][nx] < now[2]){
                q.add(new int[]{ny, nx, arr[ny][nx]});
                dp[ny][nx] += now[2];
            }

        }
    }

}
