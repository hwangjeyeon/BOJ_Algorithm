import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 역발상으로 문제를 해결할 수 있다. 간단하게, 교차하지 않도록 철거해야할 개수를 구하는 것을 전체 전선의 개수에서 겹치지 않게 설치가능한 개수를 구해서 빼는 것으로 생각하면 된다
 * 2. 그렇게 하면 최대 설치 가능한 개수를 구할 수 있다
 * 3. A 전봇대 기준으로 i번재에 연결된 전깃줄을 잇고 이후 전선들을 탐색하며, i번째 연결된 B의 값보다 큰 경우들을 모두 탐색해보는 것이다
 * 4. 즉, 정렬된 A를 기준으로 B에 연결된 값들에서 LIS를 하면 된다
 * 5. 이후, 각 DP에서 최댓값을 구해 ANS를 갱신하고 N에서 ANS를 빼면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 1; i < n + 1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        bw.write(n-ans+"");
        
        br.close();
        bw.close();
    }

}
