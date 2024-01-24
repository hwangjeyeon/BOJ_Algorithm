import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 풀이 과정:
 * - 벨만-포드 알고리즘 학습 후 푼 문제입니다
 * - Edge 클래스를 구현해준다. v는 나가는 정점, w는 들어오는 정점, cost는 가중치이다.
 * - ArrayList<Edge> graph 리스트를 만들어둔다. 이 리스트는 Edge들을 보관할 것이다
 * - bellmanFord는 정점의 개수, 간선의 개수, 출발 정점을 파라미터로 받는다
 * - dist배열은 그 정점으로 오는데 드는 가장 작은 비용을 의미한다. 이 문제에서는 도시로 들어오는 버스의 가장 빠른 시간을 의미한다
 * - dist배열과 INF를 모두 Long으로 선언해주었는데, 언더플로우가 발생하기 때문이다. 최소 -10000이 최대 500개의 정점과 6000개의 간선만큼 있다고 했을 때 음수 가중치를 계속 더할때 언더플로우가 발생할 수 있다
 * - 정점과 간선을 모두 순회한다. 현재 간선을 Edge형 변수에 넣어준다
 * - dist[edge.v]가 INF가 아니고 dist[edge.w] > dist[edge.w] + edge.cost를 만족하면 dist[edge.w] = dist[edge.v] + edge.cost;를 진행한다
 * - 이어서 음수 사이클이 있는지 확인하기 위해 모든 간선을 순회한다. 위 과정을 만족하는 경우가 있으면 음수사이클이 존재하는 것이므로 -1을 StringBuilder에 넣고 종료한다
 * - 이제 두번째 인덱스부터 끝까지 순회하여 dist[i]가 INF인 경우는 -1을 append하고 아닌 경우는 해당 값을 append한다
 * - 최종 결과를 출력하면 정답이 된다
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(n)
 *
 */
class Edge{
    int v;
    int w;
    int cost;

    public Edge(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}



public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Edge> graph;
    static final Long INF = Long.MAX_VALUE;
    public static void bellmanFord(int n, int m, int start){
        Long[] dist = new Long[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j);

                if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Edge edge = graph.get(i);

            if(dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost){
                sb.append("-1");
                return;
            }
        }

        for (int i = 2; i < dist.length; i++) {

            if(dist[i] == INF){
                sb.append("-1").append("\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a,b,c));
        }

        bellmanFord(n,m, 1);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

}
