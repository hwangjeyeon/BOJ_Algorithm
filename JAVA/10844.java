import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 문제를 너무 통으로 보는 경향이 있다.
 * - 이전 동물원 문제도 그렇고 이런 2차원 배열을 활용하거나 연속되는 수의 문제는
 * 한칸씩, 한 숫자씩 보도록 하자
 *
 * 이것은 한 숫자를 보고 그 앞에 추가될 숫자를 생각했을 때를 생각하면 된다
 * 0일 경우 앞에는 1만 가능
 * 9일 경우 앞에는 2만 가능
 * 1~8일 경우 앞에는 2가지 수만 가능하다 이때 자기 자신에서 1을 빼고 더한 값만 가능하다
 *
 * 초기화 해줘야할 값
 * dp[1][0] = 0;
 * dp[2][0] = 1;
 * dp[3][0] = 1;
 * dp[4][0] = 1;
 * dp[5][0] = 1;
 * dp[6][0] = 1;
 * dp[7][0] = 1;
 * dp[8][0] = 1;
 * dp[9][0] = 1;
 *
 * 점화식
 * dp[i][0] = dp[i-1][1] % 1000000000;
 * dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1000000000;
 * dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % 1000000000;
 * dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % 1000000000;
 * dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % 1000000000;
 * dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % 1000000000;
 * dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % 1000000000;
 * dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % 1000000000;
 * dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % 1000000000;
 * dp[i][9] = dp[i-1][8] % 1000000000;
 *
 * 힌트를 조금 보았긴 했지만, 이전보다 유추하는 정도가 발전하게 보인다! 힌트 없이 나 혼자서 dp 문제를 풀어나갈 수 있을 떄까지 화이팅!
 * 시간복잡도: O(n)
 * 공간복잡도: O(n^2)
 *
 */




public class Main {

    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;

        IntStream.range(2, n+1)
                        .forEach(i -> {
                            dp[i][0] = dp[i-1][1] % 1000000000;
                            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 1000000000;
                            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % 1000000000;
                            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % 1000000000;
                            dp[i][4] = (dp[i-1][3] + dp[i-1][5]) % 1000000000;
                            dp[i][5] = (dp[i-1][4] + dp[i-1][6]) % 1000000000;
                            dp[i][6] = (dp[i-1][5] + dp[i-1][7]) % 1000000000;
                            dp[i][7] = (dp[i-1][6] + dp[i-1][8]) % 1000000000;
                            dp[i][8] = (dp[i-1][7] + dp[i-1][9]) % 1000000000;
                            dp[i][9] = dp[i-1][8] % 1000000000;
                        });

        bw.write((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5] + dp[n][6] + dp[n][7] + dp[n][8] + dp[n][9])% 1000000000 + "");
        br.close();
        bw.close();
    }

}
