import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 풀이 과정:
 * 1. 구현 + BFS문제다. 방문배열을 사용해야한다
 * 2. 그냥 이동하면서 벽있으면 큐에 넣지 않고, 매 위치마다 유닛의 모든 영역이 도착지의 영역에 모두 포함되는지 확인하면 된다
 * 3. 인덱스로 주어진 값들이 1부터 시작하니 이것만 주의하자
 * 4. 이 문제의 반례가 하나 있다. 도착지점에 장애물이 있을 수 있다.
 * 5. 따라서 입력받을 때 장애물이 있으면 그냥 -1을 출력하고 시스템을 종료한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m*a*b)
 * 공간복잡도: O(n*m)
 *
 */
public class Main {

    static int[][] arr;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int ans = Integer.MAX_VALUE;
    static int n;
    static int m;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y-1][x-1] = -1;
        }
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;
        for (int i = end[0]; i < end[0] + a; i++) {
            for (int j = end[1]; j < end[1] + b; j++) {
                if(arr[i][j] == -1){
                    System.out.print(-1);
                    System.exit(0);
                }
                arr[i][j] = 1;
            }
        }

        bfs(a,b);

        bw.write((ans== Integer.MAX_VALUE ? -1 : ans)+"");

        br.close();
        bw.close();
    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();

            if(checks(now,a,b)){
                ans = Math.min(ans, now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dx[i];
                int nx = now[1] + dy[i];
                if(isRange(ny,nx) && !visited[ny][nx] && !wall(new int[]{ny,nx}, a,b)){
                    q.add(new int[]{ny,nx, now[2] + 1});
                    visited[ny][nx] = true;
                }
            }

        }

    }

    private static boolean checks(int[] now, int a, int b) {
        for (int i = now[0]; i < now[0] + a; i++) {
            for (int j = now[1]; j < now[1] + b; j++) {
                if(!isRange(i,j)){
                    return false;
                }
                if(arr[i][j] != 1){
                    return false;
                }
                if(arr[i][j] == -1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean wall(int[] now, int a, int b) {
        for (int i = now[0]; i < now[0] + a; i++) {
            for (int j = now[1]; j < now[1] + b; j++) {

                if(!isRange(i,j)){
                    return true;
                }
                if(arr[i][j] == -1){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRange(int y, int x) {
        return y >= 0 && y < n && x >=0 && x < m;
    }
}
