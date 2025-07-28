import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. bfs를 이용해서 푸는 간단한 문제로 m과 n을 잘 구별해서 사용하면 쉽게 풀 수 있다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int[][] arr;
    static int n;
    static int m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(bfs()){
            bw.write("Yes");
        }else{
            bw.write("No");
        }


        
        br.close();
        bw.close();
    }

    private static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();

            for (int i = 0; i < 2; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(isRange(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 1){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }

        }
        return visited[m-1][n-1];
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < m && nx >= 0 && nx < n;
    }
}
