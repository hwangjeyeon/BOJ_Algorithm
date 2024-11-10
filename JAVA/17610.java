import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. dfs으로 모든 경우의 수를 다 구해주면된다. 이때 문제의 예제를 보았을 때, 단순 선택, 합산, 감산 3가지 경우를 모두 고려해야한다
 * 2. depth가 n이 되었을 때, 합산의 수가 0보다 크면 ans배열에 true 체크를한다
 * 3. dfs 종료 후, true가 아닌 인덱스의 개수를 세어주고 출력하면 정답이 된다
 * 4. 한가지 주의할점이 백트래킹을 사용하면 더 최악의 시간복잡도가 나와서 시간초과가 발생한다
 * 5. n만큼 순회를 돌면서 방문 배열을 통해 선택 여부를 결정하는데, n만큼 순회를 n의 깊이만큼 백트래킹하므로 시간복잡도가 O(n^n)이 발생한다
 * 6. 심지어 선택지를 3가지 생각해야하므로 O(3n^n)이 되므로 39^13이라는 최악의 경우의 수를 만나게 된다
 * 7. 따라서 백트래킹이 아닌 dfs로 문제를 해결해야지 시간초과없이 문제를 해결할 수 있다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(3^n)
 * 공간복잡도: O(s)
 *
 */

public class Main {

    static boolean[] ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s += arr[i];
        }
        ans = new boolean[s+1];

        dfs(n, 0, 0);
        int count = 0;
        for (int i = 1; i < s + 1; i++) {
            if(!ans[i]) {
                count++;
            }
        }
        bw.write(count+"");

        br.close();
        bw.close();
    }

    private static void dfs(int n, int depth, int sum) {
        if(depth == n ){
            if(sum > 0){
                ans[sum] = true;
            }
            return;
        }

        dfs(n, depth+1, sum);
        dfs(n, depth+1, sum + arr[depth]);
        dfs(n, depth+1, sum - arr[depth]);
    }

}

