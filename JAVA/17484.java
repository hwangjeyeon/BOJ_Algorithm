import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 입력값이 작아서 BFS로 풀었다.
 * 2. dp로도 쉽게 풀 수 있을 것 같다.
 * 3. 주의할점이 하나 있는데, 시작지점과 끝 지점은 이전 방향을 신경쓰지 않고 이동해도 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static int[][] arr;
    static int[] dx = {-1,0,1};
    static int[] dy = {1,1,1};
    static int ans = Integer.MAX_VALUE;
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


        for (int i = 0; i < m; i++) {
            bfs(n,m,i, arr[0][i]);
        }


        bw.write(ans+"");


        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int start, int cost) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, start, cost, -1});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            if(now[0] == n-1){
                ans = Math.min(now[2], ans);
                continue;
            }

            for (int i = 0; i < 3; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n &&  nx >= 0 && nx < m){
                    if((now[0] != n-1 && i == now[3]) || (now[0] != 0 && i == now[3])){
                        continue;
                    }
                    q.add(new int[]{ny, nx, now[2] + arr[ny][nx], i});
                }
            }

        }

    }

}

