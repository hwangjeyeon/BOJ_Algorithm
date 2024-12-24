import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 배낭 문제를 학습한 후, 해결한 문제다
 * 2. 배낭문제의 원리를 이용해서 해결하는데, 각각 몇번째의 가방을 선택할 때마다 가능한 무게를 비교하여 탐색한다
 * 3. 이때, 배낭에 담으려고 하는 현재 물건의 무게가 현재탐색한 무게보다 므다면 이전 선택지에서의 탐색 무게를 그대로 갱신한다
 * 4. 만약 작거나 같다면 이전 선택지에서의 탐색 무게와 이전 선택지에서 탐색무게 - 현재 물건의 무게를 뺀 위치의 값을 비교해서 더 큰 값으로 갱신한다
 * 5. 완성한 n번째의 k무게의 값을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*k)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][2];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if(arr[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], arr[i][1] + dp[i - 1][j - arr[i][0]]);
                }
            }
        }

        bw.write(dp[n][k]+"");
        
        br.close();
        bw.close();
    }

}
