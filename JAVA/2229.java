import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 2중 포문 DP로 해결할 수 있는 문제다
 * 2. dp[i]를 현재 i번째 학생으로 만들 수 있는 조가 잘짜여진 정도의 최댓값이라고 생각하자
 * 3. 그리고 j번째 부터 i번째까지 학생으로 만들 수 있는 그룹의 최댓값을 dp[i]와 비교하자. 
 * 4. 이때 dp[j-1]에는 이미 그때까지 구할 수 있는 최댓값이 기록되어있기 때문에 이점을 그냥 활용하면 된다
 * 5. 따라서 점화식은 dp[i] = Math.max(dp[i], dp[j-1] + (max - min)); 이 된다
 * 6. 완성한 dp[n]을 출력하면 정답이 된다.
 *
 * 해결방법:
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
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                int score = diff(j, i, arr);
                dp[i] = Math.max(dp[i], dp[j-1] + score);
            }
        }


        bw.write(dp[n]+"");

        br.close();
        bw.close();
    }
    private static int diff(int start, int end, int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end+1; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return max - min;
    }

}
