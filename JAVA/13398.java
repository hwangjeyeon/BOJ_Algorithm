import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 2차원 dp를 이용해서 풀었다. dp[현재 선택한 숫자][삭제여부]로 구분했고, 삭제여부는 0과 1로 삭제하지 않은 경우와 한 경우로 구분했다
 * 2. ans는 arr[0]으로 초기화한다. 그리고 첫번째 dp[0][0], dp[0][1]은 무조건 하나는 선택되어야 하므로 arr[0]을 넣어준다
 * 3. 1부터 n-1까지 순회하며 두 점화식에 해당하는 값을 dp에 넣는다
 * 4. dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]) 점화식을 실행한다. 
 * 5. 이 경우는 삭제되지 않은 경우로 이전까지 연속된 수의 결과를 이어나갈 것인지 아니면 지금부터 새로시작할 것인지 구분하는 것이다
 * 6. dp[i][1] = Math.max(dp[i-1][1] + arr[i], dp[i-1][0]) 점화식도 실행한다
 * 7. 이 경우는 이번에 제거되지 않아 이번에 제거한 경우와 이전에 제거된적이 있어 이번의 수를 합하는 경우다
 * 8. 그 결과를 ans와 dp[i][0], dp[i][1]을 비교해 셋중에서 가장 큰값으로 ans를 갱신한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n*2)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = arr[0];
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i] + dp[i-1][0], arr[i]);
            dp[i][1] = Math.max(arr[i] + dp[i-1][1], dp[i-1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
