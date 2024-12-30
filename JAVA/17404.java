import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 *
 * 해결방법:
 * 1. 순환하는 배열이기 때문에, 이전 RGB거리 문제와는 다르게 풀어야한다
 * 2. 첫번째 값을 하나씩 선택하고, 나머지는 최댓값을 채워두는 방법으로 해결했다
 * 3. 두번째 값부터는 이전 RGP거리 문제와 똑같이 점화식을 세워서 마지막까지 갱신해나간다
 * 4. 마지막 값에서 최솟값을 찾아야하는데, 이때 첫번째에서 선택한 색과 같으면 안되기 떄문에 선택한 값을 제외하고 마지막값과 정답 최솟값을 갱신한다
 * 5. 이렇게 한다면, 순환하는 배열에서 첫번째와 마지막의 색이 동일한 경우가 없으면서 최소 비용을 구할 수 있다
 * 6. 한가지 주의할점이 최댓값을 Integer.MAX_VALUE로 하면 안된다. 최댓값만 선택해야하는 경우가 존재할 수 있기 때문에 오버플로우가 발생한다
 * 7. 따라서 정답의 가능한 최대를 구해서 해당 값을 최댓값으로 해야한다. 이 문제에서는 1000 * 1000이 가능한 최댓값이 된다.
 *
 *
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
        int[][] arr = new int[n+1][3];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][3];
        int ans = 1000*1000;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j){
                    dp[1][j] = arr[1][j];
                    continue;
                }
                dp[1][j] = 1000*1000;
            }

            for (int j = 2; j < n + 1; j++) {
                dp[j][0] = arr[j][0] + Math.min(dp[j-1][1], dp[j-1][2]);
                dp[j][1] = arr[j][1] + Math.min(dp[j-1][0], dp[j-1][2]);
                dp[j][2] = arr[j][2] + Math.min(dp[j-1][0], dp[j-1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if(i != j){
                    ans = Math.min(ans, dp[n][j]);
                }
            }
        }

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
