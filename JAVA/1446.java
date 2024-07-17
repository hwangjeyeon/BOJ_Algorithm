import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 해당 문제 해결에는 다양한 방법이 있는데, 그중 다익스트라 방법을 이용하여 해결하였다
 * 2. 먼저 다익스트라를 위해서는 그래프를 구성해야한다. 이 방법은 기준 우선순위큐를 이용하는 다익스트라 방법과는 조금 다르게, d까지 한칸씩 이동하면서, 최소 거리를 찾는 방법이다
 * 3. dist는 최대입력값인 100001로 초기화해주고, 각 dist는 자신의 인덱스 번호만큼의 이동 비용을 갖기 때문에 i로 초기화를 해준다
 * 4. 이어서 주어진 지름길을 a그래프에서 b그래프로 방향 그래프를 하나 이어주고, c를 그 비용으로 정의해준다
 * 5. 0부터 시작해서 다익스트라를 돌려준다. 현재 위치가 d보다 크면 종료한다
 * 6. 만약 다음지점이 현재지점에서 + 1한 값보다 크면, 다음 지점에 현재지점 + 1을 넣어준다. 이것은 현재 지점이 지름길로 더 작은 값으로 초기화되었을 때, 그 최소 값으로 누적해나가기 위함이다.
 * 7. 이어서 현재 지점에 연결된 지름길이 있는지 확인한다. 현재 지점에서 지름길의 비용을 더한 값보다 지름길을 이용해서 도착한 곳의 값이 더 클 경우, 도착한 곳의 값을 현재 지점에서 지름길의 비용을 더한 값으로 초기화한다
 * 8. 이렇게 완성한 후, d지점의 값을 출력하면 정답이 된다.
 * 
 * 시간복잡도: O(n*d)
 * 공간복잡도: O(1)
 *
 */

class Node {
    int number;
    int cost;

    public Node(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}



public class Main {

    static List<Node>[] nodes;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        dist = new int[10001];
        for (int i = 0; i < 10001; i++) {
            dist[i] = i;
        }
        nodes = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b,c));
        }

        dijkstra(0, d);

        bw.write(dist[d]+"");

        br.close();
        bw.close();
    }

    private static void dijkstra(int now, int end) {
        if(now > end){
            return;
        }

        if(dist[now + 1] > dist[now] + 1){
            dist[now + 1] = dist[now] + 1;
        }

        for (int i = 0; i < nodes[now].size(); i++) {
            if(dist[now] + nodes[now].get(i).cost < dist[nodes[now].get(i).number]){
                dist[nodes[now].get(i).number] = dist[now] + nodes[now].get(i).cost;
            }
        }

        dijkstra(now + 1, end);
    }

}

