import java.io.*;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;


/**
 * 풀이 과정:
 * - DFS로 해당 문제를 풀었다
 * - depth의 최대치를 참고로 친구의 친구까지니까 2로 설정해두면 된다
 * - List 배열을 선언하고, 이어서 a가 b의 친구면 b도 a의 친구다라는 조건을 위해 양방향 관계를 설정한다
 * - 이어서 visited[1]은 본인므로 true로 설정해두고 dfs를 호출한다
 * - start 리스트의 친구 값들을 모두 순회해서 가져온다
 * - 그리고 방문 배열도 true로 설정하고, depth+1과 next를 인수로 넘겨서 재귀호출로 dfs 탐색을 한다
 * - 이후 2부터 순회해서 visited[]가 true인 경우 count를 증가시키고 최종 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static boolean[] visited;
    static List<Integer>[] lists;


    static void dfs(int depth, int start){
        if(depth == 2){
            return;
        }

        for (int i = 0; i < lists[start].size(); i++) {
            int next = lists[start].get(i);
            visited[next] = true;
            dfs(depth+1, next);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        lists = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());

            lists[me].add(friend);
            lists[friend].add(me);
        }

        visited[1] = true;
        dfs(0, 1);
        int ans = 0;
        for (int i = 2; i < n+1; i++) {
            if(visited[i]){
                ans++;
            }
        }


        bw.write(ans+"");
        br.close();
        bw.close();
    }
}

