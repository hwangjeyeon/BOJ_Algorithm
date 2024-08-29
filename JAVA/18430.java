import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 백트래킹을 하는데 조금 변형을 주어야하는 문제다
 * 2. 모든 좌표를 탐색하면서, 현재 좌표를 중심으로 했을 떄, 주어진 모양중 하나를 선택하고 이것을 선택하는 경우와 안 하는 경우로 하여 백트래킹한다면 정답을 고를 수 있을 것이다
 * 3. base condition이 없어도 풀리는 신기한 문제다. 어쨌든 딱 하나만 선택하는 경우도 나올 수 있기 때문에 그냥 시작하자마자 리스트에다가 다 넣었다
 * 4. 이렇게 해서 완성한 리스트를 내림차순 정렬하면, 아무것도 발견하지 못했었도 백트래킹이 실행되었을 때, 무조건 0은 한번 들어가므로 주어진 조건인 0을 출력하고 그 이외에도 가장 큰 값을 출력하게 된다
 * 5. 이때, 모양을 고르는 것을 bfs 탐색할때 사용하던 dy, dx 배열을 이용하였다. 왜냐하면 중심좌표를 기준으로 확인해야하는 두개의 칸의 좌표가 x값 변화 하나랑 y값 변화 하나이기 떄문이다
 * 6. 이렇게 해서 리스트의 첫번째 값을 잘 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O((n*m*4)^(n*m/3))
 * 공간복잡도: O()
 *
 */


public class Main {

    static int[][] arr;
    static List<Integer> lists = new ArrayList<>();
    static boolean[][] visited;
    static int[] dy = {1, -1, -1, 1};
    static int[] dx = {-1, -1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(n,m,0, 0);

        lists.sort(Collections.reverseOrder());
        bw.write(lists.get(0)+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int sum, int start) {
        lists.add(sum);
        for (int i = start; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            for (int j = 0; j < 4; j++) {
                int tmp = 0;
                int ny = dy[j] + r;
                int nx = dx[j] + c;
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[r][c] && !visited[ny][c] && !visited[r][nx]){
                    tmp += arr[r][c]*2;
                    tmp += arr[ny][c];
                    tmp += arr[r][nx];
                    visited[r][c] = true;
                    visited[ny][c] = true;
                    visited[r][nx] = true;
                    backtracking(n,m,sum + tmp, i+1);
                    visited[ny][c] = false;
                    visited[r][nx] = false;
                    visited[r][c] = false;
                }
            }
        }
    }

}

