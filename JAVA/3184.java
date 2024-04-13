import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * 1. BFS로 간단하게 탐색하는 문제다
 * 2. v면 늑대, o면 양의 개수를 세어줘서 주어진 조건에 맞게 더해주면 된다
 * 3. 최종적으로 완성한 각 늑대와 양의 개수를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(nm)
 *
 */

public class Main {

    static char[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[][] visited;
    static int wolf = 0;
    static int sheep = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && arr[i][j] == 'v'){
                    bfs(i,j, n, m, 'v');
                }

                if(!visited[i][j] && arr[i][j] == 'o'){
                    bfs(i,j,n,m, 'o');
                }
            }
        }

        bw.write(sheep + " " + wolf);

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x, int n, int m, char what) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;
        int tmp1 = 0;
        int tmp2 = 0;
        if (what == 'v') {
            tmp1++;
        } else if (what == 'o') {
            tmp2++;
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + now[0];
                int nx = dx[i] + now[1];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx]){
                    if(arr[ny][nx] == '.'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                    }
                    if(arr[ny][nx] == 'o'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        tmp2++;
                    }
                    if(arr[ny][nx] == 'v'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        tmp1++;
                    }
                }
            }
        }
        if(tmp1 >= tmp2){
            wolf += tmp1;
        }else{
            sheep += tmp2;
        }
    }
}

