import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 *
 * 해결방법:
 * 1. 처음선택한 방법은 브루트포스 + BFS방법이었는데 1%에서 시간초과가 발생하였다
 * 2. 시간복잡도를 계산해보면 해당 방법은 시간초과가 발생한다는 것을 알 수 있다
 * 3. 따라서 다르게 선택한 방법은 자료구조 + BFS + 아이디어를 조합한 방법이다
 * 4. 아이디어는 먼저 1인 지점을 각각 군집화해서 2이상의 숫자로 각 영역을 재표현하는 것이다
 * 5. 이어서 1이 아닌 0인 지점을 기준으로 상하좌우 탐색하며, 확인가능한 숫자들을 모두 확인한다
 * 6. Map을 이용해서 4번 도중 각 숫자들의 개수를 저장하고 5번에서 이 값들을 활용해서 모두 더한다
 * 7. 더한 값을 ans와 비교해서 더 큰 값을 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int ans = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        int num = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    bfs(n,m, i, j, num++);
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0){
                    set.clear();
                    int sum = 1;
                    for (int k = 0; k < 4; k++) {
                        int ny = dy[k] + i;
                        int nx = dx[k] + j;
                        if(ny >=0 && ny < n && nx >=0 && nx < m && arr[ny][nx] != 0){
                            set.add(arr[ny][nx]);
                        }
                    }

                    if(set.isEmpty()){
                        continue;
                    }
                    for (Integer a : set) {
                        sum += map.get(a);
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int y, int x, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        int count = 0;
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            arr[now[0]][now[1]] = num;
            count++;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n && nx >=0 && nx < m && arr[ny][nx] == 1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});

                }
            }
        }
        map.put(num,count);

    }

}
