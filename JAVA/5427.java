import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. wxh가 10^6이고, 탈출 가능한 빠른 시간을 찾는 문제이기 때문에, BFS를 이용해서 문제를 해결했다
 * 2. 이 문제의 고민 포인트는 어떻게 불의 번짐과 사람의 이동을 시간별로 동기화할 수 있는가이다
 * 3. 처음 선택한 방법은 우선순위 큐와 시간정보까지 가지고 있는 3차원 방문배열을 활용하는 것이었다
 * 4. 하지만 이 방법의 문제점은 시간의 최대치를 고려해서 10^6을 선언해야하는데, 이렇게 될 경우 메모리 초과가 일어날 가능성이 있다고 판단했다
 * 5. 따라서 해당 방법은 포기했고 다른 방법을 고민했다
 * 6. 두번째 방법은 사람의 정보와 불의 정보를 각각의 큐에 보관하는 것이다
 * 7. 그리고 사람의 큐가 빌때까지 탐색하면서, 먼저 불의 번짐을 갱신한 뒤 이어서 사람의 이동을 갱신하는 것이다
 * 8. 이렇게 하면 사람은 동일한 시간 때에 이미 번저있는 불의 위치로는 가지 않을 것이고 출구를 향해 갈 것이다
 * 9. 이 문제는 탐색 범위 내에 도착지점이 없다. 따라서 w+2, h+2로 모서리를 한칸씩 늘려서 그 지점에 도달하면 탈출한 것으로 간주하도록 했다
 * 10. 먼저 -로 도배한 다음 이어서 입력값을 범위 내에 초기화하면 완성된다. 그리고 가장 먼저 모서리에 도달하는 경우, 지금까지의 이동거리를 ans로 하면 된다
 * 11. 만약 ans가 0이라면 불가능하고, 아니라면 해당 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(t x h x w)
 * 공간복잡도: O(t x h x w)
 *
 */
public class Main {

    static int w;
    static int h;
    static char[][] arr;
    static int ans = 0;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h+2][w+2];
            int[] start = new int[2];
            List<int[]> fire = new ArrayList<>();
            ans = 0;
            for (int i = 0; i < h+2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    arr[i][j] = '-';
                }
            }

            for (int i = 1; i < h+1; i++) {
                String s = br.readLine();
                for (int j = 1; j < w+1; j++) {
                    arr[i][j] = s.charAt(j-1);
                    if(arr[i][j] == '@'){
                        start[0] = i;
                        start[1] = j;
                    }
                    if(arr[i][j] == '*'){
                        fire.add(new int[]{i,j});
                    }
                }
            }
            bfs(start, fire);

            if(ans == 0){
                bw.write("IMPOSSIBLE\n");
            }else{
                bw.write(ans + "\n");
            }
        }

        br.close();
        bw.close();
    }

    private static void bfs(int[] start, List<int[]> fire) {
        Queue<int[]> people = new LinkedList<>();
        Queue<int[]> fired = new LinkedList<>();
        people.add(new int[]{start[0], start[1], 0});
        for (int i = 0; i < fire.size(); i++) {
            fired.add(new int[]{fire.get(i)[0], fire.get(i)[1]});
        }
        while(!people.isEmpty()){
            int size = fired.size();

            for (int i = 0; i < size; i++) {
                int[] now = fired.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];
                    if(isRange(ny, nx) && (arr[ny][nx] == '.' || arr[ny][nx] == '@')){
                        arr[ny][nx] = '*';
                        fired.add(new int[]{ny, nx});
                    }
                }
            }
            size = people.size();
            for (int i = 0; i < size; i++) {
                int[] now = people.poll();
                if(arr[now[0]][now[1]] == '-'){
                    ans = now[2];
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int ny = now[0] + dy[j];
                    int nx = now[1] + dx[j];
                    if(isRange(ny, nx) && (arr[ny][nx] == '.' || arr[ny][nx] == '-')){
                        if(arr[ny][nx] != '-'){
                            arr[ny][nx] = '@';
                        }
                        people.add(new int[]{ny,nx, now[2] + 1});
                    }
                }
            }
        }

    }

    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && ny < h+2 && nx >= 0 && nx < w+2;
    }
}
