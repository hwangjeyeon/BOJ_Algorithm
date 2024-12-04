import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS를 이용해서 음식까지 도달하는 최단거리 체크한다음 정답에 넣어서 출력하는 쉬운문제다.
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int ans = 0;
    static String isAns = "NIE";
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == 2){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        visited = new boolean[n][m];

        bfs(n,m, start);

        if(isAns.equals("NIE")){
            bw.write(isAns);
        }else{
            bw.write(isAns+"\n");
            bw.write(ans+"");
        }


        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1],0});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] != 2){
                isAns = "TAK";
                ans = cur[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];
                if(ny >=0 && ny < n && nx >=0 && nx < m && !visited[ny][nx]){
                    if(arr[ny][nx] != 1){
                        q.add(new int[]{ny,nx, cur[2] + 1});
                        visited[ny][nx] = true;
                    }
                }
            }

        }

    }
}
