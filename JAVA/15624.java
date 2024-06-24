import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 피보나치 수의 점화식과 DP를 활용하여 풀면 된다
 * 2. 이때 입력값이 크기 때문에 BigInteger를 사용한다. long형도 벗어나는 크기이다
 * 3. 먼저 dp에 더해준 뒤, mod연산으로 dp에 다시 넣어준다
 * 4. 최종 완성된 dp[n]을 문자열 형태로 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[1000001];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
            dp[i] = dp[i].mod(BigInteger.valueOf(1000000007));
        }
        bw.write(dp[n].toString());

        br.close();
        bw.close();
    }



}

