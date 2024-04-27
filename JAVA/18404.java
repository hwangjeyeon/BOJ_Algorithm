import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 탐색 방법으로 bfs 탐색을 진행하면 되는 문제다
 * 2. 첫 방식에서 시간초과가 발생하였는데, 각 m마다 방문 배열과 arr 배열을 초기화하는 방법에서 발생하였다
 * 3. 계산해보니 n*m에 추가로 m을 더 곱하게 되는데 그럴 경우 주어진 최대 입력값을 봤을 때 최악의 경우 5억이라는 입력이 들어온다 따라서 시간초과가 발생한다
 * 4. 어차피 arr에 누적해나가는 방식이라 추가로 m을 더 곱할 필요는 없다. 따라서 그냥 bfs 탐색 한번만 해주고 출력해주면 정답이 된다.
 * 
 * 해결방법:
 *
 *
 * 시간복잡도: O(NM)
 * 공간복잡도: O(NM)
 *
 */



public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-2, -2, -1, -1, +1, +1, +2, +2};
    static int[] dx = {-1, +1, -2, +2, -2, +2, -1, +1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1][n+1];
        arr = new int[n+1][n+1];

        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list.add(new int[] {y,x});
        }
        for (int i = 0; i < m; i++) {
            bfs(Y,X,n,list.get(i)[0],list.get(i)[1]);
            bw.write(arr[list.get(i)[0]][list.get(i)[1]] +" ");
        }

        br.close();
        bw.close();
    }

    private static void bfs(int y, int x, int n, int arriveY, int arrivedX) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {y,x, 0});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 8; i++) {
                int ny = dy[i] + now[0];
                int nx = dx[i] + now[1];

                if(ny>0 && nx>0 && ny <= n && nx<= n && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[] {ny,nx,now[2]+1});
                    arr[ny][nx] = now[2]+1;
                }

            }


        }

    }
}

