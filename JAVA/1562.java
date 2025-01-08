import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. DP와 비트마스킹을 활용해서 해결하는 문제다
 * 2. 이 문제는 계단수도 고려하면서 0~9까지 모든 숫자가 등장하는 계단수도 확인해야 한다
 * 3. 주어진 길이만큼 확인하면서, 마지막의 오는 숫자가 0~10인 경우를 모두 확인한다
 * 4. 단 예외 조건으로 첫번째 숫자는 0이 되면 안된다고 했기 때문에, 미리 첫번째만 1~10까지 오는 경우로 확인한다
 * 5. 이제 현재 조합한 숫자에서 0~9까지의 모든 숫자가 오는지 확인해야한다
 * 6. 단순히 반복문으로 풀어서 해결하자니 엄청 복잡해질 것 같다. 이때 등장하는 개념이 비트마스킹이다
 * 7. 0~9를 각각 하나의 비트로 판단하고 모두 온다면 1111111111가 될 것이다
 * 8. 마지막 순서에서 마지막 숫자의 모든 경우 중, 비트가 1111111111와 같은 경우 dp값을 합산한다면 정답이 될 것이다
 * 9. 따라서 3차원 dp를 이용해서 문제를 해결한다. 3중 포문중 가장 내부 반복문은 1111111111까지 확인해야한다.
 * 10. 또한 각 값에다가 이전 포문의 마지막에 추가된 값을 더해서 비트 원소를 추가한다.
 * 11. 이렇게 완성한 값중 1이 표기된 위치가 현재 숫자에 포함된 숫자원소일 것이다
 * 12. 1~8까지는 계단 수가 되기 위해서 자신의 이전과 이후의 경우를 모두 합산해야한다.
 * 13. 하지만 0과 9는 이후와 이전만 확인할 수 있으므로 구분해서 누적합산한다
 * 14. 모듈러 연산을 반드시 하며, 모든 작업이 끝난 후 ans에 합산하여 출력하면 정답이 된다 
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*10*1024)
 * 공간복잡도: O(n*10*1024)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[n+1][10][1<<10];
        for (int i = 1; i < 10; i++) {
            dp[1][i][1<<i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int visited = k | (1<<j);
                    if(j == 0){
                        dp[i][j][visited] += dp[i-1][j+1][k];
                        dp[i][j][visited] %= 1_000_000_000;
                        continue;
                    }
                    if(j == 9){
                        dp[i][j][visited] += dp[i-1][j-1][k];
                        dp[i][j][visited] %= 1_000_000_000;
                        continue;
                    }
                    dp[i][j][visited] += (dp[i-1][j-1][k] + dp[i-1][j+1][k]);
                    dp[i][j][visited] %= 1_000_000_000;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n][i][(1<<10)-1];
            ans %= 1_000_000_000;
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
