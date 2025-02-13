import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 구현이 아닌 DFS 문제다. 참고로 자바로 bfs를 구현하면 터진다
 * 2. 주어진 조건에 맞춰서 DFS를 한다. 0번을 가로, 1번을 세로, 2번을 대각선으로 한다
 * 3. 모든 방향에 대해서 대각선은 공통으로 존재하니까, 각 케이스에서 가로는 가로만, 세로는 세로만, 대각선은 가로 세로만 처리해서 DFS를 돌리고, 이후 스위치문을 벗어난 뒤에 대각선 방향으로의 이동을 진행한다
 * 4. 만약 현재 위치가 (N,N)이면 ans를 증가시킨다
 * 5. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(3^(n^2))
 * 공간복잡도: O(n*n)
 *
 */
public class Main {

    static int n;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = 0;
        dfs(0, 1, 2);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void dfs(int dir, int y, int x) {
        if(y == n && x == n){
            ans++;
            return;
        }

        switch(dir){
            case 0:
                if(x+1 <= n && arr[y][x+1] == 0){
                    dfs(0, y, x+1);
                }
                break;
            case 1:
                if(y+1 <= n && arr[y+1][x] == 0 ){
                    dfs(1, y+1, x);
                }
                break;
            case 2:
                if(y+1 <= n && arr[y+1][x] == 0){
                    dfs(1, y+1, x);
                }
                if(x+1 <= n && arr[y][x+1] == 0){
                    dfs(0, y, x+1);
                }
                break;
        }

        if(y+1 <= n && x+1 <= n && arr[y+1][x+1] == 0 && arr[y+1][x] == 0 && arr[y][x+1] == 0){
            dfs(2, y+1, x+1);
        }

    }

}
