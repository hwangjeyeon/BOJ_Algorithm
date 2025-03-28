import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 최단거리를 구하는 문제이며, 주어진 모든 가중치가 양수이고 1을 초과하는 가중치가 주어진다. 따라서 다익스트라로 해결할 수 있다
 * 2. 하지만 이번에는 반드시 거쳐가야하는 a와 b라는 지점이 주어졌다. 따라서 단순히 1부터 n까지 다익스트라를 돌리는 문제는 아니다
 * 3. 1 -> a -> b -> n과 1 -> b -> a -> n이라는 두가지 경로를 각각 출발점과 도착점으로 두고 다익스트라를 돌려야한다
 * 4. 그 결과 두 경우 모두 INF인 경우는 -1을 출력하고 아니면 둘중 더 작은 값을 출력하면 정답이 된다
 * 5. 한가지 주의할 점이 있는데 이 문제에서 INF는 Integer.MAX_VALUE를 하면 안된다. 반드시 200_000 * 1000인 200_000_000을 해야한다
 * 6. 왜냐하면 해당 범위를 넘어가는 경우 반드시 틀린 답이 되어야하는데, Integer.MAX_VALUE로 설정하면 이것도 정답으로 판단하기 때문이다
 * 7. 따라서 200_000_000을 INF로 설정하자!
 *
 * 해결방법:
 *
 * 시간복잡도: O(E log n)
 * 공간복잡도: O(e*n)
 *
 */

public class Main {

    static int n;
    static int e;
    static List<int[]>[] lists;
    static int[] dist;
    static int a;
    static int b;
    static boolean[] visited;
    static int INF = 200_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        lists = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(new int[]{b,c});
            lists[b].add(new int[]{a,c});
        }
        dist = new int[n+1];
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int count1 = 0;
        count1 += dijkstra(1, a) + dijkstra(a, b) + dijkstra(b, n);
        int count2 = 0;
        count2 += dijkstra(1,b) + dijkstra(b,a) + dijkstra(a,n);

        int ans = -1;
        if(count1 < INF || count2 < INF){
            ans = Math.min(count1, count2);
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        visited = new boolean[n+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(!visited[now[0]]){
                visited[now[0]] = true;
                for (int[] cur : lists[now[0]]) {
                    if(!visited[cur[0]] && dist[cur[0]] > dist[now[0]] + cur[1]){
                        dist[cur[0]] = dist[now[0]] + cur[1];
                        pq.add(new int[]{cur[0], dist[now[0]] + cur[1]});
                    }
                }
            }
        }
        return dist[end];
    }
}
