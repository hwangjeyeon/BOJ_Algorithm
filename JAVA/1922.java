import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 들어가는 정점 간선과 그 가중치를 필드로 갖는 Edge 클래스를 구현한다
 * - 이때 우선순위 큐를 위해 Comparable을 implements한다
 * - List<Edge>[] graph로  각 Edge별 연결된 정점을 담을 리스트 배열을 선언한다
 * - mstPrim(최소 스패닝 트리 - 프림 알고리즘)으로 해당 문제를 풀었다
 * - 방문 여부를 체크하기 위해 boolean[] visit 배열을 선언한다
 * - 이어서 PriorityQueue<Edge>를 선언한다
 * - 우선순위 큐에 시작점을 넣고, 비용을 담을 total 변수를 선언한다
 * - 이어서 우선순위 큐가 비어있지 않는동안 반복해서, 진행한다
 * - 우선순위 큐에 있는 값을 poll()해서 가져오고, 일단 방문했으면 스킵 방문하지 않았으면 방문 체크를 하고 total에 해당 Edge의 cost를 더해준다
 * - 이어서 해당 graph배열의 해당 나오는 정점 간선에 연결된 모든 들어가는 정점 간선을 순회한다
 * - 이때 해당 간선의 방문 여부를 체크해서 방문하지 않았으면 우선순위 큐에 저장해서 최소 스패닝 트리를 만들어간다
 * - 이렇게 완성된 결과를 출력한다
 * - 참고로 입력 받고 간선을 이을때, 양방향으로 해줘야 한다.
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(n)
 *
 */

class Edge implements Comparable<Edge>{

    int w;
    int cost;

    public Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}


public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Edge>[] graph;

    public static void mstPrim(int start, int n){
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));

        int total = 0;
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if(visit[v]){
                continue;
            }
            visit[v] = true;
            total += cost;

            for (Edge e : graph[v]) {
                if(!visit[e.w]){
                    pq.add(e);
                }
            }
        }

        sb.append(total);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b,c));
            graph[b].add(new Edge(a,c));
        }

        mstPrim(1,n);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
