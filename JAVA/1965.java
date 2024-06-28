

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 * - 문제 해결:
 * 1. 자기자신은 기본적으로 상자에 넣어지므로 dp의 초기값들은 1이다.
 * 2. dp에는 현재 위치의 상자에 넣어진 상자 개수를 담고 있다
 * 3. 이때 이중포문을 돌면서 자신의 이전값을 탐색하는데 입력값이 자신이 크다면 다음을 비교해서 더 큰 값을 넣는다
 * 4. 현재 dp[i]의 값과 dp[j]에서 i를 넣은 dp[j]+1중 누가 더 큰지를 비교한다
 * 5. 이후 max값에는 dp를 순회하여 가장 큰 값을 넣어주고 출력한다
 * 
 *
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(max+"");

        br.close();
        bw.close();
    }
}

