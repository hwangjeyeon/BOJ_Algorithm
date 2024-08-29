import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 백트래킹을 조금 변형시켜야하고, 넴모넴모 조건을 만족시켜야 한다
 * 2. 넴모넴모가 있는 칸과 없는 칸으로만 구분되므로 boolean타입의 2차원 배열을 하나 선언한다
 * 3. 정답을 보관할 변수를 하나 선언하고 백트래킹을 진행한다
 * 4. 백트래킹의 파라미터는 depth와 start, n,m으로 구성하였다
 * 5. 맨 처음에는 현재 배열 상태에서 조건을 만족시키는지 확인하여 만족시킨다면 ans의 값을 증가시킨다
 * 6. 조건을 만족시키는지는 n-1 * m-1만큼 2중포문으로 탐색하여, 현재 위치, 우측, 아래측, 대각선 오른쪽 아래 부분이 true인지 확인하고 만약 맞다면 false를 던져 ans 증가를 막는다
 * 7. 그 외에는 true를 던져줘서 조건을 만족시켜 ans 값을 증가시키도록 한다
 * 8. base condition은 depth가 n*m이 되었을때로 그냥 종료시킨다
 * 9. 이어서 1차원 배열로 n*m만큼 탐색하면서 백트래킹 재귀문을 실행한다
 * 10. 이때 start 부터 시작하여, 이전 위치가 아닌 그 다음 위치로한다
 * 11. 2차원 배열을 1차원 배열로 탐색하는 방법은 다음과 같다
 * 12. 현재 탐색하는 i를 가로의 길이 m으로 나눈 몫을 세로 좌표로하고, 나눈 나머지를 가로 좌표로 한다
 * 13. 이어서 미방문시 방문 체크 후, depth+1, i+1, n, m 인수를 넘기는 재귀문을 실행한다
 * 14. 백트래킹 종료후에는 방문 체크를 해제한다
 * 15. 이렇게 완성한 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n*m*(n-1)*(m-1))
 * 공간복잡도: O(n*m)
 *
 */


public class Main {
    static boolean[][] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        backtracking(0, 0,n,m);
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int start, int n, int m) {
        if(chk(n, m)){
            ans++;
        }
        if(depth == n * m){
            return;
        }
        for (int i = start; i < n*m; i++) {
            int r = i / m;
            int c = i % m;
            if(!visited[r][c]){
                visited[r][c] = true;
                backtracking(depth+1,i+1,n,m);
                visited[r][c] = false;
            }

        }

    }

    private static boolean chk(int n, int m) {

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;

    }
}

