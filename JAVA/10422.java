import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. DFS로 풀기에는 시간초과가 발생한다. 따라서 다른 방법을 선택해야한다
 * 2. 먼저 해당 문제는 짝수번째만 올바른 괄호 문자열이 성립된다는 조건이 존재한다
 * 3. 또한 이전 짝수번째의 괄호 모양이 그 다음에도 활용할 수 있다는 점이 존재한다
 * 4. 따라서 DP로 해당 문제를 해결할 수 있다
 * 5. 8번째까지 모든 괄호의 수를 직접 생각해봤다.
 * 6. 처음에는 단순히 dp[i] = dp[i-2]*2로 간단한 규칙으로 해결할 수 있을 것이라 생각했으나 금방 반례가 나와서 틀렸다
 * 7. 다시 8번째까지 모든 괄호의 수를 직접 생각해보니 위 규칙을 위배하는 추가 경우가 발생하는 것을 확인했다.
 * 8. 또한 아예 괄호가 없는 0번째도 올바른 괄호 모양이 될 수 있다. 이점을 고려하면 dp[6] = 4 -> 5, dp[6] = 14가 된다
 * 9. 새로운 값을 고려했을 때, 규칙을 다시 살펴보면 이전에 누적한 경우의 수를 조합해서 합산한다. 5000이 최대이므로 이중포문이 가능하다
 * 10. 따라서 이중포문으로 i의 이전값 j를 모두 확인하는데 짝수만큼 늘어나노록 한다
 * 11. 이때 새롭게 생기는 점화식은 dp[i] += dp[j] * dp[i-(j*2)];이다. 
 * 12. 처음에는 합산할 때, 1_000_000_007을 나눠줬는데, 이렇게 하면 합산하는 수만 연산되므로 먼저 합산한다음 이어서 나눠야 한다.
 * 13. 이제 테스트케이스별로 숫자를 입력받아 해당 위치의 dp값을 출력하면 정답이 된다. 
 *
 * 해결방법:
 *
 * 시간복잡도: O(L^2)
 * 공간복잡도: O(5001)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for (int i = 4; i < 5001; i+=2) {
            for (int j = 0; j < i; j+=2) {
                dp[i] += (dp[j] * dp[(i-(j+2))]);
                dp[i] %= 1_000_000_007;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(dp[a] + "\n");
        }


        br.close();
        bw.close();
    }


}
