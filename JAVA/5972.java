import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 그래프 형태로 나타낼 수 있으며, 음의 가중치가 없고 양방향 간선에 가중치가 있기 때문에 다익스트라 방법을 사용하였다
 * 2. 우선순위 큐 방식을 사용하였으며, 비용을 오름차순하는 방법을 선택하였다
 * 3. 이번에는 방문 여부 체크도 하였으며, 초기값은 헛간의 개수 * 소의 개수의 최댓값 + 1한 값인 5000001로 초기화하였다
 * 4. 한가지 주의할점은 꼭 dist값 갱신하고 pq에 새로운 노드 값을 넣어주자 (다음노드숫자, dist[다음노드 비용])!
 * 
 * 해결방법:
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */

class Node{

    int number;
    int cost;

    public Node(int number, int cost) {
        this.number = number;
        this.cost = cost;
    }
}

public class Main {

    static List<Node>[] list;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 50000001);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        dijkstra(1);

        bw.write(dist[n] + "");

        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(visited[tmp.number]){
               continue;
            }
            visited[tmp.number] = true;

            for (int i = 0; i < list[tmp.number].size(); i++) {
                Node node = list[tmp.number].get(i);
                if(dist[tmp.number] + node.cost < dist[node.number]){
                    dist[node.number] = dist[tmp.number] + node.cost;
                    pq.add(new Node(node.number, dist[node.number]));
                }
            }
        }
    }

}

