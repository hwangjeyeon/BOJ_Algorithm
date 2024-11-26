import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 시뮬레이션 + bfs 돌리면 되는 문제다
 * 2. 시뮬레이션의 종료 조건으로 맨 처음에 모든 위치를 확인하며, 0이 아닌 구간이 있는지 확인한다
 * 3. 모두 0이면 종료하고 아니라면 다음 작업을 진행한다
 * 4. 이제부터 연도의 값을 증가하고 시작한다. 먼저 빙산을 녹이는 과정을 진행한다
 * 5. BFS 방식을 이용하여, 먼저 0이 아닌 지점을 모두 큐에 넣고, 상하좌우를 탐색하며, 0의 개수를 확인한다
 * 6. 0의 개수만큼 그 지점의 값을 빼주며, 만약 0보다 작아질 경우 0으로 교체한다
 * 7. 이어서 덩어리의 개수를 세기 위해 BFS를 진행한다. 모든 위치를 확인하며, bfs를 통해 덩어리의 개수를 센다
 * 8. 덩어리의 개수가 2보다 크거나 같으면 ans를 year의 값으로 교체하고 시뮬레이션을 종료한다
 * 9. 모든 빙산이 녹아도 정답을 찾지 못할 경우 0을 출력해야하므로 ans는 0으로 초기화한다
 * 10. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * - 추가 테스트케이스
 * 테스트케이스
 *
 * [엣지 케이스]
 * 3 3
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 예상 값 0
 * 출력 값 0
 *
 *
 * [추가 테스트 케이스]
 * 1.
 * 5 5
 * 0 0 0 0 0
 * 0 6 5 9 0
 * 0 10 0 8 0
 * 0 7 4 10 0
 * 0 0 0 0 0
 *
 * 예상 값 3
 * 출력 값 3
 *
 *
 * 2. 4 5
 * 0 0 0 0 0
 * 0 1 2 4 0
 * 0 7 10 10 0
 * 0 0 0 0 0
 *
 * 예상 값 0
 * 출력 값 0
 *
 * 시간복잡도: O((n*m)*(n+m))
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int year = 0;
        while(true){
            // 시뮬레이션 진행 체크 - 모두 녹았는지 확인
            boolean isOk = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] != 0){
                        isOk = true;
                        break;
                    }
                }
                if(isOk){
                    break;
                }
            }
            if(!isOk){
                break;
            }
            year++;

            // 빙산 녹이기 작업 + 덩어리 개수 체크
            solution(n,m, arr);
            int tmp = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && arr[i][j] != 0){
                        loafBfs(n,m,arr, i, j);
                        tmp++;
                    }
                }
            }

            if(tmp >= 2){
                ans = year;
                break;
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

    private static void loafBfs(int n, int m, int[][] arr, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y,x});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n && nx >=0 && nx < m && arr[ny][nx] != 0 && !visited[ny][nx]){
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

    }


    private static void solution(int n, int m, int[][] arr) {
        Queue<int[]> q = new LinkedList<>();
        int[][] tmp = new int[arr.length][arr[0].length];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i].clone();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tmp[i][j] != 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        // 빙하 녹는 과정
        while(!q.isEmpty()){
            int[] now = q.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n && nx >=0 && nx < m && tmp[ny][nx] == 0){
                    count++;
                }
            }
            arr[now[0]][now[1]] -= count;
            if(arr[now[0]][now[1]] < 0){
                arr[now[0]][now[1]] = 0;
            }

        }

    }
}
