import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */


public class Main {


    static List<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            list[p1].add(p2);
            list[p2].add(p1);
        }
        visited = new boolean[n+1];
        dfs(v);
        bw.write(sb.toString() + "\n");
        sb = new StringBuilder();
        visited = new boolean[n+1];
        bfs(v);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        Collections.sort(list[start]);
        for (int i = 0; i < list[start].size(); i++) {
            if(!visited[list[start].get(i)]){
                visited[list[start].get(i)] = true;
                dfs(list[start].get(i));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            Collections.sort(list[now]);
            for (int i = 0; i < list[now].size(); i++) {
                if(!visited[list[now].get(i)]){
                    visited[list[now].get(i)] = true;
                    q.add(list[now].get(i));
                }
            }
        }
    }
}

