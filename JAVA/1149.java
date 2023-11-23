import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *  * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 점화식: 
 * dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + arr[i][1];
 * dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + arr[i][2];
 * dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][3];
 *
 * - 각 첫번째 두번째 세번쨰를 선택하는 경우 비용을 dp[i][1], dp[i][2], dp[i][3] 이렇게 나누었다
 * - 1번 dp는 이전 2번 3번 중에서 선택해야 하고 2번은 1번 3번, 3번은 1번 2번 중 선택해야 한다.
 * - 각 dp에 이전 i-1 dp의 두 선택지중 최소값과 현재 i의 i자릿수(1~3)에 들어온 입력 값을 더해서 저장한다.
 * - 이렇게 했을 떄, 최종에서 이 3가지 경우 중 최소값을 선택하면 그것이 최종 최소 비용이 된다.
 * 
 * 시간복잡도: O(n)
 * 공간복잡도: O(n^2)
 *
 *
 */




public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[1001][4];
        dp = new int[1001][4];

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<n+1; i++){
            dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][3];
        }

        bw.write(Math.min(dp[n][3],Math.min(dp[n][1],dp[n][2])) + "");

        br.close();
        bw.close();
    }


}
