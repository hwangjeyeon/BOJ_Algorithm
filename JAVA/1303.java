import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - BFS 탐색으로 문제를 해결하였다.
 * - W와 B 그리고 우리편과 적편의 힘을 각각 함수와 변수로 나눠서 처리하였다.
 * - 그 외에는 일반적인 BFS 탐색 알고리즘과 같다.
 * - 변화를 준 방식으로 하니까 확실히 코드 작성 시간이 단축되고 좋은 것 같다
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {

    static String [][] field;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int powerMe = 0;
    static int powerEnemy = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        field = new String[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                field[i][j] = s[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && field[i][j].equals("W")){
                    bfsW(n,m,i,j);
                }else if(!visited[i][j] && field[i][j].equals("B")){
                    bfsB(n,m,i,j);
                }
            }
        }

        bw.write(powerMe + " " + powerEnemy);
        br.close();
        bw.close();
    }

    private static void bfsW(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        int tmp1 = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(visited[now[0]][now[1]]){
              continue;
            }
            tmp1++;
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if(nx >= 0 && ny >=0 && ny < n && nx < m){
                    if(field[ny][nx].equals("W") && !visited[ny][nx]){
                        q.add(new int[] {ny, nx});
                    }
                }
            }

        }
        powerMe += (tmp1*tmp1);
    }

    private static void bfsB(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        int tmp1 = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(visited[now[0]][now[1]]){
                continue;
            }
            tmp1++;
            visited[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = now[1] + dx[i];
                int ny = now[0] + dy[i];
                if(nx >= 0 && ny >=0 && ny < n && nx < m){
                    if(field[ny][nx].equals("B") && !visited[ny][nx]){
                        q.add(new int[] {ny, nx});
                    }
                }
            }

        }

        powerEnemy += (tmp1*tmp1);
    }
}

