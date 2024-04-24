import java.io.*;
import java.util.*;


/**
 * 풀이 과정: 
 * 1. bfs탐색으로 쉽게 풀 수 있는 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(mn)
 * 공간복잡도: O(mn)
 *
 */

public class Main {

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && arr[i][j] == 1){
                    bfs(n,m,i,j);
                    count++;
                }
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny>=0 && nx>=0 && ny < m && nx < n && !visited[ny][nx] && arr[ny][nx] == 1){
                    q.add(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }

            }

        }

    }

}

