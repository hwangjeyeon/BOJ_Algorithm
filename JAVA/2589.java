import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 완탐돌면서 방문배열을 매번 초기화해주고 만약 L이라면 이 지점을 기준으로 BFS를 돌린다
 * 2. 종료시점을 알기 어렵기 때문에, 매번 큐에서 꺼낼때마다 ans를 더 큰값으로 갱신한다
 * 3. 완성한 ans를 출력하면 정답이 되는 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {

    static char[][] arr;
    static int ans = 0;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input[j];
            }
        }
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                if(arr[i][j] == 'L'){
                    bfs(n,m,new int[]{i,j});
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int[] starts) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{starts[0], starts[1],0});
        visited[starts[0]][starts[1]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            ans = Math.max(now[2], ans);
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny>=0 && ny < n && nx>=0 && nx < m && !visited[ny][nx] && arr[ny][nx] == 'L'){
                    q.add(new int[]{ny,nx, now[2] + 1});
                    visited[ny][nx] = true;
                }
            }
        }
    }

}
