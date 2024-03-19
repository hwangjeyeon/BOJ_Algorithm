import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 재귀(백트래킹)
 * 1. 함수식 backtracking(n,m, depth)
 * 2. base condition if(m==depth)
 * 3. 재귀식 (n,m,depth+1)
 *
 * - 이번에는 순회의 i가 아니라 미리 입력을 받아둔 input을 arr[depth]에 넣어둔다
 * - 오름차순을 위해 input의 배열을 미리 오름차순 정렬했다
 * - 또한 중복되는 수열이 출력될 수 있다는 조건이 없어서 visited 배열을 다시 사용하였다
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
        backtracking(n,m,0);
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void backtracking(int n, int m, int depth) {
        if(m == depth){
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = input[i];
                backtracking(n, m,depth+1);
                visited[i] = false;
            }
        }
    }
}

