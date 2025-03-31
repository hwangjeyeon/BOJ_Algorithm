import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. boolean타입의 2차원 배열 dp를 사용하면 문제를 해결할 수 있다
 * 2. dp[선택한 곡의 번호][현재 곡의 볼륨]으로 선언한다 초기값 dp[0][s] = true로 한다
 * 3. 2중포문을 돌며 값을 구한다. 이때 dp[i-1][j]가 true인 경우만 작업을 진행한다
 * 4. j+arr[i]와 j-arr[i]값을 미리 구해둔다
 * 5. plus값이 m이하인 경우 dp[i][plus] = true, minus값이 m이하인 경우 dp[i][minus] = true로 초기화한다
 * 6. 이후 ans를 미리 -1로 선언한 뒤, n번째의 볼륨을 0~m까지 순회하며 true일 때마다 ans를 i와 비교해 최댓값으로 갱신한다
 * 7. 최종 완성한 ans를 출력하면 정답이 된다. 만약 하나도 없다면 갱신이 되지 않으므로 -1이 출력된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][s] = true;

        for (int i = 1; i < n + 1; i++) {

            for (int j = 0; j < m + 1; j++) {
                if(dp[i-1][j]){
                    int plus = j + arr[i];
                    int minus = j - arr[i];

                    if(plus <= m){
                        dp[i][plus] = true;
                    }
                    if(minus >= 0){
                        dp[i][minus] = true;
                    }
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < m + 1; i++) {
            if(dp[n][i]){
                ans = Math.max(i, ans);
            }
        }
        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
