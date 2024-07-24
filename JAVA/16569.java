import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 처음에 풀었던 입력값을 큐나 큐배열로 받고 화산 쇄설류에 대한 상태를 기록하는 2차원 배열과, 높이를 저장하는 2차원 배열을 각각 분리하여 관리하도록 하였다
 * 2. 이후 1초부터 최대 초인 200초까지 1초가 지날때마다 상태가 업데이트 되는 로직을 구현하였다
 * 3. 하지만 이 방법은 메모리 초과가 발생하였고, 다시 계산해보니 상하좌우 4가지 경우에 최대 200초이니 4^200이라는 최악의 공간복잡도가 발생할 수 있음을 알게 되었다
 * 4. 따라서 이 방법은 포기하고 다른 방법을 몰색하게 되었다.
 *
 *
 * 해결방법:
 * 1. 해결한 방법은 먼저 하나의 배열에 높이와 시간정보를 모두 보관하도록 한다. 이때 시간정보 초기값은 Integer.MAX_VALUE로 하여 최초 입력값에 한하여 최소값으로 갱신되도록 한다
 * 2. 이후 화산의 위치에 대해서는 입력마다 2차원 배열을 순회하여 그 위치의 시간을 0으로 만들어준다
 * 3. 그 이외의 위치에 대해서는 이후 화산학자가 탐색하기 전에 시간에 대한 세팅을 해놔야 한다
 * 4. 따라서 해당 화산 위치 이외에는 현재 입력으로 들어온 화산의 위치에서 폭발하는 시간 + |u-x| + |v-y| 값을 해야한다
 * 5. 이때 방문 배열은 따로 안 만들어졌기에, 더 시간이 지난 이후에 덮어 씌워질 수도 있어서 먼저 도착하는 가장 짧은 시간으로만 덮어지도록 현재 배열의 위치의 시간과 Math.abs(a-y) + Math.abs(b-x) + c를 비교하여 더 작은 값을 넣어준다
 * 6. 이후 BFS를 돌아 준다. 최초 시간에 대해서는 1로 초기화해준다. 참고로 ans에는 예외 상황으로 초기 위치에서 더 움직일 수 없을 수도 있기 때문에 처음 위치로 지정해두었다
 * 7. 방문배열도 하나 만들고 초기 위치를 큐에다가 넣어준다.
 * 8. 이후 시간 구분을 위해 새로운 방문을 저장할 외부 큐와 그 내부에 임시로 누적된 큐 위치에 대해서만 탐색할 tmp 큐를 하나 만들어둔다
 * 9. tmp큐가 빌 동안 상하좌우 탐색을 하면서 범위를 벗어나지 않으면 방문 체크와 외부 큐에다가 넣어주고, 만약 현재 높이가 ans보다 크다면 ans로 값을 갱신하고 현재 시간도 갱신해준다
 * 10. 하나의 내부 큐 탐색이 끝나면 현재 시간을 증가시킨다.
 * 11. 완성한 ans와 ansTime을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(vnm)
 * 공간복잡도: O(nm)
 *
 */

class Position{
    int y;
    int x;

    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Volcanic{
    int height;
    int time = 0;

    public Volcanic(int height, int time) {
        this.height = height;
        this.time = time;
    }
}


public class Main {

    static Volcanic[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static long ans = 0;
    static long ansTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new Volcanic[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = new Volcanic(Integer.parseInt(st.nextToken()), Integer.MAX_VALUE);
            }
        }

        ans = arr[y][x].height;

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 1; j < m+1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if(a == j && b == k){
                        arr[j][k].time = 0;
                    }else{
                        int tmp = Math.abs(a - j) + Math.abs(b - k);
                        arr[j][k].time = Math.min(arr[j][k].time, c + tmp);
                    }
                }
            }
        }

        bfs(m,n,y,x);



        bw.write(ans + " "+ ansTime);

        br.close();
        bw.close();
    }

    private static void bfs(int m, int n, int y, int x) {
        Queue<Position> q = new LinkedList<>();
        int nowTime = 1;
        boolean[][] visited = new boolean[m + 1][n + 1];
        q.add(new Position(y, x));


        while (!q.isEmpty()) {
            Queue<Position> tmp = new LinkedList<>(q);
            q.clear();
            while (!tmp.isEmpty()) {
                Position pos = tmp.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + pos.y;
                    int nx = dx[i] + pos.x;
                    if (ny >= 1 && ny <= m && nx >= 1 && nx <= n && !visited[ny][nx]) {
                        if (arr[ny][nx].time > nowTime) {
                            q.add(new Position(ny, nx));
                            visited[ny][nx] = true;
                            if (ans < arr[ny][nx].height) {
                                ans = arr[ny][nx].height;
                                ansTime = nowTime;
                            }
                        }
                    }
                }
            }
            nowTime++;
        }
    }
}

