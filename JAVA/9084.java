import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배낭정리를 활용해서 해결하는 문제다. 
 * 2. 배낭정리의 핵심은 비용과 무게의 대상을 정하는 것이다
 * 3. 이 문제에서 가능한 방법의 수는 비용이고, 동전의 가치는 무게다
 * 4. 즉 M이라는 무게를 갖추기 위해 N번의 순번만큼 탐색하면서 0~M까지의 모든 비용을 누적 합산한다
 * 5. 이 문제는 다른 배낭정리 문제랑 다르게 가능한 방법의 수가 명확하게 나와있지 않다
 * 6. 따라서 다음과 같이 정의하였다. 먼저 dp는 1차원 배열이며, 현재 확인하는 무게에서 현재 순번의 무게를 뺀 값이 0보다 크면 현재 j의 dp에 이전 dp[j-arr[j]]를 더한다
 * 7. 만약 0일 경우는 현재 무게를 더했을 때 한가지 경우밖에 존재하지 않으므로, 1을 더한다
 * 8. 완성한 m의 dp를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(t*n*m)
 * 공간복잡도: O(m)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < m + 1; j++) {
                    if(j-arr[i] > 0){
                        dp[j] += dp[j-arr[i]];
                    }else if(j-arr[i] == 0){
                        dp[j] = dp[j] + 1;
                    }
                }
            }

            bw.write(dp[m] + "\n");

        }

        br.close();
        bw.close();
    }

}
