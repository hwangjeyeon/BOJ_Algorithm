import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 0-1 냅색 문제다. 동전 자체의 가치와 찾고자 하는 금액을 무게로 생각하면 된다
 * 2. 보통은 2차원 dp로 해결하는데 여기서는 동전의 비용만으로 가치와 무게의 역할을 모두 할 수 있기 때문에 1차원 dp로 해결한다
 * 3. 만약 j-arr[i]가 0보다 크면 j-arr[i]의 dp 값을 합산한다. 해당 동전의 가치만 더하면 되는 상황에서 그 동전의 가치를 만들 수 있는 모든 경우의 수를 합산하면 된다
 * 4. 만약 0이라면 경우의 수는 한가지이므로 1을 증가시킨다
 * 5. 완성한 dp의 m번째 값을 출력하면 정답이 된다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n+1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];

            for (int i = 1; i < n+1; i++) {
                for (int j = 0; j < m + 1; j++) {
                    if(j - arr[i] > 0){
                        dp[j] += dp[j-arr[i]];
                    }else if(j - arr[i] == 0){
                        dp[j]++;
                    }
                }
            }
            bw.write(dp[m] + "\n");
        }

        br.close();
        bw.close();
    }

}
