import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 다익스트라 알고리즘을 구현해서 푸는 문제이다
 * - 이전에 구현했던 다익스트라 알고리즘 구현을 참고해서 풀었다
 * - 각 정점의 정보를 가질 Node 클래스를 만든다. 이때 이 Node 클래스는 Comparable<Node>를 구현해야하는데, 우선순위 큐에 사용될 것이기 때문이다
 * - 필드로는 연결 정점의 정보를 가지는 index와 간선의 가중치를 의미하는 cost로 구성된다
 * - 생성자를 통해 초기화되며 CompareTo를 구현하여, Integer.compare로 현재 클래스 필드의 가중치와 파라미터로 들어온 가중치를 비교한다
 * - ArrayList<Node>[] graph는 연결된 노드들의 정보 리스트를 담은 배열을 말한다.
 * - Dijkstra 알고리즘은 전체 정점의 크기와 시작 정점을 파라미터로 받는다
 * - 이 정점을 방문했는지 체크하는 boolean 배열과, 가중치를 담을 배열 dist를 선언하고, 무한을 뜻하는 INF 변수도 선언한다
 * - dist의 초기값은 INF로 초기화한다
 * - dist[start]는 처음 정점이니까 0으로 한다
 * - 이어서 우선순위 큐를 선언해준다. 우선순위 큐에 첫번째 노드를 만들어서 넣어준다. index는 start고 cost는 0으로 인수를 넣어준다
 * - 우선순위 큐가 비어있지 않는 동안 반복하는데, nowVertex라는 변수를 선언하고 우선순위 큐에서 index를 poll해서 가져온다
 * - 만약 check[nowVertex] 가 true면 continue하고 아니면 check[nowVertex]에 true를 넣어 방문했음을 표기한다
 * - 이어서 graph[nowVertex]를 순회한다. 
 * - 이때 만약 dist[next.index] > dist[nowVertex] + next.cost가 성립하면 dist[next.index] = dist[nowVertex]+next.cost를 진행한다
 * - 이어서 pq.offer(new Node(next.index, dist[next.index]))를 진행해서, 우선순위 큐에 새로운 다음 정점과 그 다음 정점까지의 거리를 넣어준다
 * - 이렇게 최종 완성한뒤, StringBuilder를 완성하는데 INF이면 INF를 append하고 아닌경우 해당 수를 append한다
 * - 마지막에 출력할 때, 0번째도 출력되므로 그 부분은 delete해주고 출력하면 정답이 된다.
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(n)
 *
 */

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost,o.cost);
    }
}



public class Main {
    static ArrayList<Node>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void Dijkstra(int n, int start){
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist,INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(check[nowVertex]){
                continue;
            }
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }

            }

        }

        for (int i : dist) {
            if(i == INF){
                sb.append("INF").append("\n");
            }else{
                sb.append(i).append("\n");
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        Dijkstra(V, start);
        sb.delete(0,4);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
