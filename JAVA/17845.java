import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 배낭정리로 해결할 수 있는 문제다. 무게는 학점을 받기 위해 필요한 공부시간, 가치는 중요도를 의미한다
 * 2. DP로 배낭정리를 해결하는 방법을 이용하면 쉽게 구할 수 있다
 * 3. 해당 방법을 그대로 적용하되, N과 K의 위치만 바꿔서 크기를 설정하고 그대로 출력하면 정답이 된다.
 * 
 * 해결방법:
 *
 * 시간복잡도: O(k*n)
 * 공간복잡도: O(k*n)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[k+1][2];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[k+1][n+1];
        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(arr[i][1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], arr[i][0] + dp[i-1][j-arr[i][1]]);
                }
            }
        }

        bw.write(dp[k][n] + "");


        br.close();
        bw.close();
    }

}
