import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 최소신장트리를 만드는 문제다. 이때 크루스칼 알고리즘을 사용하면 쉽게 해결할 수 있다.
 * 2. 기존 크루스칼 알고리즘에 한가지만 앞서서 처리해주면 된다
 * 3. 이미 연결된 길에 대해서는 미리 union을 해주면된다. 그렇게 하면 크루스칼 알고리즘에서 find할때, 찾지 않고 건너띄기 때문에 ans에 누적되지 않는다
 * 4. 이점을 추가하여 크루스칼 알고리즘을 돌리고 ans를 포맷에 맞춰 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

class Node{
    int num;
    int x;
    int y;

    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge{
    int start;
    int end;
    double cost;

    public Edge(int start, int end, double cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}


public class Main {

    static Node[] nodes;
    static List<Edge> lists;
    static int[] parent;
    static double ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        nodes = new Node[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, a, b);
        }
        lists = new ArrayList<>();
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a-1,b-1);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                lists.add(new Edge(nodes[i].num, nodes[j].num, distance(nodes[i],nodes[j])));
            }
        }
        lists.sort(Comparator.comparing(o -> o.cost));

        kruskal(m);

        bw.write(String.format("%.2f", ans));

        br.close();
        bw.close();
    }

    private static void kruskal(int m) {
        for (int i = 0; i < lists.size(); i++) {
            if(find(lists.get(i).start) != find(lists.get(i).end)){
                ans += lists.get(i).cost;
                union(lists.get(i).start, lists.get(i).end);
            }
        }


    }

    private static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x <= y){
                parent[y] = x;
            }else{
                parent[x] = y;
            }
        }
    }

    private static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static double distance(Node a, Node b){
        return Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
    }

}

