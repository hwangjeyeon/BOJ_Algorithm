import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 그냥 bfs로 탐색해주면 되는 쉬운 문제다.
 * 2. 탐색의 시작은 맨 첫줄 x좌표 길이만큼씩 다 탐색을 시도해보면 되고, 정답의 결정은 각 탐색 마지막에 마지막 줄을 x좌표 길이만큼 다 확인해서 방문했고 해당 배열이 0인 경우를 찾으면 된다.
 * 3. 결과에 따라 YES와 NO를 출력하면 정답이 된다.
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(nm)
 *
 */

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean isOk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            visited = new boolean[n][m];
            bfs(n,m,i);
            if(isOk){
                break;
            }
        }

        if(isOk){
            bw.write("YES");
        }else{
            bw.write("NO");
        }
        
        br.close();
        bw.close();
    }

    static void bfs(int n, int m, int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, start});
        visited[0][start] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]){
                    if(arr[ny][nx] == 0){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        }
        if(arrived(n,m)){
            isOk = true;
        }
    }

    private static boolean arrived(int n, int m) {

        for (int i = 0; i < m; i++) {
            if(visited[n-1][i] && arr[n-1][i] == 0){
                return true;
            }
        }

        return false;
    }


}

