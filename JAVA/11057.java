import java.io.*;


/**
 * 풀이 과정:
 * dp[1][i]은 전부 1로 초기화
 * 그외에 2부터 나머지는 다음 점화식을 따른다
 * dp[i][0] = dp[i-1][0]%10007;
 * dp[i][1] = dp[i][0] + dp[i-1][1]%10007;
 * dp[i][2] = dp[i][1] + dp[i-1][2]%10007;
 * dp[i][3] = dp[i][2] + dp[i-1][3]%10007;
 * dp[i][4] = dp[i][3] + dp[i-1][4]%10007;
 * dp[i][5] = dp[i][4] + dp[i-1][5]%10007;
 * dp[i][6] = dp[i][5] + dp[i-1][6]%10007;
 * dp[i][7] = dp[i][6] + dp[i-1][7]%10007;
 * dp[i][8] = dp[i][7] + dp[i-1][8]%10007;
 * dp[i][9] = dp[i][8] + dp[i-1][9]%10007;
 *
 * 해당 점화식을 전부 더한다음 출력 전에 한번 더 10007를 모듈러 연산해서 출력한다
 *
 * - 처음으로 힌트 없이 정확한 점화식을 도출해내서 기쁘다!!
 * - 모듈러 연산에서 살짝 힌트를 보기는 했지만 점화식 도출에 성공했다는게 정말 기쁘다!!
 * - 이제 2차원 DP에도 익숙해져가는듯...
 * - 이제 다른 개념으로 넘어가서 공부한 뒤, 다시 DP 문제 풀면서 감을 더 찾을 수 있도록 연습할 계획
 *
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
        dp = new long[1001][10];
        long sum = 0;
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<n+1; i++){
            dp[i][0] = dp[i-1][0]%10007;
            dp[i][1] = dp[i][0] + dp[i-1][1]%10007;
            dp[i][2] = dp[i][1] + dp[i-1][2]%10007;
            dp[i][3] = dp[i][2] + dp[i-1][3]%10007;
            dp[i][4] = dp[i][3] + dp[i-1][4]%10007;
            dp[i][5] = dp[i][4] + dp[i-1][5]%10007;
            dp[i][6] = dp[i][5] + dp[i-1][6]%10007;
            dp[i][7] = dp[i][6] + dp[i-1][7]%10007;
            dp[i][8] = dp[i][7] + dp[i-1][8]%10007;
            dp[i][9] = dp[i][8] + dp[i-1][9]%10007;
        }

        for(int i=0; i<10; i++){
            sum += dp[n][i];
        }

        bw.write(sum%10007 + "");


        br.close();
        bw.close();
    }

}
