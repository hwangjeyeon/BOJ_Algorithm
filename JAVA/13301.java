

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 먼저 정답을 위한 n를 구분하기 위해 dp에는 각 정사각형 한변의 길이를 저장한다. 피보나치 형태이기 때문에 d[i] = dp[i-1] + dp[i-2] 점화식이 나온다
 * 2. 그다음 출력할 때는 현재값인 dp[i]에 4를 곱하고 이전값인 dp[i-1]에 2를 곱하면 정답이 된다.
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(1)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[81];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write((dp[n]*4 + dp[n-1]*2)+"");


        br.close();
        bw.close();
    }
}

