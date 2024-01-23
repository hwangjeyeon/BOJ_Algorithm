import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 기존 다익스트라 알고리즘을 적용하기 위해 구현하는 과정은 동일하다
 * - 이후 이 문제는 다른 문제들과 다르게 한가지 고민할점이 추가되었는데, 갔다가 돌아오는 경우를 구해야한다는 점이다.
 * - 목표 지점을 다익스트라 알고리즘으로 각 정점별 가중치를 구하면, 그 가중치는 X에서 돌아가는데 필요한 시간을 의미한다
 * - 이제 한가지 더 구해야한다. 내 정점에서 목적지 X로 가는데 걸리는 가중치를 구해야한다. 그리고 그중에서 가장 큰 값을 구하는 것이 정답이다.
 * - 이것을 해결하기 위해 두가지 파라미터를 추가하였다. 먼저 이것이 목적지에서 집으로 가는 것인지 아니면 내 정점에서 목적지로 가는 것인지 구분하기 위해 boolean chk 파라미터를 추가했다
 * - 이 파라미터가 true면 목적지에서 집으로 가는 것이고, false면 집에서 목적지로 가는 것이다
 * - 두번째 파라미터는 pivot이다. 목적지에서 집으로 가는 것은 start가 목적지이기에 상관없지만 집에서 목적지로 가는 것은 start가 집을 의미하는 정점 인덱스가 되어버린다.
 * - 따라서 pivot으로 목적지를 고정적으로 받아 활용하기 위해 해당 파라미터를 추가하였다.
 * - 이제 별도의 배열 index 역할을 하기 위한 count 변수를 선언해준다. 그리고 미리 선언해둔 range배열에 count 인덱스 위치에 i를 집어넣는다.
 * - 만약 true라면 별도 조건 없이 i를 넣어주면된다
 * - false라면 고려해야하는데, 목적지 index의 i값만 range[start] 넣어줘야한다. 아니면 다른 배열에도 값이 들어가게 되어서 원하는 결과를 얻지 못한다
 * - 따라서 count==pivot일때만 range[start] +=i하고 break; 하도록 선언하였다.
 * - main에서는 1부터 n까지 start의 값만 i로 하여서 차례대로 모든 정점의 결과를 구한다
 * - 이어서 range배열에서 가장 값이 큰 것을 찾아 ans 배열에 저장한뒤, 출력한다. 
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
    static int[] range = new int[1001];
    public static void Dijkstra(int n, int start, boolean chk, int pivot){
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
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
        int count = 0;
        for (int i : dist) {
            if(i == INF){
                continue;
            }

            count++;
            if(chk){
                range[count] += i;
            }else{
                if(count == pivot){
                    range[start] += i;
                    break;
                }

            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        Dijkstra(n, x, true, x);

        for(int i=1; i<n+1; i++){
            Dijkstra(n,i,false,x);
        }
        int ans = -1;
        for (int i = 1; i < n + 1; i++) {
            ans = Math.max(ans, range[i]);
        }
        sb.append(ans);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
