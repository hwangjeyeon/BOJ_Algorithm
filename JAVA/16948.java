import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 move만 맞춰주면 되는 bfs문제이다.
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */



public class Main {


    static boolean[][] visited;
    static int[][] move = {{-2,-1}, {-2,+1,},{0,-2},{0,+2}, {+2,-1}, {+2, +1}};
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];
        arr = new int[n][n];
        bfs(n,startR, startC, endR, endC);
        if(!visited[endR][endC]){
            bw.write("-1");
        }else{
            bw.write(arr[endR][endC]+"");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int n, int startR, int startC, int endR, int endC) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startR, startC, 0});
        arr[startR][startC] = 0;
        visited[startR][startC] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 6; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]){
                    q.add(new int[] {nr,nc, now[2]+1});
                    arr[nr][nc] = now[2]+1;
                    visited[nr][nc] = true;
                }
            }
        }

    }
}

