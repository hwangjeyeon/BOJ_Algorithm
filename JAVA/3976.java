import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 두 사람을 놓고 각각의 특성대로 선택했을 때 누적해서 비교해야하므로 2차원 DP를 사용해야한다
 * 2. dp는 현재 누적된 난이도로 점화식은 각각 2개가 나오게된다
 * 3. dp[j][0], dp[j][1]은 각각의 사람을 의미한다.
 * 4. 이때 현재의 난이도는 이전에도 자기자신이 가지고 있고 현재도 드리블을 선택하는 경우거나 이전의 다른 사람이 가지고 있고 패스하는 경우다
 * 5. 따라서 다음과 같은 점화식이 뽑힌다. dp[j][0] = Math.min(dp[j-1][0] + dribble[j-1][0], dp[j-1][1] + pass[j-1][1]); dp[j][1] = Math.min(dp[j-1][1] + dribble[j-1][1], dp[j-1][0] + pass[j-1][0]);
 * 6. 이어서 ans에는 Math.min(dp[n-1][0] + s1, dp[n-1][1] + s2); 식으로 완성한 난이도에 슛을 하는 난이도를 더했을 때 가장 작은 값을 넣어준다
 * 7. 이후 ans를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O(T*n-1)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int[][] pass = new int[n-1][2];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n - 1; j++) {
                pass[j][0] = Integer.parseInt(st.nextToken());
            }
            int[][] dribble = new int[n-1][2];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n - 1; j++) {
                dribble[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n - 1; j++) {
                pass[j][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n - 1; j++) {
                dribble[j][1] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[n][2];
            dp[0][0] = l1;
            dp[0][1] = l2;
            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j-1][0] + dribble[j-1][0], dp[j-1][1] + pass[j-1][1]);
                dp[j][1] = Math.min(dp[j-1][1] + dribble[j-1][1], dp[j-1][0] + pass[j-1][0]);
            }
            ans = Math.min(dp[n-1][0] + s1, dp[n-1][1] + s2);

            bw.write(ans+"\n");
        }


        br.close();
        bw.close();
    }



}

