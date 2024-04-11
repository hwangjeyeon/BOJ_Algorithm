import java.io.*;
import java.util.*;


/**
 * 고민과 풀이:
 *
 * 문제 해결:
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 *
 */


public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            arr[first][second] = 1;
            arr[second][first] = 1;
        }
        bfs(1);


        bw.write(count+"");
        br.close();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 1; i < arr.length; i++) {
                if(!visited[i] && arr[now][i] == 1){
                    q.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
}
