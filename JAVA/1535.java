import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 유명한 0-1 배낭문제이기 때문에 해당 개념을 학습하고 풀었다.
 * 2. 해당 문제에서는 인사를 했을 때와 안했을 때를 선택할 수 있고, 그때마다의 행복을 기록해두면 된다
 * 3. 따라서 dp에는 행복도가 값으로 들어가 있고 이중 dp를 사용하여 dp[i][w]에서 i는 인사 번호, w는 현재 체력을 의미한다
 * 4. 이때 i는 n까지고 j는 health까지 탐색하는데 health는 100이 아닌 99로 초기화한다. 100이면 주어진 조건의 0이나 음수가 되었을 때 죽는다는 경우에 해당되기 때문이다
 * 5. 이때 damage가 j보다 크면 인사 안하는 경우로보고 dp[i][j] = dp[i-1][j];라는 점화식을 세운다
 * 6. 5번이 아닌 경우 dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-damage[i]] + happy[i])라는 점화식을 세워 인사 하는 경우와 안 하는 경우로 나누고 둘중 큰 경우를 선택한다
 * 7. 이후 최종결과인 dp[n][health]를 출력하여 정답을 출력한다
 *
 * 시간복잡도: O(n*health)
 * 공간복잡도: O(n*health)
 *
 */





public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] damage = new int[n+1];
        int[] happy =  new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            damage[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }
        int health = 99;
        int[][] dp = new int[n+1][health+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < health+1; j++) {
                if(damage[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-damage[i]] + happy[i]);
                }
            }
        }

        bw.write(dp[n][health]+"");


        br.close();
        bw.close();
    }

}

