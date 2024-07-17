import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 가중치가 존재하는 최단거리 문제이며, 음의 가중치는 존재하지 않기때문에 다익스트라 알고리즘을 선택하였다
 * 2. 시야가 밝혀져 있는 곳은 마지막 지점을 제외하고 방문을 true로 하여 탐색하지 않도록 하였다
 * 3. 한가지 주의할점이 int형 범위를 시간의 합이 초과할 수 있다는 점이다. 따라서 long 타입으로 지정하고 Long.MAX_VALUE로도 dist배열을 초기화한다
 * 4. 또한 방문하지 못하는 경우는 dist[n-1]이 Long.MAX_VALUE이므로 이러한 경우는 -1을 출력하고 나머지는 dist[n-1]을 출력하도록 한다.
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */

class Node{
    int number;
    long cost;

    public Node(int number, long cost) {
        this.number = number;
        this.cost = cost;
    }
}

public class Main {

    static List<Node>[] list;
    static boolean[] visited;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n];
        dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(i != n-1 && tmp == 1) {
                visited[i] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        dijkstra(0);
        if(dist[n-1] == Long.MAX_VALUE){
            bw.write("-1");
        }else{
            bw.write(dist[n-1]+"");
        }
        br.close();
        bw.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.number]){
                continue;
            }
            visited[node.number] = true;

            for (int i = 0; i < list[node.number].size(); i++) {
                Node cur = list[node.number].get(i);
                if(dist[node.number] + cur.cost < dist[cur.number]){
                    dist[cur.number] = dist[node.number] + cur.cost;
                    pq.add(new Node(cur.number, dist[cur.number]));
                }
            }
        }

    }

}

