import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 두가지를 동시에 해결하는 문제다
 * 2. 욱제가 목적지까지 가는 경우와 벽이 내려가는 경우를 동시에 체크하면서 정답이 되는지 체크하면 된다
 * 3. 욱제가 목적지까지 가는 경우는 BFS로 해결할 수 있고, 벽이 내려가는 경우는 시뮬레이션으로 해결할 수 있다
 * 4. 하지만 두가지가 공존하기 쉽지 않다. 동기화되면서 하기에는 엄청 복잡해진다
 * 5. 따라서 선택한 방법은 어차피 8 X 8이라는 작은 제한안에서 해결하는 문제이기 때문에, 미리 시뮬레이션 상태를 저장해야겠다고 생각했다. 어차피 메모리제한도 512MB라 충분하다
 * 6. 시뮬레이션의 최대는 8이다. 왜냐하면 맨 위에 벽이 있는 경우 체스판에서 사라질 때까지 걸리는 최대 경우가 8이기 때문이다. 따라서 크기를 9로 지정해두면 여유롭게 시물레이션할 수 있다.
 * 7. bfs 탐색과 시뮬레이션을 합치기 위해서는 방문배열도 시간별로 관리되도록 해야한다. 여기서는 여유롭게 100으로 했다
 * 8. 먼저 시뮬레이션에 y축의 맨 뒤부터 시작해서 내 이전 값을 넣어주고 내 이전은 .로 바꿔준다
 * 9. 이후 BFS를 돌리면서 9반 탐색을 시작한다. 해당 시간의 방문하지 않고, 벽이 아닌 구간만 큐에 넣어 탐색을 진행한다
 * 10. 욱제가 먼저 움직이므로 만약 시뮬레이션 도중 벽인 위치에 있다면 스킵한다.
 * 11. 어떤 입력값이든지 모든 벽이 내려가는 경우는 현재 시간이 8일때 이후이다. 따라서 현재 시간이 7인 이후는 무조건 도착 가능하므로 1로 바꿔준다
 * 12. 완성한 ans를 출력하면 정답이 된다. 도착했으면 1이 될 거고, 중간에 막혔으면 0이 될 것이다
 *
 *
 * 해결방법:
 *
 * 테스트케이스:
 * [테스트 케이스]
 * ########
 * ........
 * ........
 * ........
 * ........
 * ........
 * ........
 * ........
 *
 * 실행결과: 0
 *
 *
 * #........
 * .#......
 * ..#.....
 * ...#....
 * ....#...
 * .....#..
 * ......#.
 * .......#
 *
 * 실행결과: 1
 *
 * .......#
 * ......#.
 * .....#..
 * ....#...
 * ...#....
 * ..#.....
 * .#......
 * ........
 *
 * 실행결과: 1
 *
 *
 * 시간복잡도: O(9*7*8)
 * 공간복잡도: O(9*8*8)
 *
 */


public class Main {

    static char[][] arr; // 원본 입력 뱅려
    static char[][][] simulate; // 시뮬레이션 별 상태 저장
    static boolean[][][] visited; // 탐색시간 별 방문배열
    static int ans = 0;
    static int[] dx = {-1,-1,-1,0,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,0,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new char[8][8];
        simulate = new char[9][8][8];
        visited = new boolean[100][8][8];
        for (int i = 0; i < 8; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j);
                simulate[0][i][j] = arr[i][j];
            }
        }

        // 시뮬레이션 결과 먼저 저장
        for (int i = 1; i < 9; i++) {
            for (int j = 7; j > 0; j--) {
                for (int k = 0; k < 8; k++) {
                    simulate[i][j][k] = simulate[i-1][j-1][k];
                    simulate[i][j-1][k] = '.';
                }
            }
        }


        // 욱제의 목적지까지 탐색 bfs 시작
        bfs();

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{7,0,0});
        visited[7][0][0] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(simulate[now[2]][now[0]][now[1]] == '#'){
                continue;
            }
            if(now[2] > 7){
                ans = 1;
                return;
            }

            for (int i = 0; i < 9; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < 8 && nx >= 0 && nx < 8 && !visited[now[2]][ny][nx] && simulate[now[2]][ny][nx] == '.'){
                    q.add(new int[]{ny,nx,now[2]+1});
                    visited[now[2]][ny][nx] = true;
                }
            }

        }

    }

}
