import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 시작점에서 종점으로 가는 최단거리를 구하는 문제이므로 다익스트라로 푸는 문제다
 * 2. 우선순위 큐를 사용하는 다익스트라 구현방식을 이용해서 문제를 해결하였다
 * 3. 좌표평면에서 최단거리를 구하는 문제이므로 상하좌우 배열탐색과 함께 사용하면 된다
 * 4. 방문배열을 사용하지 않고 dist를 사용하면 손쉽게 구할 수 있다
 * 5. 종점에 도착하면 바로 그값을 정답으로 해주고, 다익스트라 종료후 정답을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2logn^@)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {
    static int ans = 0;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 1;
        while(true){
            ans = 0;
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            arr = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = 987654321;
                }
            }


            dijkstra(n);


            bw.write("Problem " + T++ + ": " + ans + "\n");
        }

        br.close();
        bw.close();
    }

    private static void dijkstra(int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        pq.add(new int[]{0,0,arr[0][0]});
        dist[0][0] = arr[0][0];
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == n-1 && now[1] == n-1){
                ans = now[2];
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny,nx, n) && now[2] + arr[ny][nx] < dist[ny][nx]){
                    dist[ny][nx] = now[2] + arr[ny][nx];
                    pq.add(new int[]{ny, nx, now[2] + arr[ny][nx]});
                }
            }
        }

    }

    private static boolean isRange(int ny, int nx, int n) {
        return ny >=0 && ny < n && nx >= 0 && nx < n;
    }

}
