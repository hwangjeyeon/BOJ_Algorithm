import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 간선을 뒤집어서 저장하자. 이렇게 저장하면 원래 a,b라고 했을 때, b로 들어오기 전에 해야하는 작업은 a가 된다
 * 2. 따라서 뒤집어서 단방향으로 저장하고 dfs 탐색을 통해 연결된 간선을 모두 탐색한다.
 * 3. 이때 방문 체크를 해서 미방문한 것들만 탐색하고, 종료전에 count를 증가시킨다
 * 4. 완성한 count에서 맨 처음 자기자신을 세는 경우를 빼서 count-1을 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(n+m)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    static List<Integer>[] list;
    static int count = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }
        int x = Integer.parseInt(br.readLine());
        dfs(n,x);
        bw.write(count-1 + "");

        br.close();
        bw.close();
    }

    private static void dfs(int n, int x) {
        visited[x] = true;
        for (Integer i : list[x]) {
            if(!visited[i]){
                dfs(n,i);
            }
        }
        count++;

    }
}

