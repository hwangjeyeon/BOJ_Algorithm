import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 백트래킹에 상하좌우 탐색과 알파벳 방문배열을 활용하면 쉽게 풀 수 있는 문제다
 * 2. 정답 개수를 실행 함수마다 비교하며 최댓값으로 갱신한다
 * 3. 완성한 ans를 출력하면 정답이 된다 
 *
 * 해결방법:
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(r*c)
 *
 */


public class Main {

    static int r;
    static int c;
    static char[][] arr;
    static int ans = 0;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = a[j];
            }
        }
        visited = new boolean[26];
        visited[arr[0][0] - 'A'] = true;
        backtracking(0,0, 1);

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

    private static void backtracking(int y, int x, int count) {
        ans = Math.max(ans, count);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(isRange(ny, nx) && !visited[arr[ny][nx] - 'A']){
                visited[arr[ny][nx] - 'A'] = true;
                backtracking(ny,nx, count+1);
                visited[arr[ny][nx] - 'A'] = false;
            }
        }
    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < r && nx >= 0 && nx < c;
    }
}
