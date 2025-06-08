import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n의 크기가 매우 작기 떄문에 dfs로 풀면 되는 쉬운 문제다
 * 2. 미리 목적지에 도착실패했을 때의 문자열로 초기화하고, 목적지에 도착하면 문자열을 바꿔주면 된다
 * 3. 완성한 결과를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static int n;
    static int[][] arr;
    static String ans = "Hing";
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);


        bw.write(ans);

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {

        if(arr[y][x] == -1){
            ans = "HaruHaru";
            return;
        }

        visited[y][x] = true;

        int now = arr[y][x];
        int ny = y + now;
        int nx = x + now;
        if(isRange(ny, x) && !visited[ny][x]){
            dfs(ny, x);
        }

        if(isRange(y, nx) && !visited[y][nx]){
            dfs(y, nx);
        }
    }

    private static boolean isRange(int ny, int nx){
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }
}
