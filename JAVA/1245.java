import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. BFS탐색을 선택하는 것은 맞으나 조금 다르게 선택해야한다.
 * 2. 이 문제는 산봉우리를 찾는 것이다. 산봉우리란 결국 같은 높이를 가지는 하나의 격자 혹은 인접한 격자들의 집합으로 이루어져 있다
 * 3. 이때 인접하다의 조건 때문에 8방 탐색을 진행해야한다
 * 4. 산봉우리와 인접한 격자는 모두 산봉우리의 높이보다 작아야한다
 * 5. 따라서 브루트포스 탐색을 하면서 방문을 하지 않았다면 bfs탐색을 진행하는데, 현재 지점에서 8방 좌표 면 중에 자신보다 큰 높이가 있으면 산봉우리가 아닌 것을 의미한다
 * 6. 따라서 해당 경우는 방문 여부와 상관없이 플래그 역할을 해줄 top을 false로 바꾸어준다
 * 7. 만약 같은 높이가 있다면 탐색을 더해서 해당 높이보다 더 큰 산봉우리가 있는지 주위를 탐색해야한다. 따라서 BFS 탐색을 위해 해당 위치를 큐에 넣고 방문체크를 한다
 * 8. 탐색 종료 후에, 현재 높이가 모든 좌표에서의 최소 높이보다 높은지와, top 플래그가 true인지 체크하고 만약 해당된다면 count++를 해준다
 * 9. 이때 현재 높이가 모든 좌표에서의 최소 높이보다 높은지를 한번 더 체크해주는 이유는 0인데 주위에 인접한 높은 높이가 없는 경우를 제외하기 위함이다.
 * 10. 탐색 관점을 조금 다르게 해서 푸는 문제였다. 이후 다시 풀어볼 예정이다.  
 *
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(nm)
 *
 */



public class Main {

    static int[][] field;
    static int[] dx = {-1,-1,-1, 0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int count = 0;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, field[i][j]);
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    bfs(n,m,i,j);
                }
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int m, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x});
        visited[y][x] = true;
        boolean top = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            boolean isOk = true;
            if(isOk){
                for (int i = 0; i < 8; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(ny >= 0 && nx >=0  && ny < n && nx < m ){
                        if(field[ny][nx] > field[y][x]){
                            top = false;
                        }else if(!visited[ny][nx] && field[ny][nx] == field[y][x]){
                            visited[ny][nx] = true;
                            q.add(new int[] {ny,nx});
                        }
                    }
                }
            }
        }
        if(top && field[y][x] > min){
            count++;
        }



    }
}

