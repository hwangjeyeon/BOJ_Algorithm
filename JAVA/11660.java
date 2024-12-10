import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. m번의 입력동안 n^2 순회를 돌 경우 시간초과가 발생한다. 따라서 미리 누적합으로 계산해두고 바로 출력하는 전략을 취해야한다
 * 2. 누적합 방법은 현재 지점의 값 + 현재지점의 x-1, y-1지점의 누적합을 각각 합산하고 중복되는 부분인 x-1 y-1 지점의 누적합을 더한다
 * 3. 출력할 때는 기준이 되는 y2,x2지점의 누적합 값에서 y2와 x2와 같은 높이이면서 x1-1, y1-1인 지점의 누적합을 빼준다
 * 4. 또한 여기서도 중복으로 빼진 부분을 합산하기 위해 x1-1, y1-1인 지점의 누적합을 합산해준다
 * 5. 해당 값을 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sum = new int[n+1][n+1];
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];

            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }

}
