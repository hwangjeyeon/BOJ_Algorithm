import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 처음에는 배낭문제로 생각했으나 이중포문이 불가능하기 때문에 선택할 수 없는 방버이다
 *
 * 해결방법:
 * 1. 해결방법은 DP와 이분탐색을 함께 사용하는 것이다
 * 2. 먼저 DP의 경우 두가지 경우를 생각한다. 현재 선택된 높이를 선택하거나 선택하지 않는 경우이다
 * 3. 이때 이분탐색으로 현재 위치의 값보다 앞에 세울 수 있는 그림 중 높이가 가장 높은 그림을 찾는다
 * 4. 그리고 찾은 경우 현재 선택된 높이 + 비용과 이전 선택지의 비용을 비교해서 더 큰 값으로 설정한다
 * 5. 만약 못 찾은 경우 이전까지의 비용과 현재 높이의 비용만을 비교해서 더 큰 값으로 누적한다
 * 6. 이렇게 완성한 결과 dp[n-1]을 출력하면 정답이 된다,.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(nlogn)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = h;
            arr[i][1] = c;
        }
        Arrays.sort(arr,(o1, o2)->{
            return o1[0] - o2[0];
        });
        int[] dp = new int[n];
        dp[0] = arr[0][1];
        for (int i = 1; i < n; i++) {
            int find = binarysearch(i, arr, s);
            if(find >= 0){
                dp[i] = Math.max(dp[i-1], dp[find] + arr[i][1]);
            }else{
                dp[i] = Math.max(dp[i-1], arr[i][1]);
            }
        }


        bw.write(dp[n-1]+"");
        
        br.close();
        bw.close();
    }

    private static int binarysearch(int pos, int[][] arr, int s) {
        int left = 0;
        int right = pos;
        while(left <= right){
            int mid = (left + right) / 2;
            int diff = arr[pos][0] - arr[mid][0];
            if(diff >= s){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }
}
