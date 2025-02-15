import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. MST로 푸는 문제다.
 * 2. MST인지 구분하려면, 첫번째 모든 정점을 포함하고, 정점간 서로 연결되며, 사이클이 존재하지 않는 그래프여야 한다
 * 3. 또한 이떄, 최소 비용을 구하고자 하는 문제라면 MST로 해결하는 문제라고 생각할 수 있다
 * 4. 프림과 크루스칼 풀이가 있는데, 크루스칼을 공부하고 해당 방법으로 풀었다
 * 5. 크루스칼 알고리즘은 그래프 내의 모든 정점들을 가장 적은 비용으로 연결하는 방법이다
 * 6. MST 문제에서는 주어진 입력값을 양방향으로 연결할 필요가 없습니다. 대신 정렬이 필요하므로 별도의 클래스를 만들어서 리스트로 관리한다
 * 7. 연결 간선을 관리하는 리스트는 가중치의 오름차순으로 정렬해야한다
 * 8. 모든 그래프 간선을 순회하면서, 사이클 여부를 확인합니다. 해당 간선이 사이클을 만든다면 MST의 조건을 위배하므로 조건에서 제외해야한다
 * 9. MST의 사이클을 구하는 방법은 유니온파인드를 이용하는 방법이다
 * 10. 연결된 두 정점의 부모 정점이 같다면 사이클이 발생한 것이므로 조건에서 제외한다.
 * 11. 만약 사이클이 아니라면 UNION해서 같은 집합에 포함되도록 설정한다
 * 12. 이 문제에서는 연결 조건을 하나 더 가진다. 같은 성별의 학교끼리는 연결할 수 없다
 * 13. 정점을 KEY로 하고 VALUE를 성별 여부로 하는 HashMap으로 관리한다
 * 14. 만약 두 정점의 value가 같다면 조건에서 제외한다
 * 15. 모두 만족한다면 ans에 현재 가중치를 합해준다
 * 16. 그리고 앞서 말한 두 정점을 유니온한다
 * 17. 한가지 더 확인해야할 것이 있는데, 만약 모든 정점을 잊지 못한다면 그것도 정답을 만족하지 않는 것이다.
 * 18. n-1개의 간선을 연결하는 경우만 정상 출력해야하므로 count의 값을 증가시킨다
 * 19. 이후, count가 n-1인 경우 ans를 출력하고, 아닌 경우 -1을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
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

    static int n;
    static int m;
    static Map<Integer, String> map;
    static int ans = 0;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            String s = st.nextToken();
            map.put(i, s);
        }
        parent = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        List<Graph> graphs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graphs.add(new Graph(a, b, c));
        }
        Collections.sort(graphs,(o1, o2) -> o1.d - o2.d);
        int count = 0;

        for (int i = 0; i < graphs.size(); i++) {
            Graph graph = graphs.get(i);
            if(find(graph.a) != find(graph.b) && !map.get(graph.a).equals(map.get(graph.b))){
                count++;
                ans += graph.d;
                union(graph.a, graph.b);
            }
        }

        if(count == n-1){
            bw.write(ans+"");
        }else{
            bw.write(-1+"");
        }

        br.close();
        bw.close();
    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

}
