import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. dfs를 해야하나 고민을 했는데, 그러기에는 l의 크기가 300까지 가므로 시간초과가 발생한다
 * 2. 따라서 bfs 탐색을 선택하였다
 * 3. 기존 상하좌우나 대각선까지 추가되는 탐색이랑 다르게 주어진 나이트의 이동 방향을 맞춰서 총 8가지 경우로 탐색을 해주면 된다
 *
 *
 * - 문제 해결:
 * 1. count 방식으로 하면 총 8가지 경우의 수를 모두 더하기 때문에 원하는 결과를 얻지 못한다
 * 2. 따라서 원래 지점에서 +1한 값을 이동할 지점에 넣는 방식으로 탐색을 진행한다
 * 3. 목적지를 찾으면 bfs 탐색을 종료하고 목적지의 값을 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(l^2)
 * 공간복잡도: O(l^2)
 *
 */

public class Main {

    static int[][] arr;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            count = 0;
            int l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visited = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                start[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                end[j] = Integer.parseInt(st.nextToken());
            }

            bfs(l);
            bw.write(arr[end[0]][end[1]] + "\n");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int l) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == end[0] && now[1] == end[1]){
                return;
            }
            for (int i = 0; i < 8; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(nx >=0 && ny >=0 && nx < l && ny < l && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[] {ny, nx});
                    arr[ny][nx] = arr[now[0]][now[1]]+1;
                }
            }
        }


    }

}

