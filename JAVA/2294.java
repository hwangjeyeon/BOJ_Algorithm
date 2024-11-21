import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 어떤 가치를 얻기 위해서 필요한 동전의 수를 주어진 동전의 가치를 이용해서 만들어본다
 * 2. 이 과정을 위해서는 dp가 필요하다
 * 3. 먼저 입력 원소는 1이된다. 자기자신만 선택하면 최소가 되기 때문이다. 나머지는 모두 최댓값으로 초기화한다
 * 4. 단 최댓값으로 초기화하면 오버플로우가 발생하기 때문에 -1을 해서 초기화한다
 * 5. 이중포문을 돌면서 각 원소의 값부터 k까지 순회를 돌고, 해당 가치에 해당가치 - 현재 원소 위치에서 필요한 동전의 개수 + 1이랑 비교하여 더 작은 값으로 갱신한다
 * 6. 이 방법을 통해 dp[k]가 그대로라면 -1을 출력하고 아니면 그 값을 출력하면 정답이 된다.
 *
 * - 문제 해결:
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
        int[] dp = new int[100001];
        for (int i = 0; i < 100001; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }
        dp[0] = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            dp[arr[i]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE-1){
            bw.write("-1");
        }else{
            bw.write(dp[k] + "");
        }

        br.close();
        bw.close();
    }

}
