import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 입력값이 크지 않기 때문에 BFS 탐색과 시뮬레이션을 섞어서 해결하면 되겠다고 생각했다
 * 2. 시뮬레이션을 돌리면서 BFS 탐색을 진행하고 마지막에 모든 치즈가 녹는지 검증한다면 정답을 구할 수 있을 것이다
 * 3. BFS 탐색에서 count를 하나 활용했다. 치즈가 아닌 지점과 맞닿는 부분이 있는지 확인하기 위함이다.
 * 4. 만약 범위를 벗어나지 않으면서 0인 지점이 있다면 그 지점을 count하고, 모든 방향 탐색이 끝난 뒤에 count가 2 이상이라면 기준지점을 2로 바꾼다
 * 5. 이후 모든 지점을 탐색하며 2인 지점을 0으로 바꾼다
 * 6. 검증은 모든 지점을 돌아다니면서 만약 0이 아닌 지점이 있으면 다시 시뮬레이션을 진행하고 아니면 그대로 종료한다.
 * 7. 이전에 한가지를 더 해줘야한다. 바로 외부공기와 내부공기를 구분하는 것이다. 이것은 문제에서 주어진 조건인 가장자리는 무조건 0이라는 것을 이용하면 된다.
 * 8. 따라서 0,0을 기준으로 dfs를 돌려서 0인 지점만 따로 외부공기라는 3으로 표시하면 외부공기와 내부공기 구분이 될 것이다
 * 9. 그리고 bfs에서는 앞서 0인 지점이 있는 경우 count++라고 말한 부분을 3인 지점 확인으로 바꿔서 체크하면된다
 * 10. 각 시뮬레이션 시작지점에 ans를 증가시키는데 시뮬레이션 종료하고 나서의 ans를 출력하면 정답이 된다.
 *
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(시뮬레이션 * n * m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int ans = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            ans++;
            visited = new boolean[n][m];
            dfs(0,0);

            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited[i][j] && arr[i][j] == 1){
                        bfs(i,j);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] == 2){
                        arr[i][j] = 0;
                    }
                }
            }
            if(valid()){
                break;
            }
        }


        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        arr[y][x] = 3;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!isRange(ny, nx)){
                continue;
            }
            if(visited[ny][nx] || arr[ny][nx] == 1){
                continue;
            }
            dfs(ny,nx);
        }
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny, nx) && arr[ny][nx] == 3){
                    count++;
                }
                if(isRange(ny,nx) && (!visited[ny][nx] && arr[ny][nx] == 1)){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                }
            }
            if(count >= 2){
                arr[now[0]][now[1]] = 2;
            }
        }
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < m;
    }

    private static boolean valid() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }

}
