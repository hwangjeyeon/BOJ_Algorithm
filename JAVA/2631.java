import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 직접 정렬하면서 최소 숫자를 구하는게 정답일까? 했을 때, n!이라는 시간이 발생하기 때문에 적합하지 않다
 * 2. 따라서 다른 방법을 생각해야 한다.
 * 3. 줄 세우기의 최소 횟수는 언제 발생할까 생각해보자. 시작 값은 1일 것이다. 맨 처음 위치의 값이 1이 아니라면, 그 숫자만큼 뒤에 있는 값을 앞으로 옮기면 된다
 * 4. 더 확장해서 생각해보자. 만약 가장 길게 증가하는 부분 수열을 구한다면 어떻게 될까? 그때는 그 부분수열은 고정시킨 상태로 앞과 뒤나 사이에 있는 숫자만 재배치하면 된다
 * 5. 즉, 최장 증가 부분수열의 길이를 구하고 그 때 n에서 그 길이를 뺀만큼 아이를 옮긴다면 최소 수로 옮길 수 있다!
 * 6. 따라서 LIS를 구하면 된다. DP 배열을 똑같은 n 크기로 선언한다. n의 최대는 200이기 때문에 이중포문으로 해결한다
 * 7. dp[i] = 1로 초기화해준다. 자기자신을 부분수열로 선택하는 경우때문이다
 * 8. 이후 0부터 i전까지 순회하며, arr[j] < arr[i]인 경우를 구하자. 이때, 이전에 작은 숫자가 있다는 것이므로 dp를 갱신할 수 있다
 * 9. 그 이전과 이어지거나 이어지지 않을 수 있으므로 dp[i] = Math.max(dp[i], dp[j]+1)로 적절하게 최장으로 이어지도록 한다
 * 10. 순회 종료 후, n만큼 순회를 돌며 가장 큰 dp[i]를 구한다.
 * 11. 이후 n에서 max를 빼준 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(N^2)
 * 공간복잡도: O(N)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        bw.write(n-max + "");

        br.close();
        bw.close();
    }
}
