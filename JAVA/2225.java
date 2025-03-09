import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 처음에는 dfs로 풀어봤다. 당연히 시간초과가 발생한다
 * 2. 두번째는 dp의 top-down을 이용해서 풀었다
 * 3. 이번에는 2차원 dp를 활용해서 n번째 숫자를 k번째 숫자로 포함했을 때, 누적된 선택개수를 dp에 포함시키도록 했다
 * 4. dfs로 초기 구성했기 때문에 탑다운으로 풀었다
 * 5. n과 k를 넘겨주며, 만약 k가 0인 경우 n이 0이면 1을 리턴하고, 아니면 0을 리턴한다. 0인 경우는 어떠한 합산을 하더라도 이전에 호출한 합산의 결과에 경우의 수로 선택가능하기 떄문이다
 * 6. 그 이외의 경우는 num이 0보다 작아 더이상 선택할 수 없는 경우 0을 리턴하고 이미 방문한 dp는 -1이 아니므로 dp를 리턴한다
 * 7. 그 외에는 현재 num과 depth의 dp배열에 현재 num이 선택되지 않아 num-1만 한 경우와 선택되어서 depth-1만 한 경우의 합산을 MOD로 나눈 결과를 더해준다
 * 8. 완성한 최초의 DP를 리턴하고 그 결과를 출력하면 정답이 된다.
 * 
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*k)
 * 공간복잡도: O(n*k)
 *
 */


public class Main {

    static int MOD = 1_000_000_000;
    static int ans;
    static int n;
    static int k;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ans = 0;
        dp = new int[n+1][k+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }

        bw.write(topDown(n,k)+"");
        
        br.close();
        bw.close();
    }

    private static int topDown(int num, int depth) {
        if(depth == 0){
            if(num == 0){
                return 1;
            }
            return 0;
        }
        if(num < 0){
            return 0;
        }
        if(dp[num][depth] != -1){
            return dp[num][depth];
        }

        dp[num][depth] = (topDown(num-1, depth) + topDown(num, depth - 1)) % MOD;

        return dp[num][depth];
    }

}
