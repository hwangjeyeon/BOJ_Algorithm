import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 추의 개수와 각 무게는 매 구슬을 확인할 때마다 고정되어 있다.
 * 2. 이점을 이용해서 모든 추를 조합해서 나올 수 있는 경우를 확인한다면, 쉽게 해결할 수 있을 것이다
 * 3. 이때 나올 수 있는 모든 경우의 무게를 체크한다면 더 쉽게 해결할 수 있다
 * 4. 이때 DP와 Top-Down방식을 선택하면 해당 문제를 쉽게 해결할 수 있다
 * 5. 각 추를 선택할 때마다 선택 가능한 조합은 다음과 같다
 * 6. 구슬이 없는 반대 쪽에 추를 추가하는 경우, 추를 어디에도 추가하지 않는 경우, 추를 빼서 구슬이 있는 쪽에 포함하는 경우다
 * 7. dp를 3차원 배열로 해서 판단해도 되겠지만, 어차피 무게가 조합되는지만 확인하면 되기 때문에 2차원 배열로 해결 가능하다
 * 8. 하나는 순서, 하나는 무게로 지정해서 미리 구해둔다
 * 9. 순서를 벗어나거나 이미 true라면 함수를 종료하고 아닐 경우 함수를 true로 바꾼다. 이때 순서로 종료하는 조건을 true체크와 true write보다 뒤에 배치해서 모든 추를 선택했을 때의 결과도 기록한다
 * 10. 이어서 구슬의 무게를 입력받는다. n번째 순서의, 구슬의 무게가 true인지 체크하고 맞다면 Y, 아니라면 N을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(30^3)
 * 공간복잡도: O(30*40_000)
 *
 */
public class Main {

    static int[] w;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        dp = new boolean[n+1][40001];
        dfs(n,0, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int orb = Integer.parseInt(st.nextToken());
            if(dp[n][orb]){
                bw.write("Y ");
            }else{
                bw.write("N ");
            }
        }

        br.close();
        bw.close();
    }

    private static void dfs(int n, int depth, int num) {
        if(dp[depth][num]){
            return;
        }

        dp[depth][num] = true;

        if(n == depth){
            return;
        }

        dfs(n,depth+1, num + w[depth]);
        dfs(n, depth+1, num);
        dfs(n, depth+1, Math.abs(num - w[depth]));
    }

}
