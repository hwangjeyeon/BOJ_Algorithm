import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 문제를 잘못 이해했다. 양옆 연속하는 한가지 수끼리의 곱만으로 구분하는줄 알았는데, 그것이 아니라 한가지 이상이라 연속된 수의 누적의 곱을 구하는 것이었다
 * 2. 따라서 DP를 활용해서 푸는 문제이다.
 * 3. 처음은 배열의 입력값만으로 하며 그다음부터는 그 이전 dp와 현재 배열의 값을 곱한 값과 현재 배열의 값을 비교해서 더 큰 값을 ans에 넣는다
 * 4. ans에 정답이 출력되도록 한다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double ans = 0.0;
        double[] dp = new double[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i] , dp[i-1] *arr[i]);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        bw.write(String.format("%.3f", ans));

        br.close();
        bw.close();
    }



}

