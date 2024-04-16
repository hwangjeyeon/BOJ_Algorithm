import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. 문제 이해를 못해서 애먹었던 문제다.
 * 2. 1번을 루트 노드로 하며, 1번을 시작으로 dfs 탐색을 해주면 된다
 * 3. 각 노드와 연결된 리스트들은 자식 리스트이므로 그 리스트들을 따라 내려가다보면 리프노드를 만날 것이고 거기서 탐색하면서 자신의 부모 노드를 정답 배열에 넣어주면된다
 * 4. 완성한 부모 노드 배열을 인덱스 2부터 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static List<Integer>[] lists;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        lists = new ArrayList[n+1];
        visited = new boolean[n+1];
        ans = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            lists[p1].add(p2);
            lists[p2].add(p1);
        }

        dfs(1);

        for (int i = 2; i < ans.length; i++) {
            bw.write(ans[i]+"\n");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (Integer i : lists[start]){
            if(!visited[i]){
                ans[i] = start;
                dfs(i);

            }
        }

    }


}

