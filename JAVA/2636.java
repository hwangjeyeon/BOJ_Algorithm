import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 구멍을 구분하는 것이 핵심 해결책
 * 2. 테두리에서 bfs를해서 녹는 부분을 표시하자!
 * 3. 나머지는 시뮬레이션 + BFS하면 쉽게 풀린다
 * 4. 먼저 현재 남아있는 치즈 개수를 미리 세어주고 정답 개수로 판단한다
 * 5. 이어서 각 테두리에서 BFS를 통해 한시간 뒤 녹을 치즈를 표시한다
 * 6. 표시한 지점을 녹인다
 * 7. 이후 시간을 늘린 다음 치즈가 모두 녹았는지 판단한다
 * 8. 모두 녹았다면 종료시키고 아니라면 시뮬레이션을 계속 진행한다
 * 9. 완성한 시간과 개수를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(시뮬레이션 시간 * n*(4*(n*m)))
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
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

        int time = 0;
        int count = 0;
        while(true){
            boolean isOk = true;
            // 치즈 개수 판단


            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 1){
                        tmp++;
                    }
                }
            }
            count = tmp;


            //테두리에서 bfs -> 녹는지점 판단
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                if(arr[i][0] == 0 && !visited[i][0]){
                    bfs(n,m, i,0);
                }
                if(arr[i][m-1] == 0 && !visited[i][m-1]){
                    bfs(n,m, i, m-1);
                }
            }
            for (int i = 0; i < m; i++) {
                if(arr[0][i] == 0 && !visited[0][i]){
                    bfs(n,m,0,i);
                }
                if(arr[n-1][i] == 0 && !visited[n-1][i]){
                    bfs(n,m,n-1,i);
                }
            }



            // 녹는 지점 녹이기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 2){
                        arr[i][j] = 0;
                    }
                }
            }
            time++;

            // 치즈 모두 녹았는지 확인
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] != 0){
                        isOk = false;
                        break;
                    }
                }
            }

            if(isOk){
                break;
            }


        }

        bw.write(time + "\n" + count);

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny>=0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]){
                    if(arr[ny][nx] == 0){
                        visited[ny][nx] = true;
                        q.add(new int[]{ny,nx});
                        continue;
                    }
                    if(arr[ny][nx] == 1){
                        visited[ny][nx] = true;
                        arr[ny][nx] = 2;
                    }
                }

            }

        }

    }
}
