import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 입력 최대크기가 작아 깡 구현 문제다.
 * 2. 합산은 그냥 브루트포스, 가장 큰 덩어리는 BFS로 찾으면 된다
 * 3. 그전에 먼저 주어진 조건을 진행시켜야하는데, 먼저 Q만큼 주어진 값에 따라 등분을 해주고, 이전 배열돌리기 문제에서 구현한 것과 똑같이 구현해서 등분한 만큼 돌려준다
 * 4. 그 다음 브루트포스로 상하좌우를 탐색하며, 범위를 벗어나지 않고 0보다 큰 얼음 개수를 세어준다음 3보다 작으면 그 값을 1 줄여서 얼음을 녹인다
 * 5. 이렇게 구현하면 정답을 출력할 수 있다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(q*2^n*2^n)
 * 공간복잡도: O(n^2)
 *
 */
public class Main {

    static int n;
    static int q;
    static int[][] arr;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int[] ry = {1,0,-1,0};
    static int[] rx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) Math.pow(2,Integer.parseInt(st.nextToken()));
        q = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> task = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            task.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer i : task) {
            int ni = (int) Math.pow(2, i);
            if(i == 0){
                melt();
                continue;
            }
            for (int j = 0; j < n; j+=ni) {
                for (int k = 0; k < n; k+=ni) {
                    rotates(j,k,ni);
                }
            }
            melt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += arr[i][j];
            }
        }
        bw.write(ans+"\n");
        visited = new boolean[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != 0 && !visited[i][j]){
                    max = Math.max(max, bfs(i,j));
                }
            }
        }
        bw.write(max+"");

        br.close();
        bw.close();
    }

    private static void melt() {
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i].clone();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(isRange(ny,nx) && arr[ny][nx] != 0){
                        count++;
                    }
                }
                if(count < 3 && tmp[i][j] > 0){
                    tmp[i][j]--;
                }
            }
        }

        arr = tmp;
    }

    private static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        int count = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx) && !visited[ny][nx] && arr[ny][nx] != 0){
                    q.add(new int[]{ny,nx});
                    count++;
                    visited[ny][nx] = true;
                }
            }
        }
        return count;
    }

    private static boolean isRange(int ny, int nx) {
        return ny >=0 && ny < n && nx >= 0 && nx < n;
    }

    private static void rotates(int y, int x, int ni) {
        int a = 0;
        while(a < ni){
            for (int i = 0; i < ni-1-a; i++) {
                solve(y,x,ni, a);
            }
            a+=2;
            y++;
            x++;
        }
    }

    private static void solve(int y, int x, int ni, int a) {
        int last = arr[y][x];
        int ay = y;
        int ax = x;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < ni-1-a; j++) {
                int ny = y + ry[i];
                int nx = x + rx[i];
                arr[y][x] = arr[ny][nx];
                y = ny;
                x = nx;
            }
        }
        arr[ay][ax+1] = last;

    }


}
