import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 
 *
 * 해결방법:
 * 1. 배낭정리를 이용해서 해결하는 문제다.
 * 2. 배낭문제에서 무게의 역할을 하는 것이 인원이고, 가치의 역할을 하는 것은 비용이다
 * 3. 또한 이 문제는 비용의 최솟값을 구해야하므로 0번인덱스를 제외한 모두 최대 비용으로 초기화해야한다
 * 4. 추가적으로 한가지 더 주의해야하는데, 인원을 적어도 C명을 늘린다는 했기 때문에, C명으로 고정된 것이 아니고 그 이상의 인원을 확인해야할 수도 있다
 * 5. 따라서 비용당 고객의 최대수는 100이므로 C명부터 c+100명까지 확대해서 확인해야한다
 * 6. dp를 배낭정리로 갱신하는데 c명부터 c+100명전까지 탐색하며, 그 인원에 필요한 비용을 구한다
 * 7. dp[j-현재 인원]의 값이 갱신된 경우만 비교해서 오버플로우를 방지한다
 * 8. 완성한 후에는 c부터 c+100전까지 탐색하며, 최댓값으로 초기화한 ans를 dp와 비교해서 최솟값으로 갱신한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(c)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        int[] dp = new int[c + 100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i][1]; j < c+100; j++) {
                if (dp[j-arr[i][1]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], arr[i][0] + dp[j-arr[i][1]]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = c; i < c+100; i++) {
            ans = Math.min(ans, dp[i]);
        }

        bw.write(ans + "");

        br.close();
        bw.close();
    }

}
