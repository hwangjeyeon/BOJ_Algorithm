import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배낭정리로 해결하는 문제다. 가치는 점수, 비용은 예상공부시간이다.
 * 2. 처음에는 최대 나올 수 있는 경우의 수를 구한다음 max값을 다시 순회해서 구하려고 했으나, 그렇게 할경우 원하는 출력값으로 나오지 않는다. 중복합산도 포함될 수 있기 떄문이다
 * 3. 따라서 n번째 t시간의 dp값을 출력하기로 결정했다. 이렇게 하는 것이 배낭정리의 정의에 더 부합하기 때문이다
 * 4. 완성한 dp[n][t]를 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*t)
 * 공간복잡도: O(n*t)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][t+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < t+1; j++) {
                if(arr[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], arr[i][1] + dp[i-1][j-arr[i][0]]);
                }
            }
        }

        bw.write(dp[n][t]+"");


        br.close();
        bw.close();
    }

}
