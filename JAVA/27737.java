import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음에는 같은 위치에 버섯을 중복 배치하는 그림을 보고 굉장히 까다롭겠구나라고 생각했다
 * 2. 하지만 그림을 잘 이해하면 그냥 BFS 탐색을 해서 버섯을 미방문한 위치에 놓기만 해도 되겠다고 생각이 바뀌었다
 * 3. BFS 문제지만 약간의 변형과 예외 조건을 잘 체크해야하는 문제다
 * 4. 불가능한 예외 조건은 다음과 같다. m이 0이고, 필요한 버섯의 개수가 주어진 버섯의 개수인 m보다 많은 경우, 그리고 한번도 버섯을 심지 않은 경우다
 * 5. 이어서 변형을 해야하는 부분은 별도로 버섯을 심을 수 있는 모든 경우의 수를 세어주어야 한다는 점이다
 * 6. 따라서 void가 아닌 int형 타입으로 개수를 받아서 정답 체크와 출력을 위해 사용한다
 * 7. 또한 반환값을 넘겨줄때, 다음과 같이 넘겨준다 한번의 BFS에서 센 count 개수를 k로 나눈 몫을 넘겨준다.
 * 8. 이때 만약 나머지가 있다면 1을 추가로 더해서 넘겨준다
 * 9. 가능한 경우가 되면, m에서 count를 빼주면 정답이 된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n*n)
 * 공간복잡도: O(n*n)
 *
 */



public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int m;
    static int k;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if (m == 0) {
            bw.write("IMPOSSIBLE");
        }else{
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 0 && !visited[i][j]){
                        ans += bfs(n, i, j);
                    }
                }
            }

            if(ans > m || ans == 0){
                bw.write("IMPOSSIBLE");
            }else{
                bw.write("POSSIBLE\n");
                bw.write((m-ans)+"");
            }

        }

        br.close();
        bw.close();
    }

    private static int bfs(int n, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;
        int count = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int ny = tmp[0] + dy[i];
                int nx = tmp[1] + dx[i];
                if(ny >= 0 && nx >=0 && ny < n && nx < n && !visited[ny][nx] && arr[ny][nx] == 0){
                    q.add(new int[]{ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }


        int res = count / k;
        res += (count % k > 0 ? 1 : 0);
        return res;
    }

}

