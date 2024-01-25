import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 어려운 문제였다. 벨만포드 알고리즘 구현을 넘어서는 문제였고, 틀릴만한 요소나 문제를 제대로 읽지 않는다면 틑릴 요소가 많아서 힘들었던 문제였다
 * - 도로는 양방향, 웜홀은 단방향인데 음의 가중치를 가진다는 것을 생각해야한다
 * - 이어서 간선의 개수를 의미하는 m은 2*m+w를 해줘야한다. m은 도로의 개수인데 이것은 양방향으로 연결되었으니 2를 곱해줘야한다. 이어서 w도 연결되었으니 앞서 말한 것과 같은 개수를 인수로 넘겨줘야한다
 * - 나머지는 벨만포드 알고리즘을 구현하면 된다. 이때 음의 가중치가 있으면 Yes를 출력하도록 fail 변수를 추가해준다
 * - 모든 정점을 출발 지점으로 하는 경우 시간 초과가 발생한다
 * - 임의의 정점을 출발 지점으로 잡고 사이클 유무만 판단하면 시간초과가 발생하지 않는다.
 * - 하지만 이때, INF가 아닌 경우를 벨만포드 알고리즘 메소드에 if 조건으로 추가하면 문제가 틀렸다고 나온다.
 * - 이것을 해결하기 위해 풀이를 참고했는데, 다음과 같다
 * - 고립된 정점이 있는 경우 그 정점이 시작점일 때 INF인 경우를 건너뛰면 순회를 하지 않고 지나치게 된다
 * - 하지만 이런 고립되어 있는 경우도 음의 사이클이 충분히 발생할 수 있다. 예를 들어 고립된 A정점과 B와 C정점이 있을 때 B와 C사이에 사이클이 존재한다면 A를 출발지로 할 때, 음의 사이클이 있는지 판단할 수가 없게 된다
 * - 따라서 INF인 경우를 제외하는 조건은 제거해줘야 한다.
 * - 그런데 이럴 경우 INF가 Integer.MAX_VALUE일 경우 오버플로우가 발생할 수 있다.
 * - 따라서 시간의 최대값이 1만이므로 10001을 INF값으로 설정해주고 dist 배열을 초기화 해주면 정답이 된다.
 *
 * 참고 풀이: https://steady-coding.tistory.com/91
 *
 * 시간복잡도: O(n*(m+w))
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
    static final int INF = 10001;
    static boolean fail;
    public static void bellmanFord(int n, int m, int start){
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = graph.get(j);
                if(dist[edge.w] > dist[edge.v] + edge.cost){
                    dist[edge.w] = dist[edge.v] + edge.cost;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            Edge edge = graph.get(i);
            if (dist[edge.w] > dist[edge.v] + edge.cost) {
                fail = true;
                return;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m+w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if(j < m){
                    graph.add(new Edge(s,e,t));
                    graph.add(new Edge(e,s,t));
                }else{
                    graph.add(new Edge(s,e,-t));
                }
            }

            bellmanFord(n,2*m+w,1);
            if(fail){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
            fail = false;
        }


        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
