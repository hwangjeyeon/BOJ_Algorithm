import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. BFS를 활용하여 문제를 해결하는 문제다.
 * 2. BFS의 큐에는 4가지 값을 가지는 int형 배열을 가진다. y,x축과 누적 count, 그리고 명검 그람을 찾았는지 여부다
 * 3. 한가지 더 변형해야하는데 방문배열을 변형해야한다. 3차원배열로 선언하여, 그람을 발견했을 때와 발견하지 않았을 때로 나눠주면 해결할 수 있다
 * 4. 왜냐하면 그람을 발견하지 않고 쭉 탐색하여 찾는 경우가 그람을 발견하여 탐색했을 떄보다 더 빠르게 찾을 수도 있기 떄문이다
 * 5. 종료조건으로는 n-1, m-1에 도달했을때 time 값을 갱신해주고 time이 t보다 커진 경우는 그냥 종료해준다
 * 6. time이 초기값이면 Fail이고 아니면 time을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n x m x 4)
 * 공간복잡도: O(n x m x 2)
 *
 */




public class Main {

    static int n;
    static int m;
    static int t;
    static int[][] arr;
    static boolean[][][] visited;
    static int time = Integer.MIN_VALUE;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m][2];
        bfs();
        if(time == Integer.MIN_VALUE || time > t){
            bw.write("Fail");
        }else{
            bw.write(time+"");
        }

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});
        visited[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[2] > t){
                return;
            }
            if(cur[0] == n-1 && cur[1] == m-1) {
                time = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if(ny >=0 && nx >=0 && ny < n && nx < m){
                    if(cur[3] == 0){
                        if(arr[ny][nx] == 0 && !visited[ny][nx][0]){
                            visited[ny][nx][0] = true;
                            q.add(new int[] {ny,nx, cur[2]+1, cur[3]});
                        }
                        if(arr[ny][nx] == 2 && !visited[ny][nx][0]){
                            visited[ny][nx][0] = true;
                            q.add(new int[] {ny,nx, cur[2]+1, 1});
                        }
                    }else{
                        if(!visited[ny][nx][1]){
                            visited[ny][nx][1] = true;
                            q.add(new int[] {ny,nx, cur[2]+1, cur[3]});
                        }
                    }
                }
            }

        }
    }

}

