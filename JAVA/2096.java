import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. N * 3크기의 dp 배열을 2개 만들거나 3차원 배열을 하나 만들어서 관리하면 해결할 수 있다
 * 2. 두개의 배열을 만들거면 최댓값 dp와 최솟값 dp를 만들면 된다
 * 3. 인덱스 범위를 벗어나지 않으면서 내 이전 값과 대각선 방향의 이전값 중에서 가장 큰값과 작은 값을 누적하여 합산하면 된다
 * 4. 최종 n-1번째 인덱스에서 3개의 원소들을 모두 비교하여 최댓값과 최솟값을 구하고 출력하면 정답이 된다
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n * 3 * 2)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int a = Integer.parseInt(st.nextToken());
                maxDp[i][j] = a;
                minDp[i][j] = a;
            }
        }

        for (int i = 1; i < n; i++) {

            maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + maxDp[i][0];
            maxDp[i][1] = Math.max(maxDp[i-1][0], Math.max(maxDp[i-1][1], maxDp[i-1][2])) + maxDp[i][1];
            maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + maxDp[i][2];

            minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + minDp[i][0];
            minDp[i][1] = Math.min(minDp[i-1][0], Math.min(minDp[i-1][1], minDp[i-1][2])) + minDp[i][1];
            minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + minDp[i][2];

        }
        bw.write(Math.max(Math.max(maxDp[n-1][0], maxDp[n-1][1]), maxDp[n-1][2])+ " " +
                Math.min(Math.min(minDp[n-1][0], minDp[n-1][1]), minDp[n-1][2]));


        br.close();
        bw.close();
    }
}

