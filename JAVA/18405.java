import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 처음 방법은 낮은 번호가 우선순위를 가지니까 낮은 숫자대로 먼저 목표 시간까지 확장하면 되지 않을까 생각했다
 * 2. 하지만 이 방법은 다시 생각해보니 원하는 결과에 도달할 수 없음을 알게 되었다
 *
 * - 문제 해결:
 * 1. BFS 방법을 사용하는데 별도의 클래스와 우선순위 큐를 이용해서 정렬 탐색을 한다
 * 2. time을 기준으로 오름차순 하고 만약 같다면 num을 기준으로 오름차순 정렬을 하는 우선순위 큐를 하나 만든다
 * 3. 이어서 그래프를 모두 탐색하면서  0이 아닌 구역의 값을 우선순위 큐에 넣어준다
 * 4. 이제 현재 시간에 +1 하는 형태로 BFS 탐색을 한다
 * 5. 완성한 결과 좌표에서 원하는 위치의 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

class Node{
    int y;
    int x;
    int num;
    int time;

    public Node(int y, int x, int num, int time) {
        this.y = y;
        this.x = x;
        this.num = num;
        this.time = time;
    }
}

public class Main {

    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
        if(o1.time == o2.time){
            return o1.num - o2.num;
        }

        return o1.time - o2.time;
    });
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]!= 0){
                    pq.add(new Node(i,j,arr[i][j],0));
                }
            }
        }

        bfs(n, s);


        bw.write(arr[x-1][y-1] + "");

        br.close();
        bw.close();
    }

    private static void bfs(int n, int end) {


        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.time == end){
                return;
            }
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(ny >= 0 && nx >= 0 && ny < n && nx < n){
                    if(arr[ny][nx] == 0){
                        arr[ny][nx] = node.num;
                        pq.add(new Node(ny,nx, node.num, node.time+1));
                    }
                }

            }


        }


    }


}

