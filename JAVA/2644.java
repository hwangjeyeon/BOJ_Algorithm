import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - DFS로 풀었다.
 * - 스택을 사용했는데... 원인을 발견할 수 없는 부분에서 자꾸 틀려서 재귀로 방식을 바꿔서 풀었다.
 * - 깊이탐색을 통해서, 정답을 발견했을 때의 깊이를 정답으로 하면 된다.
 *
 *
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */



public class Main {


    static int count = 0;
    static boolean isOk = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        if(start != end){
            dfs(arr, visited, n,m, start, end,0);
        }


        if(!isOk){
            if(start == end){
                bw.write("0");
            }else{
                bw.write(String.valueOf(-1));
            }

        }else{
            bw.write(String.valueOf(count));
        }
        br.close();
        bw.close();
    }


    private static void dfs(int[][] arr, boolean[] visited, int n, int m, int start, int end, int depth) {

        visited[start] = true;

        if(start == end) {
            isOk = true;
            count = depth;
            return;
        }

        for (int i = n; i >= 0; i--) {
            if(arr[start][i] == 1 && !visited[i]){
                dfs(arr, visited, n,m, i, end, depth+1);
            }
        }
    }


}

