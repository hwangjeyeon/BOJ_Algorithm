import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식 backtracking(n,m, depth, start)
 * 2. base condition if(m==depth)
 * 3. 재귀식 (n,m,depth+1, i+1)
 *
 * - 다시 직전 15654번 문제에서 start 파라미터와 i+1을 추가하였다.
 * - 이렇게 하면 자기자신을 포함하지 않으면서 오름차순으로 정렬된 수열이 출력된다
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(nlogm)
 * 공간복잡도: O(nlogm)
 *
 */


public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] input;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        backtracking(n,m,0, 0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int depth,int start) {
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                backtracking(n, m,depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}

