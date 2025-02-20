import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 단방향 연결이라는점을 참고해서 다익스트라로 해결하면 되는 문제다
 * 2. 처음에는 유니온 파인드를 생각했는데, 출력값을 생각했을 때 그리고 가중치를 생각했을 때 다익스트라가 가장 적합한 방법이다
 * 3. 따라서 다익스트라로 풀고, 우선순위 큐는 시간을 기준으로 오름차순 정렬한다
 * 4. 최종적으로 dist를 확인하며, 갱신된 지점의 개수와 최대 시간을 갱신한 뒤 정답을 출력하면 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(dlogd)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static List<int[]>[] lists;
    static int[] dist;
    static int n;
    static int d;
    static int c;
    static int time;
    static int count;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            lists = new List[n+1];
            for (int i = 0; i < n + 1; i++) {
                lists[i] = new ArrayList<>();
            }
            dist = new int[n+1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(dist, Integer.MAX_VALUE);
            }
            time = 0;
            count = 0;
            visited = new boolean[n+1];

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                lists[b].add(new int[]{a,s});
            }
            dijkstra();
            for (int i = 1; i < n + 1; i++) {
                if(dist[i] != Integer.MAX_VALUE){
                    count++;
                    time = Math.max(time, dist[i]);
                }
            }
            bw.write(count + " " + time +"\n");
        }

        br.close();
        bw.close();
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        pq.add(new int[]{c, 0});
        dist[c] = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(!visited[now[0]]){
                visited[now[0]] = true;
                for (int[] com : lists[now[0]]) {
                    if(dist[now[0]] + com[1] < dist[com[0]]){
                        dist[com[0]] = dist[now[0]] + com[1];
                        pq.add(new int[]{com[0], dist[now[0]] + com[1]});
                    }
                }
            }

        }

    }
}
