import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. w를 선택하는 개수와 h를 선택하는 경우로 나눠서 파악하기 위해 2차원 dp를 활용한다
 * 2. 문제를 잘 읽어보면 처음은 무조건 w를 선택해야한다. 따라서 dp[i][0]은 무조건 1이다
 * 3. 또한 h의 개수와 w의 개수는 반드시 같거나 w보다 h가 작아야한다
 * 4. 이점을 이용하면 2차원 평면에서 반쪽만 채워지는 방식임을 알 수 있다
 * 5. 따라서 다음과 같이 점화식을 세울 수 있다. dp[i][0] = 1, dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 6. 그리고 마지막 dp[i][i]은 무조건 그 이전의 값만 가져온다 dp[i][j-1]로 하면 된다
 * 7. 이후 테스트케이스마다 미리 구해둔 dp의 값을 출력하면 정답이 된다
 * 8. 추가로 dp는 long타입으로 하자 long타입을 벗어나지는 않지만 int형 범위를 벗어난다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*n)
 * 공간복잡도: O(n*n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][] dp = new long[31][31];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 2;
        dp[2][2] = 2;
        dp[3][0] = 1;
        dp[3][1] = 3;
        dp[3][2] = 5;
        dp[3][3] = 5;
        for (int i = 4; i < 31; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
            dp[i][i] = dp[i][i-1];
        }

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }
            bw.write(dp[n][n] + "\n");
        }

        br.close();
        bw.close();
    }


}
