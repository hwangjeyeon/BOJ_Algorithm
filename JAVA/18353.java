import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. LIS 문제다. 초기값은 모두 1로 설정하고 자신의 이전을 이중포문으로 탐색하면서 자신보다 작은 숫자가 있으면 dp[i]에 dp[i]와 dp[j] + 1중 더 큰값을 넣어준다
 * 2. 그리고 각 dp 순회마다 마지막에 max와 비교해서 가장 큰값을 찾아주고 n-max로 정답을 출력한다
 *
 * 해결방법:
 * 1. 처음에는 열외되는 숫자로 잘못생각하였다가 틀렸었다
 * 2. 다시 생각을 바꾸어보니 해당 문제를 LIS로 해결하려면 자신보다 큰 병사를 찾아서 그 개수를 누적해 나가는 방식이 최대로 병사의 수를 유지할 수 있는 방식이었다
 * 3. 따라서 DP의 목적을 바꾸어 로직을 변경 시켰고, 최종적으로 n에서 max만큼 뺀 값이 열외된 숫자이므로 n-max를 출력하였다.
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

        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        bw.write(n - max+"");

        br.close();
        bw.close();
    }

}

