import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 방문배열을 응용하는 BFS문제다.
 * 2. 방문배열을 3차원 배열로 선언하고 k+1크기의 차원을 추가한다.
 * 3. 그 위치에서 벽을 부술 수 있는 벽의 남은 개수일 때 방문한 경우의 수를 체크한다면 문제없이 최단거리로 BFS 결과를 찾을 수 있다
 * 4. 완성한 최단거리를 출력하고 만약 도착지점에 도달하지 못하면 미리 초기화해둔 -1로 출력한다
 *
 * 해결방법:
 *
 * 시간복잡도: O((n*m) + (n*m))
 * 공간복잡도: O(n*m*k)
 *
 */

public class Main {

    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited = new boolean[n][m][k+1];
        bfs();
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k, 1});
        visited[0][0][k] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == n-1 && now[1] == m-1){
                ans = now[3];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(isRange(ny,nx)){
                    if(now[2] != 0 && arr[ny][nx] == 1 && !visited[ny][nx][now[2]-1]){
                        q.add(new int[]{ny,nx,now[2]-1, now[3] + 1});
                        visited[ny][nx][now[2]-1] = true;
                        continue;
                    }

                    if(arr[ny][nx] == 0 && !visited[ny][nx][now[2]]){
                        q.add(new int[]{ny,nx,now[2], now[3] + 1});
                        visited[ny][nx][now[2]] = true;
                    }
                }
            }

        }

    }

    private static boolean isRange(int ny, int nx) {
        return ny >=0 && ny < n && nx >=0 && nx < m;
    }

}
