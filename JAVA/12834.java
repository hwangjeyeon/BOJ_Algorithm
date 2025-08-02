import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 다익스트라로 해결할 수 있는 문제다
 * 2. 정의된 한 사람의 거리의 합을 구하는 것이 목표이므로, 각 팀원의 위치에서 kist와 씨알푸드 위치까지의 최단거리는 팀원의 위치를 시작점으로
 * 다익스트라를 적용하면 구할 수 있다
 * 3. 만약 도달이 불가능할 경우 거리를 -1로 처리해주면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(nElogV)
 * 공간복잡도: O(nElogV)
 *
 */

public class Main {

    static int n;
    static int v;
    static int e;
    static int[] dist;
    static List<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v+1];
        list = new List[v+1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int kist = Integer.parseInt(st.nextToken());
        int food = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] start = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        while(e --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        int ans = 0;
        for (int i : start) {
            dijkstra(i);
            ans += dist[kist] == Integer.MAX_VALUE ? -1 : dist[kist];
            ans += dist[food] == Integer.MAX_VALUE ? -1 : dist[food];
        }

        bw.write(ans+"");
        
        br.close();
        bw.close();
    }

    private static void dijkstra(int now) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) ->{
            return o1[1] - o2[1];
        });
        dist[now] = 0;
        pq.offer(new int[]{now, dist[now]});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(dist[cur[0]] < cur[1]){
                continue;
            }
            for (int[] nxt : list[cur[0]]) {
                if(dist[nxt[0]] < dist[cur[0]] + nxt[1]){
                    continue;
                }
                dist[nxt[0]] = dist[cur[0]] + nxt[1];
                pq.add(new int[]{nxt[0], dist[nxt[0]]});
            }

        }

    }
}
