import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 과거에 풀었던 누적합 문제와 유사하게 해결하면 된다
 * 2. dp는 y축과 x축의 바로 이전까지의 누적합을 더하고 중복되는 현재지점의 y-1, x-1지점의 값을 더한 뒤, 현재 지점의 원소값을 더한다
 * 3. k개의 입력을 각각 출력하면 되는데, 주의할점이 두 지점의 x와 y가 같을 수 있다는 점이다. 따라서 단순히 두 누적합 지점을 가지고 출력하면 안된다
 * 4. 두 지점의 범위를 생각해서 직사각형을 그린다고 생각하고 해결하자.
 * 5. y2,x2 지점까지 누적합에서 y2,x1-1의 누적합과 y1-1,x2의 누적합을 빼고 중복되는 지점인 y1-1,x1-1지점을 더한 값을 출력하면 두 지점의 범위에 해당하는 누적합을 출력할 수 있다
 *
 * 해결방법:
 * 
 * [테스트 케이스]
 * 4 4
 * 9 14 29 7
 * 1 31 6 13
 * 21 26 40 16
 * 8 38 11 23
 * 1
 * 1 2 3 2
 * 실행결과: 71
 *
 * 시간복잡도: O(n*m)
 * 공간복잡도: O(n*m)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ay = Integer.parseInt(st.nextToken());
            int ax = Integer.parseInt(st.nextToken());
            int by = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken());

            bw.write(dp[by][bx] - dp[ay-1][bx] - dp[by][ax-1] + dp[ay-1][ax-1] + "\n");
        }



        br.close();
        bw.close();
    }

}
