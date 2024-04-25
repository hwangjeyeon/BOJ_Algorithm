import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 양방향 연결리스트와 BFS를 이용해서 해결하면 쉽게 풀리는 문제다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {
    static List<Integer>[] lists;
    static int max = 0;
    static boolean[] visited;
    static int[] result;
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
        result = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
            lists[end].add(start);
        }

        bfs(1, n,m);

        for (int i = 1; i < n + 1; i++) {
            max = Math.max(result[i], max);
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(max == result[i]){
                bw.write(i + " " + result[i] + " ");
                break;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if(max == result[i]){
                count++;
            }
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void bfs(int start, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < lists[now[0]].size(); i++) {
                if(!visited[lists[now[0]].get(i)]){
                    q.add(new int[]{lists[now[0]].get(i), now[1] + 1});
                    visited[lists[now[0]].get(i)] = true;
                    result[lists[now[0]].get(i)] = now[1] + 1;
                }
            }
        }
    }
}

