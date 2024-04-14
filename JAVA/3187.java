import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 이전 양 거의 똑같은 문제다. bfs로 완전탐색해서 찾았고, 방문배열 역시 이용하였다
 * 2. 또한 탐색 완료 후, 해당 영역의 늑대와 양의 수를 비교해서 늑대가 더크거나 같으면 늑대만 넣고 양이 더 크면 양만 수를 세어주었다
 * 3. 완성한 양과 늑대의 수를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(rc)
 * 공간복잡도: O(rc)
 *
 */

public class Main {

    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int wolf = 0;
    static int sheep = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && arr[i][j] == 'v') {
                    bfs(i,j,r,c,'v');
                }
                if(!visited[i][j] && arr[i][j] == 'k'){
                    bfs(i,j,r,c,'k');
                }
            }
        }

        bw.write(sheep + " " + wolf);

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x, int r, int c, char what) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x]= true;
        int tmp1 = 0;
        int tmp2 = 0;
        if(what == 'v'){
            tmp1 = 1;
        }
        if(what == 'k'){
            tmp2 = 1;
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(nx >=0 && ny >=0 && ny <r && nx < c && !visited[ny][nx]){
                    if(arr[ny][nx] == '.'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                    }
                    if(arr[ny][nx] == 'v'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny,nx});
                        tmp1++;
                    }
                    if(arr[ny][nx] == 'k'){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        tmp2++;
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

