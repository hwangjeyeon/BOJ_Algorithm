import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 전형적인 백트래킹 문제다.
 * 2. 배열을 사용해서 depth 인덱스에 i를 넣어주고 베이스 컨디션에 도착했을 때 순회를 돌아 StringBuilder에 저장한다
 * 3. 완성한 StringBuilder를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(nlogn)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        arr = new int[n+1];
        backtracking(n, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();

    }

    private static void backtracking(int n, int depth) {
        if(depth == n){
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i < n + 1; i++) {
            if(visited[i]){
               continue;
            }
            arr[depth] = i;
            visited[i] = true;
            backtracking(n, depth+1);
            visited[i] = false;
        }

    }

}
