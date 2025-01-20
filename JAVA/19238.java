import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. BFS와 시뮬레이션 및 구현을 섞어서 해결하는 문제다
 * 2. 우선순위 큐를 적극적으로 활용하면 쉽게 해결할 수 있다. 거리 오름차순 정렬을 최우선으로 하고 이어서 행과 열을 차례대로 기준으로 한다
 * 3. 우선순위 큐를 활용하는 BFS를 두가지 구현하면 된다. 첫번째는 승객을 찾아서 그 위치로 가는 것이고 두번째는 그 승객의 위치에서 승객의 목적지까지 가는 것이다
 * 4. 승객을 찾는 bfs는 제일 먼저 찾는 승객의 위치를 0으로 바꾸고 연료를 거리만큼 감소시킨다. 그리고 태우는 승객을 리턴한다. 만약 아무도 없다면 0을 리턴한다
 * 5. 그 위치로 가는 BFS는 승객의 목적지에 도착한 경우, 위와 똑같이 진행하는데 마지막에 추가로 연료를 2배로 곱해준다
 * 6. 두 과정 중 만약 연료가 0이하라면 실패로 간주한다
 * 7. 위 과정에서 승객을 찾지 못하거나 만약 가지 못하는 경우가 발생한다면 정답을 ans로 하고 종료시키며, 아닐 경우 모든 승객을 태울때까지 시뮬레이션을 하며 ans를 남은 연료로 바꾼다
 * 8. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(m x logn^2)
 * 공간복잡도: O(n^2)
 *
 */
class Client{
    int startY;
    int startX;
    int endY;
    int endX;

    public Client(int startY, int startX, int endY, int endX) {
        this.startY = startY;
        this.startX = startX;
        this.endY = endY;
        this.endX = endX;
    }

}

class Taxi{
    int nowY;
    int nowX;
    int dist;

    public Taxi(int nowY, int nowX, int dist) {
        this.nowY = nowY;
        this.nowX = nowX;
        this.dist = dist;
    }
}

public class Main {

    static int n;
    static int m;
    static int fuel;
    static int[][] arr;
    static int ans = -1;
    static Client[] clients;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int startY;
    static int startX;
    static List<int[]> dist;
    static boolean isOk = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    arr[i][j] = -1;
                }
            }
        }
        clients = new Client[m+1];
        st = new StringTokenizer(br.readLine());
        startY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[a][b] = i;
            clients[i] = new Client(a,b,c,d);
        }
        dist = new ArrayList<>();
        while(m --> 0) {
            int client = findClient();
            if(client == 0 || !isOk){
                ans = -1;
                break;
            }
            bfs(clients[client].startY, clients[client].startX, clients[client].endY, clients[client].endX);
            startY = clients[client].endY;
            startX = clients[client].endX;

            if(!isOk){
                ans = -1;
                break;
            }
            ans = fuel;
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int findClient() {
        visited = new boolean[n+1][n+1];
        PriorityQueue<Taxi> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist == o2.dist){
                if (o1.nowY == o2.nowY){
                    return o1.nowX - o2.nowX;
                }
                return o1.nowY - o2.nowY;
            }
            return o1.dist - o2.dist;
        });
        pq.add(new Taxi(startY, startX, 0));
        visited[startY][startX] = true;
        while(!pq.isEmpty()){
            Taxi now = pq.poll();
            if(arr[now.nowY][now.nowX] != 0){
                fuel -= now.dist;
                if(fuel < 0){
                    isOk = false;
                }
                int meet = arr[now.nowY][now.nowX];
                arr[now.nowY][now.nowX] = 0;
                return meet;
            }
            for (int i = 0; i < 4; i++) {
                int ny = now.nowY + dy[i];
                int nx = now.nowX + dx[i];
                if(isRange(ny, nx) && arr[ny][nx] != -1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    pq.add(new Taxi(ny,nx, now.dist + 1));
                }
            }
        }

        return 0;
    }

    private static void bfs(int startY, int startX, int endY, int endX) {
        visited = new boolean[n+1][n+1];
        PriorityQueue<Taxi> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.dist == o2.dist){
                if (o1.nowY == o2.nowY){
                    return o1.nowX - o2.nowX;
                }
                return o1.nowY - o2.nowY;
            }
            return o1.dist - o2.dist;
        });
        pq.add(new Taxi(startY,startX,0));
        visited[startY][startX] = true;
        while(!pq.isEmpty()){
            Taxi now = pq.poll();

            if(now.nowY == endY && now.nowX == endX){
                fuel -= now.dist;
                if(fuel < 0){
                    isOk = false;
                }
                fuel += now.dist*2;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.nowY + dy[i];
                int nx = now.nowX + dx[i];
                if(isRange(ny, nx) && arr[ny][nx] != -1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    pq.add(new Taxi(ny,nx, now.dist + 1));
                }
            }

        }
        isOk = false;

    }

    private static boolean isRange(int y, int x){
        return y > 0 && y <= n && x > 0 && x <= n;
    }


}
