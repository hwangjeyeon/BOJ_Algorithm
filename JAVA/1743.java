import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BFS 탐색으로 풀었다.
 * - 확실히 다른 사람들이 많이 쓰는 dx, dy 방식을 쓰니까 코드가 더 간결해지고 편해져셔 좋은 것 같다 ㅎㅎ
 * - BFS 탐색을 통해서 쓰레기가 있는 곳은 큐에 넣어주고 count값을 증가시켜준다
 * - 그리고 필드의 처음부터 모든 좌표를 탐색하는데 방문하지 않았고, 현재 좌표가 쓰레기가 있는 좌표인 경우만 BFS 탐색한다
 * - 탐색 후, count 값과 ans값을 비교하여 더 큰 수를 넣어준다
 * - 추가로 count는 1을 해야하는데, 큐에 넣을 초기값을 생각해야하기 떄문이다.
 * - 완성된 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {


    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1, 0, 1, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        field = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            field[y][x] = 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 1;
                if(!visited[i][j] && field[i][j] == 1){
                    bfs(n,m, j, i);
                    ans = Math.max(count, ans);
                }

            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    static void bfs(int n, int m, int rx, int ry){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {ry,rx});

        visited[ry][rx] = true;
        while(!q.isEmpty()){
            int y = q.peek()[0];
            int x = q.peek()[1];
            q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < m){
                    if(!visited[ny][nx] && field[ny][nx] == 1){
                        q.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
        }
    }
}

