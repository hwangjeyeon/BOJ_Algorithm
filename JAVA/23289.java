import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 깡구현 문제. 진짜 복잡한 문제다
 * 2. 고려해야할 사항이 엄청 많다. 온풍기의 위치, 검증할 위치, 벽의 위치, 누적합산 온도, 임시합산 온도를 모두 관리해야한다
 * 3. 탐색 편의 메소드를 사용하는 것이 좋다. 온도조절 로직을 위해 상하좌우 확인이랑 온풍기 바람 전달을 위한 특수 2차원 배열을 만든다
 * 4. 벽 설치 위치를 1부터 시작하는 값으로 주기 때문에 편하게 하기 위해 r+1 c+1로 구현했다
 * 5. 벽을 확인하기 위해 boolean 4차원 배열을 선언했다. 앞에 두 인덱스는 이전, 뒤의 두 인덱스는 이후다. 0일때와 1일때를 구분해서 설치하자
 * 6. 동작은 BFS로 구현했다. 중복탐색을 없애기 위해 방문배열도 선언했다
 * 7. 처음 온도는 5이기 때문에 해당 값을 임시 온도 배열에 합산한다
 * 8. 큐에 넣고 진행하는데, 처음 온도가 5인 지점부터 시작한다. 이때, 거리를 2로 해서 5를 초과할 경우 종료하도록 한다
 * 9. 범위 내에 있고, 방문하지 않았고, 벽이 없다면 탐색해서 큐에 넣는다. 방문 체크하고 임시 온도 배열에 처음 5도 - 거리 + 1을 합산한다
 * 10. 이렇게 모든 온풍기를 실행한 뒤, 누적합산 온도 배열에 해당 값들을 더해준다. (임시합산 온도 배열은 이후 몇번 재활용할 것이기 때문!)
 * 11. 이후 온도를 조절해야한다. 임시 온도 배열을 재활용하기 위해 새 인스턴스를 생성한다
 * 12. 배열을 순회하면서 0인 지점은 스킵하고, 그 이외에 대해 상하좌우를 탐색한다
 * 13. 범위를 벗어나거나 벽이 있는 경우는 건너뛰고, 그 외의 경우에는 현재 지점이 상하좌우 지점보다 온도가 더 높으면 두 지점의 차를 계산해서 이전 지점은 빼고 이후지점은 합산한다
 * 14. 이후 임시 온도 배열의 값을 누적합산 배열에 합산하고 만약 현재가 가장자리라면 온도를 1만큼 감소한다
 * 15. 이제 앞서 미리 리스트에 넣어둔 검증할 위치를 모두 확인하며, k보다 작은 곳이 있는지 확인한다. 만약 있다면 다시 위 과정을 반복하고 아니라면 그대로 종료 한다
 * 16. ans가 100보다 크다면 101로 바꾸고 출력하고 아니라면 그대로 ans를 출력한다.
 * 17. 위 과정을 진행하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(r*c)
 * 공간복잡도: O(r*c)
 *
 */


public class Main {


    static int r;
    static int c;
    static int k;
    static int[][] arr;
    static int w;
    static boolean[][][][] wall;
    static List<int[]> heaters;
    static List<int[]> check;
    static int[][] temp;
    static int[][] dx = {{0,0,0},{0,-1,1},{0,-1,1},{-1,-1,-1},{1,1,1}};
    static int[][] dy = {{0,0,0},{1,1,1},{-1,-1,-1},{0,-1,1},{0,-1,1}};
    static int[] ddx = {0,0,0,-1,1};
    static int[] ddy = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[r+1][c+1];
        temp = new int[r+1][c+1];
        check = new ArrayList<>();
        heaters = new ArrayList<>();
        for (int i = 1; i < r+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < c+1; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a >= 1 && a <= 4){
                    heaters.add(new int[]{i,j, a});
                }
                if(a == 5){
                    check.add(new int[]{i,j});
                }
            }
        }
        w = Integer.parseInt(br.readLine());
        wall = new boolean[r+1][c+1][r+1][c+1];


        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            if(type == 0){
                wall[x][y][x-1][y] = true;
                wall[x-1][y][x][y] = true;
            }else{
                wall[x][y][x][y+1] = true;
                wall[x][y+1][x][y] = true;
            }
        }
        int ans = 0;
        while(ans <= 100){
            solve();
            adjust();
            ans++;
            if(checks()){
                break;
            }
        }

        if(ans > 100){
            ans = 101;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void adjust() {
        temp = new int[r+1][c+1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if(arr[i][j] == 0){
                    continue;
                }
                for (int l = 1; l < 5; l++) {
                    int nx = i + ddx[l];
                    int ny = j + ddy[l];
                    if(!isRange(nx, ny) || wall[i][j][nx][ny]){
                        continue;
                    }
                    if(arr[i][j] > arr[nx][ny]){
                        int tmp = (arr[i][j] - arr[nx][ny])/4;
                        temp[i][j] -= tmp;
                        temp[nx][ny] += tmp;
                    }
                }
            }
        }

        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                arr[i][j] += temp[i][j];
                if(i == 1 || j == 1 || i == r || j == c){
                    if(arr[i][j] > 0){
                        arr[i][j]--;
                    }
                }
            }
        }
    }

    private static boolean checks() {
        for (int[] a : check) {
            int x = a[0];
            int y = a[1];
            if (arr[x][y] < k) {
                return false;
            }
        }
        return true;
    }

    private static void solve() {
        temp = new int[r+1][c+1];
        for (int[] heater : heaters) {
            operate(heater[0], heater[1], heater[2]);
        }

        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    }

    private static void operate(int x, int y, int dir) {
        boolean[][] visited = new boolean[r+1][c+1];
        Queue<int[]> q = new LinkedList<>();
        int now = 5;
        int nx = x + ddx[dir];
        int ny = y + ddy[dir];

        visited[nx][ny] = true;
        temp[nx][ny] += 5;
        q.add(new int[]{nx, ny, 2});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[2] > 5){
                continue;
            }

            for (int i = 0; i < 3; i++) {
                nx = cur[0] + dx[dir][i];
                ny = cur[1] + dy[dir][i];
                if(!isRange(nx, ny) || visited[nx][ny] || isWall(cur[0], cur[1], nx, ny, dir)){
                    continue;
                }
                visited[nx][ny] = true;
                temp[nx][ny] += now - cur[2] + 1;
                q.add(new int[]{nx,ny,cur[2]+1});
            }
        }
    }

    private static boolean isWall(int x, int y, int xx, int yy, int dir) {
        if(x == xx || y == yy) {
            if (wall[x][y][xx][yy]) {
                return true;
            }
        }else{
            if(dir == 1 || dir == 2){
                if(wall[x][y][xx][y] || wall[xx][y][xx][yy]){
                    return true;
                }
            }else{
                if(wall[x][y][x][yy] || wall[x][yy][xx][yy]){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isRange(int x, int y) {
        if(x > 0 && x <= r && y > 0 && y <= c){
            return true;
        }
        return false;
    }
}
