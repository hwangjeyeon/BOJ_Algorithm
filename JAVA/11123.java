import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 그냥 브루트포스 + BFS하면 풀리는 쉬운 문제다.
 * - 문제 해결:
 *
 * 시간복잡도: O(hw)
 * 공간복잡도: O(hw)
 *
 */

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            visited = new boolean[h][w];
            count = 0;
            for (int j = 0; j < h; j++) {
                String input = br.readLine();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = input.charAt(k);
                }
            }

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if(!visited[j][k] && arr[j][k] == '#'){
                        bfs(h,w,j,k);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");

        }

        br.close();
        bw.close();
    }

    private static void bfs(int h, int w, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >=0 && nx>=0 && ny < h && nx < w && !visited[ny][nx]){
                    if(arr[ny][nx] == '#'){
                        q.add(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }

            }
        }

    }

}

