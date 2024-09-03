
import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹 완전탐색 문제다.
 * 2. 처음에는 개수가 15개여야지만 가능하니까 방문 못하는 경우도 일단 세어주고, base condition에서 거르는 방식을 선택했다
 * 3. 하지만 이렇게 하니 입력 예제도 엄청나게 많은 시간이 걸려버렸다
 * 4. 따라서 매 방문마다 미리 가능한지 확안하고 가능한 경우에만 재귀문을 돌리도록 하였다
 * 5. BFS의 상하좌우 탐색 배열을 이용하여, 주위가 가능한지 확인한다. 만약 하나라도 범위를 벗어나거나 방문한 곳인 경우 false를 리턴하고 아니면 true를 리턴한다
 * 6. 또한 중심이 되는 지점도 방문 했는지 확인하고 방문하지 않았다면 방문 체크 후, 비용을 합산해, 재귀문을 돌린다
 * 7. 재귀문 이후에는 다시 상하좌우를 돌아 방문체크를 해제하고, 현재 중심 좌표의 방문 체크도 해제한다
 * 8. base condition에서는 ans에 sum과 비교하여 더 작은 값을 넣어준다
 * 9. 완성한 sum을 출력하면 정답이 된다.
 * 
 * - 문제 해결:
 *
 *
 *
 * 시간복잡도: O(n^3)
 * 공간복잡도: O(n^2)
 *
 */




public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0,0, n);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int sum, int n) {
        if(depth == 3){
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < n * n; i++) {

            int r = i / n;
            int c = i % n;

            if(!visited[r][c] && chk(r,c,n)){
                visited[r][c] = true;
                int tmp = cost(r,c,n);
                backtracking(depth+1, sum + tmp,n);
                visitInit(r,c,n);
                visited[r][c] = false;
            }

        }
    }

    private static void visitInit(int r, int c, int n) {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];
            visited[ny][nx] = false;
        }
    }

    private static int cost(int r, int c, int n) {
        int sum = arr[r][c];
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];
            sum += arr[ny][nx];
            visited[ny][nx] = true;
        }

        return sum;
    }

    private static boolean chk(int r, int c, int n) {
        for (int i = 0; i < 4; i++) {
            int ny = r + dy[i];
            int nx = c + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]){
                return false;
            }
        }

        return true;
    }
}

