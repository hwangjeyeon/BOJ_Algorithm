import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 등식의 개수가 매우 많기 때문에 dp를 이용해야 한다
 * 2. long타입의 2차원 dp를 선언해주자. dp[현재 선택한 숫자의 개수][계산했을 때, 0~20범위]로 선언하며 값으로는 그때의 계산 개수다
 * 3. 맨처음 dp[0][arr[0]] = 1로 선언하며, 1부터 n-1, 0~20까지 2중포문으로 순회를 돌며 점화식을 실행한다
 * 4. 만약 현재 dp[i-1][j]가 0이 아니라면 이전의 계산 결과에 플러스나 마이너스를 해야한다.
 * 5. j+arr[i-1]과 j-arr[j-1]은 모두 0보다 크거나 같고 21보다 작아야한다. 이 조건에 해당된다면 dp[i][plus] += dp[i-1][j]를 해준다. 마이너스도 동일한다
 * 6. 이렇게 완성된 dp[n-2][arr[n-1]]의 결과를 출력하면 정답이 된다. n-2번째 수에서 arr[n-1]번 째 등식이 성립하는 개수다
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
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if(dp[i-1][j] != 0){
                    int plus = j + arr[i];
                    int minus = j - arr[i];
                    if(plus >= 0 && plus < 21){
                        dp[i][plus] += dp[i-1][j];
                    }
                    if(minus >= 0 && minus < 21){
                        dp[i][minus] += dp[i-1][j];
                    }
                }
            }
        }

        bw.write(dp[n-2][arr[n-1]]+"");

        br.close();
        bw.close();
    }
}
