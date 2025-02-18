import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배낭정리 문제다. 풀 수 있는 남은 문제 수를 무게라 하고, 벌금을 가치라 한다.
 * 2. 1차원 dp로 풀 수 있는 문제다. 
 * 3. 또한 몇가지 더 구현해야하는데, 먼저 전체 벌금의 비용을 합산하고, 벌금이 비싼 경우부터 먼저 풀어야 하므로 무게를 역순으로 탐색한다
 * 4. 이때, 만약 현재 무게가 j보다 크다면 break하고 아닌 경우 dp[j] = Math.max(dp[j- arr[i][0]] + arr[i][1])로 갱신한다
 * 5. 이 문제의 해결 포인트는 벌금을 합산한 비용으로 생각해서 배낭정리로 푸는 것이다 최솟값으로 구하려고 하면 문제를 해결할 수 없다
 * 6. 완성한 dp[t]를 sum에서 뺀 값으로 출력하면 정답이 된다. 만약 문제를 모두 해결할 수 있다면 자동으로 0원이 출력된다
 * 
 * 해결방법:
 *
 * 시간복잡도: O(n*t)
 * 공간복잡도: O(n)
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
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            sum += arr[i][1];
        }
        int[] dp = new int[t+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = t; j >=0 ; j--) {
                if(arr[i][0] > j){
                    break;
                }
                dp[j] = Math.max(dp[j], dp[j-arr[i][0]] + arr[i][1]);
            }
        }

        bw.write(sum - dp[t] + "");

        br.close();
        bw.close();
    }

}
