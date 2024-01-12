import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 15663번 문제와 동일한데 딱 한가지 조건만 다르다
 * - depth가 0이 아니고, ans[depth-1] > input[i]일때는 continue하면 조건을 만족한다.
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */





public class Main {

    static int[] input;
    static int[] ans;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        ans = new int[m+1];
        sb = new StringBuilder();
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backTracking(n,m, 0,0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void backTracking(int n, int m, int start, int depth) {
        if(depth == m){
            for(int i=0; i<m; i++){
                sb.append(ans[i])
                        .append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i=0; i<n; i++){
            if(depth !=0 && ans[depth-1] > input[i]){
                continue;
            }

            if(before != input[i]){
                visited[i] = true;
                ans[depth] = input[i];
                before = input[i];
                backTracking(n,m, start,depth+1);
                visited[i] = false;
            }


        }

    }

}
