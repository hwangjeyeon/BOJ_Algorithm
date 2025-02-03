import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 조금 복잡할거라 생각했는데, 생각보다 쉬운 문제였다
 * 2. 말그대로 그냥 구현하면 된다. 대신 조금 복잡도를 줄이기 위해 탐색 편의 메소드 배열을 두종류 사용했다
 * 3. list를 잘 이용해서 구름의 위치를 잘 파악하면 쉽게 구현할 수 있다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */
public class Main {

    static int n;
    static int m;
    static int[][] arr;
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] cy = {-1, -1, 1, 1};
    static int[] cx = {-1, 1, -1, 1};
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        list.add(new int[]{n-1, 0});
        list.add(new int[]{n-1, 1});
        list.add(new int[]{n-2, 0});
        list.add(new int[]{n-2, 1});
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moveCloud(d, s);
            copyMagic();
            newCloud();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }

        bw.write(sum+"");

        br.close();
        bw.close();
    }

    private static void newCloud() {
        boolean[][] visited = new boolean[n][n];
        for (int[] a : list) {
            visited[a[0]][a[1]] = true;
        }
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] >= 2){
                    arr[i][j] -= 2;
                    list.add(new int[]{i,j});
                }
            }
        }
    }

    private static void copyMagic() {
        for (int[] a : list) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int ny = a[0] + cy[i];
                int nx = a[1] + cx[i];
                if(isRange(ny, nx) && arr[ny][nx] > 0){
                    count++;
                }
            }
            arr[a[0]][a[1]] += count;
        }
    }

    private static boolean isRange(int ny, int nx) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

    private static void moveCloud(int d, int s) {
        Queue<int[]> q = new LinkedList<>();
        for (int[] a : list) {
            int ny = (a[0] + dy[d]*s) % n;
            int nx = (a[1] + dx[d]*s) % n;
            if(ny < 0){
                ny += n;
            }
            if(nx < 0){
                nx += n;
            }
            q.add(new int[]{ny,nx});
        }
        list = new ArrayList<>();
        while(!q.isEmpty()) {
            int[] now = q.poll();
            arr[now[0]][now[1]]++;
            list.add(new int[]{now[0], now[1]});
        }
    }

}
