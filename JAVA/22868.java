import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 그래프 형태의 BFS 문제다. 이 문제는 간선이 M개 있고 최대 5만이기 때문에 dfs롤 해결할 수 없다.
 * 2. 다익스트라도 고려해볼만 한데, 가중치가 0이므로 bfs로 해결하였다
 * 3. 일단 사전 순으로 먼저 나오는 경우를 위해 각 정점에 연결된 간선은 오름차순으로 정렬해준다
 * 4. bfs를 이용하여 해결할 때, 보통은 방문배열만 사용하는데 여기서는 경로를 기억해야하므로 다음 지점으로 갈 정점의 인덱스에 어느 지점에서 온지를 적어둔다
 * 5. 이렇게 해서 목적지에 도달한 경우 ans에 더해주고 종료한다
 * 6. 이제 다시 방문배열을 따라서 처음 출발지점까지 돌아가야한다. 목적지의 값을 변수에 넣고 이 값이 0보다 큰동안 방문 체크를 해준다
 * 7. 왜냐하면 S -> E로 가는 경로는 다시 선택되지 않아야 하기 떄문이다
 * 8. 단 출발지는 방문 체크를 해제해야한다. e -> s 경로를 완성하기 위해서는 반드시 s를 마지막에 거쳐야하기 때문이다
 * 9. 이후 다시 BFS 돌려준뒤 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O(n+m)
 * 공간복잡도: O(n+m)
 *
 */


public class Main {

    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int[] road;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lists = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[b].add(a);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        road = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(lists[i]);
        }
        bfs(s,e);
        visited = new boolean[n+1];
        int last = road[e];
        while(last > 0){
            visited[last] = true;
            last = road[last];
        }
        visited[s] = false;
        bfs(e, s);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s,0});
        visited[s] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == e){
                ans += now[1];
                return;
            }

            for (Integer i : lists[now[0]]) {
                if(!visited[i]){
                    visited[i] = true;
                    road[i] = now[0];
                    q.add(new int[]{i,now[1] + 1});
                }
            }

        }

    }
}
