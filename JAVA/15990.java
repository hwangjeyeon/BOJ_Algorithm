import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * - 2차원 배열의 활용 방법을 공부하기 위해, 풀이를 참고해서 풀었습니다 -> 추후 시간이 지난 후에 다시 재도전할 예정
 * - 시간복잡도 문제를 해결하기 위해 테스트케이스 내에서 돌리는 것이 아닌, 미리 배열의 크기를 알기 때문에 그만큼 크기 설정 후, 초기화를 미리 해둔다
 * -> 이후 테스트케이스만큼 반복해서 입력하는 숫자의 위치에서의 값의 합을 출력한다
 * 1. 점화식을 구하는 과정은 1차원 배열으로 할 때와 비슷 -> 지속적인 연습으로 찾아내는 능력을 길러야할 필요가 있음
 * 2. 2차원 배열은 점화식을 구하는 과정을 한쪽을 고정시키면서 푸는 경우 활용 가능, 혹은 값이 두개가 들어와 두 값을 조합하여 상태를 비교해야할때 사용한다.
 * -> 2차원 배열도 앞으로 계속 연습문제를 풀면서 숙달시켜나갈 예정
 *
 *
 * 점화식
 * dp[i][1] = dp[i-1][2] + dp[i-1][3]
 * dp[i][2] = dp[i-2][1] + dp[i-2][3]
 * dp[i][3] = dp[i-3][1] + dp[i-3][2]
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n^2)
 *
 *
 */




public class Main {

    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        IntStream.range(4, 100001).forEach(i -> {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%1000000009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%1000000009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
        });
        IntStream.range(0, T).forEach(i -> {
            try {
                int n = Integer.parseInt(br.readLine());
                bw.write((dp[n][1] + dp[n][2] + dp[n][3])%1000000009 + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        br.close();
        bw.close();
    }


}
