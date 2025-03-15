import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS + 이분탐색이 포함된 문제다
 * 2. 단순 LIS는 이중포문으로 증가하는 수열의 최대 길이를 DP에 누적하면 되는데, LIS +이분탐색인 경우는 다르게 풀어야한다
 * 3. 길이는 별도의 변수로 관리하고 dp에는 실제 arr 배열의 값을 보관한다
 * 4. dp[0]은 첫번째 값을 보관한다. 길이는 1부터 시작한다
 * 5. 1부터 n-1까지 순회하며, 만약 현재의 arr값이 dp[len-1]값 보다 크다면 dp[len] = arr[i]하고 len++한다
 * 6. 아니라면 이분탐색을 해서 현재 값을 적절한 위치에 배치시켜놔야한다
 * 7. left는 0, right는 len-1이며 left < right동안 탐색한다
 * 8. mid를 구하고 만약 dp[mid] < arr[i]라면 left = mid + 1해서, 적절한 위치를 찾기 위해 범위를 좁혀나간다.
 * 9. 만약 크거나 같다면 right를 mid로 변경한다. 인덱스 범위를 이분탐색하기 때문에 right - 1을 하면 범위를 벗어날 수 있기 때문이다
 * 10. 완성한 dp[left]에 arr[i]을 넣는다. 이때 len은 증가하지 않는다. 이후 탐색을 위해 단순히 오름차순 정렬한 것이지 LIS는 아니기 때문이다
 * 11. 완성한 len을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n*logn)
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
        dp[0] = arr[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if(dp[len-1] < arr[i]){
                dp[len] = arr[i];
                len++;
            }else{
                int left = 0;
                int right = len - 1;
                while(left < right){
                    int mid = (left + right) / 2;
                    if(dp[mid] < arr[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                dp[left] = arr[i];
            }
        }
        bw.write(len+"");


        br.close();
        bw.close();
    }

}
