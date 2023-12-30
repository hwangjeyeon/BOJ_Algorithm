import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 조합을 이용해 푸는 문제다
 * - 한가지 더 고려할 점은 이 문제는 짧은 시간제한때문에 DP를 활용해야한다
 * - 조합의 성질을 이용하면 정말 쉽게 풀 수 있다. n+1Cr+1 = nCr + nCr+1 이 공식을 이용하면 문제를 쉽게 풀 수 있다
 * - 단 한가지 예외를 미리 처리해놔야하는데, 두 수가 같은 경우와 r이 0인 경우이다
 * - 이때 위 예외 상황은 모두 1로 처리해둔다.
 * - 그리고 2차원 DP배열을 이용해서 미리 계산해둔 뒤, 테스트케이스에서 값이 들어올 때 해당 배열을 확인해서 값을 출력한다.
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */



public class Main {
    static final int MAX = 31;

    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp = new long[MAX][MAX];
        combination();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(dp[m][n]+"\n");
        }

        br.close();
        bw.close();
    }


    static void combination(){
        for(int i=1; i<MAX; i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i=2; i<MAX; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
    }
}
