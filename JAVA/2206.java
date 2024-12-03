import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이전 유형들과 유사한 문제다.
 * 2. NXM 크기의 배열에서 목적지까지 최단거리를 구하는 문제로, 모든 인덱스를 탐색하며 찾을 수 있기 때문에 BFS를 선택했다.
 * 3. 큐에는 새로운 좌표와 이동거리, 그리고 현재 벽을 부술수 있는 횟수로 설정했다
 * 4. 시작지점과 목적지도 이동거리에 포함시키므로 1부터 시작하며, 1은 벽을 아직 부술 수 있고, 0은 벽을 부술 수 없는 경우로 구분했다
 * 5. 일반적인 bfs 탐색에 몇가지 조건을 넣어서 해결했다.
 * 6. 현재 부술 수 있을 때는 다음 지역이 0인지 1인지에 따라 벽을 부술수 있는 경우를 변경하였고, 부술수 없는 경우는 다음 지역이 0인 경우에만 탐색을 이어갔다
 * 7. 하지만 이렇게민 할경우 한가지 테스트케이스에서 반례가 생긴다
 * [반례]
 * 6 4
 * 0000
 * 1110
 * 1110
 * 0000
 * 0111
 * 0000
 * 8. 위와 같은 반례에서 방문배열을 2차원배열로 설정하면 15라는 출력이 나온다. 정답은 목적지 위의 1을 없애고 바로 목적지로 가는 9가 출력되어야하는데 말이다
 * 9. 방문배열의 결과를 확인해보니, 2번째 행, 3번째 열에서 상하좌우 탐색하는 과정에서 1을 이미 사용한 것으로 오른쪽의 0번 위치를 방문체크해버린다
 * 10. 따라서 정상적인 경로로 오는 경우는 차단되고, 1을 이미 사용한 상태에서로 탐색이 이어지므로 원하는 결과를 얻을 수 없는 것이다
 * 11. 방문배열을 3차원으로 바꿔서 돌을 부술 수 있는 경우와 없는 경우로 방문체크를 해주어야지 해당 문제를 해결할 수 있다
 * 12. 따라서 방문배열을 3차원으로 바꾸고, 1차원의 크기는 1로 했으며, 독립적인 방문 배열을 체크해서 탐색을 갱신하도록 구현하였다
 * 13. 목적지에 도착하면 ans를 이동경로로 갱신한 뒤 탐색을 종료한다.
 * 14. 갱신이 안 된 경우를 대비하기 위해 미리 ans를 -1로 초기화하고, 그대로 ans를 출력하면 상황에 맞는 정답 값을 출력한다.
 *
 * 해결방법:
 *
 * 반례 확인 기준
 * 1. 엣지 케이스 (1x1)
 * 2. 목적지에 도착할 수 있는데 벽을 부수는 것보다 안 부수는게 더 빠른 경우
 * 3. 목적지에 도착할 수 있는데 벽을 부수는 것이 안 부수는 것보다 더 빠른 경우
 * 4. 목적지에 도착할 수 없지만 벽을 부수면 도착할 수 있는 경우
 * 5. 목적지에 도착할 수 없는 경우
 *
 *
 * [테스트케이스]
 * 1 1
 * 0
 * 실행결과: 1
 *
 * 6 4
 * 0000
 * 1110
 * 1110
 * 0010
 * 0110
 * 0000
 * 실행결과: 9
 *
 * 6 4
 * 0000
 * 1110
 * 1110
 * 0000
 * 0111
 * 0000
 * 실행결과: 9
 *
 * 6 4
 * 0000
 * 0110
 * 1110
 * 0000
 * 0111
 * 0000
 * 실행결과: 9
 *
 *
 *
 * 6 4
 * 0000
 * 0110
 * 1110
 * 0100
 * 0001
 * 0010
 * 실행결과: 9
 *
 *
 * 6 4
 * 0000
 * 0111
 * 1110
 * 0100
 * 0001
 * 0010
 * 실행결과: -1
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {


    static int[][] arr;
    static boolean[][][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        visited = new boolean[n][m][2];
        bfs(n,m);



        bw.write(ans+"");
        

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1,1}); // [3] -> 1은 벽을 부술 수 있다. 0은 벽을 부술 수 없다.
        visited[0][0][1] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == n-1 && now[1] == m-1) {
                ans = now[2];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < n && nx >=0 && nx < m){
                    if(now[3] == 1 && !visited[ny][nx][1]){
                        if(arr[ny][nx] == 0){
                            visited[ny][nx][1] = true;
                            q.add(new int[]{ny,nx, now[2] + 1, now[3]});
                        }else{
                            visited[ny][nx][0] = true;
                            q.add(new int[]{ny,nx, now[2] + 1, 0});
                        }

                    }else{
                        if(arr[ny][nx] == 0 && !visited[ny][nx][0]){
                            visited[ny][nx][0] = true;
                            q.add(new int[]{ny,nx, now[2] + 1, now[3]});
                        }
                    }

                }
            }

        }

    }
}
