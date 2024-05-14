

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 문제 해결의 키포인트는 BFS와 우선순위 큐이다.
 * 2. 주어진 조건에 맞추기 위해 우선순위 큐가 다음과 같이 정렬되도록 한다
 * 3. 일단 가장 가까운 조건에 맞추기 위해 count를 기준으로 오름차순 정렬, 같은 경우 위쪽 방향으로 가도록 y축 오름차순 정렬, 같은경우 왼쪽 방향으로 가도록 x축 오름차순 정렬을 하면 된다
 * 4. 기존 BFS랑 다르게 우선순위 큐를 이용해서 bfs 탐색을 진행한다
 * 5. 탐색할 때는 size가 같거나 작은 경우 넣어주고, 탐색 도중 만약 해당 위치가 0이 아니면서 size가 작은 경우에만 먹어주고 현재 count를 정답 count에 더해준다
 * 6. 이어서 현재 위치로 갱신하도록 start를 설정해주고 아기 상어가 물고기를 먹었는지 여부를 체크하는 chk를 true로 바꿔준다
 * 7. 탐색 후에는 먼저 물고기 먹었는지 체크를 확인하고 안먹으면 break하고 정답인 count를 출력하낟
 * 8. 만약 먹었으면 size랑 eat가 같은경우 size++하고 eat를 0으로 초기화한다
 * 
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

class Pos{

    int y;
    int x;
    int count;

    public Pos(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}

public class Main {

    static int count = 0;
    static boolean[][] visited;
    static int[] dy = {-1,0,0,1};
    static int[] dx = {0,-1,1,0};
    static int[][] arr;
    static int size = 2;
    static int eat = 0;
    static boolean chk;
    static Pos start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                  start = new Pos(i,j, 0);
                  arr[i][j] = 0;
                }
            }
        }
        while(true){

            chk = false;
            bfs(n,start);

            if(!chk){
                break;
            }

            if(size == eat){
                size++;
                eat = 0;
            }
        }


        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void bfs(int n, Pos s) {
        PriorityQueue<Pos> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.count == o2.count){
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            }
            return o1.count - o2.count;
        });

        pq.add(s);
        visited = new boolean[n][n];
        visited[s.y][s.x] = true;

        while(!pq.isEmpty()){
            Pos now = pq.poll();

            if(arr[now.y][now.x] != 0 && arr[now.y][now.x] < size){
                arr[now.y][now.x] = 0;
                eat++;
                count += now.count;
                start.count = 0;
                start.y = now.y;
                start.x = now.x;
                chk = true;
                return;
            }


            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if(ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]){
                    if(arr[ny][nx] <= size){
                        pq.add(new Pos(ny, nx, now.count+1));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

    }
}

