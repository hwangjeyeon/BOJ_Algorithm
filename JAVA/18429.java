import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 간단한 백트래킹 문제다. 방문배열을 활용해서 최종장에 도착하는 경우 ans++하면 된다
 * 2. 만약 중간에 weight가 500미만이 된다면 제일 먼저 해당 함수를 종료시켜준다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void dfs(int depth, int weight) {
        if(weight < 500){
            return;
        }
        if(depth == n){
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, weight-k+arr[i]);
                visited[i] = false;
            }
        }

    }
}
