import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 트리의 성질과 DFS를 이용하여 푸는 문제다
 * 2. 트리는 사이클이 없어야 하며, n개의 노드가 있고 간선은 n-1개가 있어야 한다
 * 3. 이 성질을 이용하여 DFS 탐색을 하면서 만들어지는 노드의 개수와 연결된 간선의 개수를 세어준 뒤 비교하여 사이클이 생기지 않는 경우의 개수를 세어주면된다
 * 4. 하지만 트리는 사실 방향 그래프가 아니라 무방향 그래프이다. 하지만 코드 상으로는 무방향 그래프를 나타내기 힘드므로 양방향으로 이어준 뒤, (노드의 개수-1)을 2배한 것이 간선의 개수와 같은지 체크해주면된다
 * 5. DFS 탐색을 하면서 나오는 now마다 방문체크를 해주고, 노드의 개수를 증가시킨다.
 * 6. 이어서 연결된 모든 간선을 돌면서 간선의 개수를 세어주고, 연결된 노드를 방문하지 않은 경우에만 dfs 재귀를 돌려준다
 * 7. 완성한 ans에 결과에 따라 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(n+m)
 *
 */



public class Main {

    static List<Integer>[] lists;
    static int counts = 0;
    static int lines = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 0;
        while(true){
            T++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            lists = new ArrayList[n+1];
            for (int i = 0; i < n + 1; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                lists[a].add(b);
                lists[b].add(a);
            }
            visited = new boolean[n+1];
            int ans = 0;
            for (int i = 1; i < n + 1; i++) {
                if(!visited[i]){
                    counts = 0;
                    lines = 0;
                    dfs(i);
                    if((counts-1)*2 == lines){
                        ans++;
                    }
                }
            }

            if(ans > 1){
                bw.write("Case " + T + ": A forest of " + ans + " trees.\n");
            }else if(ans == 1){
                bw.write("Case " + T + ": There is one tree.\n");
            }else{
                bw.write("Case " + T + ": No trees.\n");
            }

        }

        br.close();
        bw.close();
    }

    private static void dfs(int now) {
        visited[now] = true;
        counts++;
        for (Integer i : lists[now]) {
            lines++;
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}

