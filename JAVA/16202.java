import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 크루스칼 알고리즘 + 우선순위 큐 자료구조를 활용하는 문제다
 * 2. 정확히는 최초 입력값을 우선순위 큐에 넣고 크루스칼을 돌린다
 * 3. 가장 가중치가 작은 간선을 빼기 위해 똑같은 우선순위 큐를 하나 더 만들고 크루스칼 알고리즘으로 간선 확인할 때마다 모두 해당 우선순위 큐에 넣는다
 * 4. K번 수행하며, 작은 간선을 빼기 위한 우선순위 큐에서 값을 하나 빼준다
 * 5. 입력 간선을 가지고 있는 우선순위 큐를 작은 간선을 위한 우선순위 큐로 바꿔준다
 * 6. 매 문제바다 작은 간선을 위한 우선순위 큐와 사이클 체크를 위한 부모배열을 초기화해주면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(mlogm*k)
 * 공간복잡도: O(n*logm)
 *
 */
class Graph{
    int a;
    int b;
    int d;

    public Graph(int a, int b, int d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
}

public class Main {

    static PriorityQueue<Graph> pq;
    static int[] parent;
    static int n;
    static int m;
    static PriorityQueue<Graph> min;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1.d - o2.d;
        });
        sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new Graph(a, b, (i+1)));
        }

        for (int i = 0; i < k; i++) {
            init();
            kruskal();
            min.poll();
            pq = min;
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void init() {
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        min = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
    }

    private static void kruskal() {

        int sum = 0;
        int count = 0;

        while(!pq.isEmpty()){
            Graph graph = pq.poll();
            if(find(graph.a) != find(graph.b)){
                union(graph.a, graph.b);
                count++;
                sum += graph.d;
            }
            min.add(graph);
        }

        solve(sum, count);

    }

    private static void solve(int sum, int count) {
        if(count == n-1){
            sb.append(sum).append(" ");
        }else{
            sb.append("0 ");
        }
    }

    private static int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            parent[y] = x;
        }
    }

}
