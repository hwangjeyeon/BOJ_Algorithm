import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이전에 코드트리에서 풀어본 문제.
 * 2. 문제를 이해만 하면 구현은 쉽게 할 수 있는 문제다
 * 3. 방문배열을 2차원 배열로 선언하고, 최대로 가능한 크기로 선언한다. 모든 드래곤 커브를 진행하며 어느 좌표를 이동할지 모르기 때문이다
 * 4. 다음 세대의 처음 방향은 바로 이전세대의 마지막부터 시작했을 때의 방향에 +1한 값이된다. 즉 이전에 방향이 상이었다면 그 다음은 좌가 된다
 * 5. 이점을 이용해서 미리 리스트에다가 드래곤 커브 시작지점을 기준으로 0번 세대부터 g번 세대까지 모든 방향을 구해둔다
 * 6. 그리고 리스트의 모든 값들을 꺼내면서 시작 좌표에 더하면서 그 좌표를 방문체크한다
 * 7. 이후 모든 좌표를 확인하며, 자신과 자신을 기준으로 우, 하, 우하 방향을 확인하며 정사각형이 되는지 확인한다. 된다면 ans를 증가시킨다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(100^2)
 * 공간복잡도: O(100^2)
 *
 */

public class Main {

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        boolean[][] visited = new boolean[101][101];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            list.add(d);
            for(int j=1; j<g+1; j++){
                for(int k=list.size()-1; k>=0; k--){
                    list.add((list.get(k)+1)%4);
                }
            }

            visited[x][y] = true;
            int nx = x;
            int ny = y;
            for (int j = 0; j < list.size(); j++) {
                int dir = list.get(j);
                nx += dx[dir];
                ny += dy[dir];
                visited[nx][ny] = true;
            }
        }


        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(visited[i][j] && visited[i+1][j]
                        && visited[i][j+1] && visited[i+1][j+1]){
                    ans++;
                }
            }
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }
}
