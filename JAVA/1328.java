import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 이전 막대 배치 문제와 똑같은 문제다. 모듈러 연산만 추가하면 된다
 * 2. 빌딩을 배치하는 것으로 생각하면 된다. 대신 이때, 가장 작은 빌딩을 배치한다고 생각하면 된다
 * 3. 초기값은 1로 한다. 1,1,1인 경우에 1로 초기화한다. 배치의 위치는 맨왼쪽, 맨오른쪽, 그리고 건물 사이가 될 것이다
 * 4. 왼쪽과 오른쪽에 배치할 경우, 이전 빌딩의 개수에서 1개가 증가하고 왼쪽과 오른쪽에서 보이는 빌딩이 하나씩 증가할 것이다
 * 5. 가운데는 빌딩의 개수만 변동하며, 똑같은 경우가 양 끝지점을 배치했을 때를 제외한 n-2개만큼 반복될 것이다
 * 6. 여기에 모듈러 연산만 추가해서 정답을 그대로 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(100^3)
 * 공간복잡도: O(100^3)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[][][] dp = new long[101][101][101];
        dp[1][1][1] = 1;
        for (int i = 2; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                for (int k = 1; k < 101; k++) {
                    dp[i][j][k] += dp[i-1][j-1][k] + dp[i-1][j][k-1] + (dp[i-1][j][k] * (i-2));
                    dp[i][j][k] %= 1_000_000_007;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        bw.write(dp[n][l][r] + "");


        br.close();
        bw.close();
    }

}
