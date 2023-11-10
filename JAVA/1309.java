import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


/**
 * 풀이 과정:
 * - 백준 단계별 해결 문제 푸는 중 + 2차원 배열 활용 DP + 문자열 공부 중
 * 해결방법:
 * 각 행을 기준으로 생각하자
 * 사자의 배치도
 * O X -> 0
 * X O -> 1
 * X X -> 2
 * 이 3가지 경우를 조합해서 배치하게된다
 * 각각을 0, 1, 2 라고 보자
 *
 * 각각은 다음과
 * 0일 경우는 이전에 1과 2가 오는 경우
 * dp[i][0] = dp[i-1][1] + dp[i-1][2];
 * 1일 경우는 이전에 1과 0이 오는 경우
 * dp[i][1] = dp[i-1][0] + dp[i-1][2];
 * 2일 경우는 이전에 0과 1과 2가 오는 경우 모두 가능하다
 * dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
 *
 * 이를 위해서
 * dp[1][]인 경우를 초기화 해야한다
 * dp[1][0] = 1;
 * dp[1][1] = 1;
 * dp[1][2] = 1;
 *
 * 점화식은 다음과 같다
 * dp[i][0] = dp[i-1][1] + dp[i-1][2];
 * dp[i][1] = dp[i-1][0] + dp[i-1][2];
 * dp[i][2] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
 *
 * 점화식 도출에서 힌트를 얻었더니 정말 쉽게 풀리는 문제... 
 * 2차원 배열을 활용한 dp 방식에 점점 감이 오고 있는 것 같다. 힌트 없이 혼자서 풀 수 있는 그날까지 화이팅!
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
        int n = Integer.parseInt(br.readLine());
        dp = new long[100001][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        IntStream.range(2, 100001)
                        .forEach(i -> {
                            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 9901;
                            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
                            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
                        });

        bw.write((dp[n][0]+dp[n][1]+dp[n][2])% 9901 + "");
        br.close();
        bw.close();
    }


}
