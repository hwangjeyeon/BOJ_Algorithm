import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 3차원 배열 dp를 사용해서 해결할 수 있는 문제다
 * 2. dp[시간][이동횟수][선택나무번호]로 관리하면 된다
 * 3. 이 문제는 선택나무 번호에 따라 경우의 수를 다르게 해서 점화식을 세우면된다
 * 4. 위 과정은 초기화부터 시작된다.
 * 5. 만약 첫번째 원소값이 1인경우, 아니면 2인경우 각각 dp[1][0][1]과 dp[1][1][2] 에 1을 더한다. 반대는 0으로 초기화한다
 * 6. 자두는 현재 1번 나무에 있기 때문에 초기화할 때, 첫번째 원소가 2인 경우 이동한 dp[1][1][2]에 1을 더하는 것이다
 * 7. 2번째 시간부터 t까지 순회하며 현재 원소가 1인 경우와 2인 경우를 구분해서 점화식을 진행한다
 * 8. 원소가 1인 경우, dp[i][0][1] = dp[i-1][0][1] + 1, dp[i][0][2] = dp[i-1][0][2]로 초기화하고, 1부터 w까지 순회하며 dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1와 dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j]]2[)를 진행한다
 * 9. 원소가 2인 경우는 +1의 위치만 각각 반대로 바꿔주면 된다
 * 10. 만약 이동 횟수가 0인 경우는 이번에도 이동하지 않겠다는 의미이므로 원소가 같다면 이전까지 누적된 횟수 + 1을 더해준다. 만약 원소가 같지 않으면 선택하지 않으므로 그냥 이전 dp를 누적한다
 * 11. 이어서 모든 체력을 순회하며 dp를 채워나가는데 원소와 동일한 경우만 선택해서 +1을 해주면 된다. 각 경우는 이전 원소와 동일한 값으로 가는 경우와 이동하지 않은 이전 체력의 다른 원소의 경우와 비교 해더 큰 값으로 바꾼다.
 * 12. 이렇게 순회가 종료된다음 추가 순회를 통해 dp[t][i][0]과 dp[t][i][1] 그리고 ans와 최댓값을 비교하여 ans를 갱신한다
 * 13. 최종결과 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(t*w)
 * 공간복잡도: O(t*w*3)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[t+1];
        for (int i = 1; i < t+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = 0;
        int[][][] dp = new int[t+1][w+1][3];
        if(arr[1] == 1){
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        }else{
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i < t + 1; i++) {
            if(arr[i] == 1){
                dp[i][0][1] = dp[i-1][0][1] + 1;
                dp[i][0][2] = dp[i-1][0][2];

                for (int j = 1; j < w + 1; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]);
                }
            }else{
                dp[i][0][1] = dp[i-1][0][1];
                dp[i][0][2] = dp[i-1][0][2] + 1;
                for (int j = 1; j < w + 1; j++) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]) + 1;
                }
            }
        }

        for (int i = 0; i < w + 1; i++) {
            ans = Math.max(ans, Math.max(dp[t][i][1], dp[t][i][2]));
        }

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
