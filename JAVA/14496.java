import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. bfs로 풀면 되는 간단한 문제다.
 * 2. 해당 문제는 좌표 그래프가 아닌 양방향 연결 리스트 방식으로 구성해서 풀면된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(nm)
 * 공간복잡도: O(m)
 *
 */

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        result = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            list[p1].add(p2);
            list[p2].add(p1);
        }

        bfs(start);
        if(!visited[end]){
            bw.write("-1");
        }else{
            bw.write(result[end]+"");
        }
        
        br.close();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});
        visited[start] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < list[now[0]].size(); i++) {
                if(!visited[list[now[0]].get(i)]){
                    visited[list[now[0]].get(i)] = true;
                    q.add(new int[]{list[now[0]].get(i), now[1] + 1});
                    result[list[now[0]].get(i)] = now[1]+1;
                }
            }

        }


    }


}

