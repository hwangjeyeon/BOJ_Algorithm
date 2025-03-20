import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 백트래킹을 활용하면 되는 문제다
 * 2. 임시 배열을 하나 두고, base condition에서 n-1만큼 순회하며 합산을 구한뒤 ans와 비교해서 최댓값으로 ans를 갱신하면 된다
 * 3. 방문배열을 활용해서 중복 선택되지 않도록 한다.
 * 4. 0~n까지 순회하며 방문하지 않았다면 방문체크 후, tmp[depth] = arr[i]를 넣어준다. 이렇게 하면 depth에 따라 중복되지 않으면서 배열의 모든 값을 재배치할 수 있다
 * 5. depth+1한 재귀값을 넘기고 종료하면 방문체크를 해제한다
 * 6. 완성한 ans를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    static int n;
    static int[] arr;
    static int[] tmp;
    static int ans = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        backtracking(0);

        bw.write(ans+"");

        br.close();
        bw.close();
    }

    private static void backtracking(int depth) {
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(tmp[i] - tmp[i+1]);
            }
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                tmp[depth] = arr[i];
                visited[i] = true;
                backtracking(depth+1);
                visited[i] = false;
            }
        }

    }

}
