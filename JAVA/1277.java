import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 1번에서 n번까지의 최소비용을 구하는 문제이므로 다익스트라를 이용해서 해결했다
 * 2. 각 발전소 좌표를 저장하고, 연결 여부 역시 저장했다. 또한 다익스트라를 위해 dist 배열도 초기화했다
 * 3. 연결되어있는 경우 비용을 0으로 초기화했다
 * 4. 먼저 연결되어 있어서 진행할 수 있는 만큼 진행하기 위해, 최솟값이 되는 경우(연결되어 있는 경우)를 찾는다.
 * 5. 다시 탐색하며, 그 지점과 다른 지점의 거리를 구한 다음 다익스트라 배열을 갱신한다
 * 6. 완성한 n번 인덱스의 배열의 값을 1000을 곱해서 ans로 초기화하고 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */

class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static double line;
    static boolean[][] connected;
    static Pair[] pos;
    static long ans = 0;
    static double[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        line = Double.parseDouble(br.readLine());
        connected = new boolean[n+1][n+1];
        pos = new Pair[n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pos[i] = new Pair(a, b);
        }

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
        }
        
        dijkstra(n,w);
        ans = (long) (dist[n]* 1000);
        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

    private static void dijkstra(int n, int w) {
        dist = new double[n+1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = Double.MAX_VALUE;;
        }
        dist[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            if(connected[1][i]){
                dist[i] = 0;
            }
        }
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            double min = Double.MAX_VALUE;
            int cur = 0;
            for (int j = 1; j < n + 1; j++) {
                if(!visited[j] && min >= dist[j]) {
                    min = dist[j];
                    cur = j;
                }
            }

            if(cur == n) {
                break;
            }
            visited[cur] = true;
            for (int j = 1; j < n + 1; j++) {
                if(j == cur) {
                    continue;
                }
                int nxt = j;
                double distance = Math.sqrt(Math.pow(pos[nxt].x - pos[cur].x,2)
                        + Math.pow(pos[nxt].y - pos[cur].y, 2));
                if(connected[cur][nxt]){
                    distance = 0;
                }
                if(dist[nxt] > dist[cur] + distance) {
                    dist[nxt] = (dist[cur] + distance);
                }
            }
        }
    }

}
