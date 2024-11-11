import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. BFS로 푸는 문제이긴 한데, 일반적인 BFS를 살짝 변형시켜서 하는 문제다
 * 2. BFS 큐에 들어가는 배열에는 다음 값이 들어간다. 위치(y,x), 남은체력, 이동거리, 우산소유여부, 우산내구도
 * 3. ans는 못찾는 경우를 위해 -1로 처리하며, E에 도달했을 때 최댓값 갱신, 체력이 0일때나 내구도 0일때 예외처리를 해주면 된다
 * 4. 다음 위치가 U이면 우산 내구도를 1깎고 큐에 넣고, 시작위치일 경우 아무런 감소 없이 넣으며, 그 외의 경우에는 우산이 있는 경우 우산 내구도를 깎고 아닌 경우 체력을 깎는다
 * 5. 이 문제의 핵심은 방문 배열을 boolean이 아닌 int형으로 해야한다는 것이다
 * 6. 방문배열을 안 쓸수는 없다. 시간초과가 나기 때문이다. 하지만 boolean타입을 쓰면 왔던 길을 가지 못하는 문제가 발생한다
 * 7. 따라서 해결책으로 int형 배열을 만들고, 이미 방문했던 지역에 방문 했을 때의 체력 + 우산 내구도로 갱신하며, 탐색 과정에서 현재 체력 + 우산 내구도가 방문 배열에 처장해둔 값보다 클 경우 탐색 위치로 갱신하는 것이다
 * 8. 해당 방법으로 ans를 완성해서 출력하면 정답이 된다.
 *
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */

public class Main {

    static char[][] arr;
    static int[][] check;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        arr = new char[n][n];
        int[] starts = new int[2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'S') {
                    starts[0] = i;
                    starts[1] = j;
                }
            }
        }

        check = new int[n][n];
        bfs(n,h,d, starts[0], starts[1]);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int h, int d, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x,h,0,0,0});
        check[y][x] = h;
        while(!q.isEmpty()){
            int[] cur = q.poll();


            if(arr[cur[0]][cur[1]] == 'E'){
                ans = Math.max(ans,cur[3]);
                return;
            }
            if(cur[2] <= 0){
                continue;
            }


            if(cur[5] <= 0){
                cur[4] = 0;
                cur[5] = 0;
            }

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];
                if(ny >=0 && ny < n && nx >=0 && nx < n && check[ny][nx] < cur[2] + cur[5]){
                    check[ny][nx] = cur[2] + cur[5];
                    if(arr[ny][nx] == 'U'){
                        q.add(new int[]{ny, nx, cur[2], cur[3]+1, 1, d-1});
                        continue;
                    }

                    if(arr[ny][nx] == 'S'){
                        q.add(new int[]{ny, nx, cur[2], cur[3]+1, cur[4], cur[5]});
                        continue;
                    }

                    if(cur[4] == 1){
                        q.add(new int[]{ny, nx, cur[2], cur[3]+1, cur[4], cur[5]-1});
                    }else{
                        q.add(new int[]{ny, nx, cur[2]-1, cur[3]+1, cur[4], cur[5]});
                    }

                }
            }

        }

    }
}

