import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 다익스트라 3번 돌린 다음, 완성된 dist배열 3개를 가지고 가장 작은 값을 찾아 갱신하는 문제다
 * 2. 말그대로 a,b,c에 대한 다익스트라 거리를 담을 dist 배열을 3개 만들어둔다
 * 3. 다익스트라 결과 리턴값으로 배열을 받아 각각을 갱신한다
 * 4. 완성된 결과를 가지고 모든 정점을 순회하며, 정점의 번호 ans와 최단 거리 dis를 갱신해나간다
 * 5. 만약 dis가 현재 정점의 3개 dist 배열의 최솟값보다 작다면 dis를 그 값으로 갱신하고 ans를 i로, dis를 그 값으로 갱신한다
 * 6. 주의할점은 같은 거리인 경우가 여러가지 있을 수 있기 때문에 같은 경우 그냥 continue한다. 처음 발견되는 정점으로 갱신하면 최소 번호의 정점으로 갱신할 수 있기 때문이다
 * 7. 한가지 더 주의할점은 dist 배열을 long타입으로 해야한다 간선의 개수가 5 * 10^5인데 L이 10^4라서 10^9이면 int형 범위를 초과할 수 있기 떄문이다
 * 8. 이점만 주의하고 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(mlogm)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    private static final int INF = 987654321;
    static long[] dista;
    static long[] distb;
    static long[] distc;
    static List<int[]>[] lists;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        lists = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lists[q].add(new int[]{w,e});
            lists[w].add(new int[]{q,e});
        }
        dista = dijkstra(a);
        distb = dijkstra(b);
        distc = dijkstra(c);
        int ans = 0;
        long dis = 0;
        for (int i = 1; i < n + 1; i++) {
            if(dis == Math.min(dista[i], Math.min(distb[i], distc[i]))){
                continue;
            }

            if(dis < Math.min(dista[i], Math.min(distb[i], distc[i]))){
                ans = i;
                dis = Math.min(dista[i], Math.min(distb[i], distc[i]));
            }
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static long[] dijkstra(int start) {
        long[] dist = new long[n+1];
        PriorityQueue<int[]> pq= new PriorityQueue<>((o1, o2) ->{
            return o1[1] - o2[1];
        });

        for (int i = 0; i < n + 1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;
        pq.add(new int[]{start,0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int[] v : lists[now[0]]) {
                if(v[1] + dist[now[0]] < dist[v[0]]){
                    dist[v[0]] = v[1] + dist[now[0]];
                    pq.add(new int[]{v[0], (int) (v[1] + dist[now[0]])});
                }
            }

        }

        return dist;
    }
}
