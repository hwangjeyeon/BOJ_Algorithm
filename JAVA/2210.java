import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 좌표 평면이 나오면 다음 방법들을 생각해볼 수 있다, 브루트포스, 그래프 완전탐색(DFS, BFS), DP
 * 2. 좌표평면의 크기가 5x5로 고정되어 있기 때문에 dp를 활용할 필요는 없어 보인다
 * 3. 그럼 그래프 완탐 중에서는 어떤 것을 선택해야할까? 먼저 한 방향으로만 이어지는 것도 아니고 자유롭게 탐색 도중 방향을 다르게 선택할 수 있다
 * 4. 한가지 더 살펴보자면 선택한 문자열을 종료 시점까지 유지해야한다.
 * 5. 위 조건을 봤을 때, 가장 적합한 것은 DFS로 보인다. 마침 깊이도 6이고 상하좌우 탐색이라는 4가지 경우에 대해서만 재귀를 돌리면 되기 때문이다
 * 6. 따라서 DFS를 선택하였다
 * 7. 이어서 한가지 더 살펴봐야하는데, 임의의 위치에 시작해서라는 조건이 있으므로 어디서든 시작할 수 있다
 * 8. 따라서 브루트포스로 모든 좌표를 시작으로 했을 때 DFS 탐색을 돌려야 한다.
 * 9. 이때 시간복잡도는 5 * 4^6이기 때문에 시간제한 문제는 해결된다
 * 10. 상하좌우 탐색을 편하게 하기 위해 dy, dx를 활용하였다. 범위를 벗어나지 않을 때 해당 좌표로 이동하고 현재 문자열도 추가해준다
 * 11. depth가 6이 되면 이제 그 문자열을 만들 수 있다고 판단한다
 * 12. 이때 주의해야할 것은 서로 다른 여섯 자리의 수들의 개수를 구하는 것이므로 중복을 허용하면 안된다
 * 13. 따라서 문자열들을 관리하기 위해 Set 자료구조를 선택하였다.
 * 14. 마지막 출력은 가능한 서로 다른 여섯 자리의 수들의 개수이므로 set의 크기를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(5 * 5 * 4^6)
 * 공간복잡도: O(5*5)
 *
 */


public class Main {

    static int[][] arr;
    static Set<String> set = new HashSet<>();
    static int[] dy = {0,0,1,-1};
    static int[] dx = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }

        bw.write(set.size()+"");

        br.close();
        bw.close();
    }

    private static void dfs(int y, int x, int depth, String s) {
        if(depth == 6){
            set.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < 5 && nx >= 0 && nx < 5){
                dfs(ny, nx, depth+1, s + arr[ny][nx]);
            }
        }
    }

}
