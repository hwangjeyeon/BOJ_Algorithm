import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 최단거리 / 다익스트라 알고리즘을 이용해서 풀었다
 * - Node는 기존과 동일하게 index는 목표 정점 정보, cost는 가중치를 필드로 갖는다
 * - 다익스트라 알고리즘 메소드 안에는 방문 여부를 체크하는 boolean[] 변수와 가장 작은 가중치를 보관하는 int[] dist 변수가 있다
 * - 또한 우선순위 큐를 사용하며, 해당 큐를 사용하기 위해 Node에는 Comparable의 compareTo를 구현해야한다
 * - 가장 처음를 우선순위 큐에 offer한다. 노드 인스턴스로 저장하며 start를 인덱스로 그리고 처음이기에 cost를 0으로 저장한다
 * - 이어서 우선순위 큐가 비어있지 않은동안 반복하는데 nowVertex라는 지역변수를 우선순위 큐의 index를 poll해서 가져온다
 * - check[nowVertex]를 통해 방문했으면 continue하고 아니면 true를 넣어준뒤 이어나간다
 * - 이제 graph[nowVertext]에 있는 node를 비교한다. graph[nowVertex]는 nowVertex에 해당하는 정점이 가지는 연결된 정점들을 의미하며, 이것들을 모두 순회한다
 * - 위 노드를 next로 가져오고 만약 dist[next.index]가  dist[nowVertex] + next.cost 보다 크면 dist[next.index]에 dist[nowVertex]+ next.cost를 넣어준다
 * - 이어서 우선순위 큐에 새로운 노드 인스턴스를 offer하는데 next.index와 dist[next.index]를 인수로 넣어준다
 * - 주어진 문제에서는 도시를 정점, 버스를 간선으로 생각하면 된다.
 * - 이전 문제와 동일하게 graph[start].add(new Node(end, cost))를 해준다
 * - 이어서 시작지점을 받고, 이번에는 종료지점이 주어졌으므로 end라는 변수에 받아 Dijkstra 메소드 인수로 넘겨준다
 * - StringBuilder를 만들 때, end라는 값만 출력하고 싶으므로 count 변수를 만들어서 end와 같은 경우만 append하게 해준다
 * - 이렇게 완성한 StringBuilder를 string으로 출력해주면 정답이 된다.
 * 
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
        return Integer.compare(this.cost, o.cost);
    }
}



public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] graph;

    public static void Dijkstra(int n, int start, int end){
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
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
        int count = -1;
        for (int i : dist) {
            count++;
            if(count == end){
                sb.append(i);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 정점의 개수
        int n = Integer.parseInt(br.readLine());
        //간선의 개수
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startStation = Integer.parseInt(st.nextToken());
            int endStation = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startStation].add(new Node(endStation, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Dijkstra(n, start, end);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
