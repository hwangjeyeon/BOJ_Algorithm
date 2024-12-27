import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. N이 150만이며, 금액을 일수에 따라 누적해나갈 수 있기 때문에 dp로 해결할 수 있는 문제다
 * 2. 따라서 현재 일수인 i에다가 arr[i][0]인 상담일수를 더한 위치에 현재의 금액을 더해서 누적해나가는 식으로 해결했다
 * 3. 처음에는 그 날짜에 누적된 금액을 더하는 식으로 하려고 했으나 그렇게 하면 반례가 생긴다
 * 4. 따라서 최댓값을 갱신해나가며, 현재의 비용에다가 최댓값을 더한 값과 현재에서 상담한 일수의 누적된 금액을 비교해서 더 큰값으로 현재의 상담 비용을 갱신한다
 * 5. 최댓값은 매 상담일자마다 비교하며, 더 큰 경우 갱신한다
 * 6. 이 문제의 핵심은 퇴사일도 생각을 해야한다. 왜냐하면 마지막 일자의 상담소요시간이 1일일 경우, 당일 끝낼 수 있기 때문에 금액을 추가해서 계산해야 한다
 * 7. 따라서 퇴사일을 하나 더 만들고, 값을 갱신해나가며 최종적으로 퇴사일의 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][2];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = p;
        }

        int[] dp = new int[n+2];
        int max = 0;
        for (int i = 1; i <= n + 1; i++) {
            if(max < dp[i]){
                max = dp[i];
            }

            if(i+arr[i][0] > n+1){
                continue;
            }
            dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], arr[i][1] + max);
        }
        bw.write(dp[n+1]+"");

        br.close();
        bw.close();
    }

}
