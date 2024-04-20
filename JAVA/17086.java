import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 8방 bfs 탐색으로 푸는 문제였다.
 * 2. 각 bfs 탐색 할때마다 방문 배열을 초기화해준다
 * 3. 각 bfs 탐색마다 값을 리턴하여 가장 큰 값을 받고 완성된 가장 큰 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 * 1. 이전 방법처럼 각 좌표의 값을 증가시키기에는 조금 무리가 있는 문제였다. 브루트포스로 탐색을 해야하기 때문이다
 * 2. 탐색 중에 임시 배열을 복사하는 방법도 있지만 z라는 새로운 속성을 하나 더 추가해서 풀었다
 * 3. z에 이전 z의 값+1을 해줘서 배열 복사 없이 탐색을 통해 문제를 해결하였다
 * 4. 만약 해당 지점이 1이라면 z를 리턴하고 아니라면 그대로 탐색을 진행한다
 * 5. 또한 탐색을 할때는 1을 기점으로 하는 것이 아닌 1이 아닌 지점을 기점으로 하여 탐색을 진행한다.
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(nm)
 *
 */

public class Main {

    static int[][] arr;
    static int max = 0;
    static int[] dy = {-1,-1,-1,0,0,1,1,1};
    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 1){
                    visited = new boolean[n][m];
                    max = Math.max(bfs(n,m, i, j),max);
                }
            }
        }
        bw.write(max+"");

        br.close();
        bw.close();
    }

    private static int bfs(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,0});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                int nz = now[2] + 1;
                if(ny>=0 && nx>=0 && ny < n && nx < m && !visited[ny][nx]){
                    if(arr[ny][nx] == 1){
                        return nz;
                    }
                    q.add(new int[]{ny,nx,nz});
                    visited[ny][nx] = true;
                }
            }
        }
        return 0;
    }

}

