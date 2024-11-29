import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. n과 m의 최대값이 8로 매우 작기 떄문에, 완전탐색 + BFS로 해결하면 되겠다고 생각했다
 * 2. y축과 x축을 각각 3번씩 골라야하기 때문에 6중 포문을 사용해야 하나, 조금 코드를 간결하게 하기 위해 3중 포문으로 줄이고 n*m까지 탐색하는 것으로 문제를 풀었다
 * 3. 선택지 1 / m이 y좌표이고 선택지 1 % m이 x좌표이다
 * 4. 서로 다른 영역에 벽을 설치하자 벽 하나가 한칸을 차지하므로 중복 설치는 불가능하다
 * 5. 이어서 선택한 지점은 빈칸이어야 하므로 이것도 확인한 뒤, 선택한 지점을 1로 바꿔주자
 * 6. 이어서 BFS를 통해 2인 지점을 시작으로 0인 지점을 2로 바꿔주고, 종료된 뒤에 0인 지점의 개수를 세어준다
 * 7. ans와 비교하여 더 큰 값으로 갱신한다
 * 8. 또한 현재 선택 결과가 다음 선택 결과에 영향을 주지 않기 위해 배열은 입력값 배열을 clone해서 사용한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * [테스트 케이스]
 * 3 3
 * 2 1 1
 * 0 1 1
 * 0 0 2
 *
 * 예상 결과값: 0
 *
 * 3 3
 * 2 0 0
 * 0 0 0
 * 0 0 2
 *
 * 예상 결과값 1
 *
 *
 * 5 3
 * 1 0 1
 * 0 0 0
 * 2 2 2
 * 0 0 0
 * 1 0 1
 *
 * 예상 결과값 2
 *
 * 시간복잡도: O((n*m)^3 * n*m)
 * 공간복잡도: O(n*m)
 *
 */


public class Main {

    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans = 0;
    static boolean[][] visited;
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

        for (int i = 0; i < n*m; i++) {
            for (int j = 0; j < n*m; j++) {
                for (int k = 0; k < n * m; k++) {
                    visited = new boolean[n][m];
                    int[][] tmp = new int[n][m];
                    for (int z = 0; z < n; z++) {
                        tmp[z] = arr[z].clone();
                    }
                    int ay = i / m ;
                    int ax = i%m;
                    int by = j/m;
                    int bx = j % m;
                    int cy = k / m;
                    int cx = k % m;


                    if(i == j || j == k || k == i){
                        continue;
                    }


                    if(tmp[ay][ax] != 0 || tmp[by][bx] != 0 || tmp[cy][cx] != 0){
                        continue;
                    }



                    tmp[ay][ax] = 1;
                    tmp[by][bx] = 1;
                    tmp[cy][cx] = 1;


                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(tmp[l][o] == 2 && !visited[l][o]){
                                bfs(n,m, l,o, tmp);
                            }
                        }
                    }
                    int count = 0;
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(tmp[l][o] == 0){
                                count++;
                            }
                        }
                    }



                    ans = Math.max(ans, count);
                }
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int y, int x, int[][] ase) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        visited[y][x] = true;


        while(!q.isEmpty()){
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && ase[ny][nx] == 0){
                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    ase[ny][nx] = 2;
                }
            }
        }

    }
}
