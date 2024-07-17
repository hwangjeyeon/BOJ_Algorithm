import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 간선마다 가중치가 다르고 음의 가중치 또한 존재하지 않으며, 최소 값을 구하는 문제이므로 다익스트라 알고리즘을 선택하였다
 * 2. s를 시작으로 t와 연결되는 최소의 가중치를 구하여야 하며, 노드 간 연결리스트로 연결되어있기 때문에 재방문으로 무한루프에 빠지는 것을 막기 위해 방문 배열을 선택하였다.
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
    static List<Node>[] lists;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        bw.write(dist[end]+ "");

        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.number]){
                continue;
            }
            visited[node.number] = true;
            for (int i = 0; i < lists[node.number].size(); i++) {
                Node cur = lists[node.number].get(i);
                if(dist[node.number] + cur.cost < dist[cur.number]){
                    dist[cur.number] = dist[node.number] + cur.cost;
                    pq.add(new Node(cur.number, dist[cur.number]));
                }
            }
        }
    }

}

