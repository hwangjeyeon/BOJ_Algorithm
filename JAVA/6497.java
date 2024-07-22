import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 주어진 문제를 보면 최소 신장 트리로 만들면 불이 켜진 길만 서로 왕래하면서 일부를 소등하여 돈을 절약할 수 있음을 알 수 있다
 * 2. 따라서 크루스칼 알고리즘으로 발생하는 최소한의 비용을 구하고, 이후 전체를 다 왕래했을 때 드는 비용에서 빼주면 최대액수 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(mlogn)
 * 공간복잡도: O(n)
 *
 */

class Edge{

    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}


public class Main {


    static List<Edge> lists;
    static long ans;
    static int[] parent;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ans = 0;
            max = 0;
            lists = new ArrayList<>();
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                lists.add(new Edge(a,b,c));
                max += c;
            }
            lists.sort(Comparator.comparing(o -> o.cost));

            kruskal();

            bw.write(max - ans+"\n");

        }

        br.close();
        bw.close();
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

    private static void kruskal() {
        for (int i = 0; i < lists.size(); i++) {
            if(find(lists.get(i).start) != find(lists.get(i).end)){
                ans += lists.get(i).cost;
                union(find(lists.get(i).start), find(lists.get(i).end));
            }
        }
    }
}

