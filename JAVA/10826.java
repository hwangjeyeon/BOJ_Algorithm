import java.io.*;
import java.math.BigInteger;
import java.util.*;


/**
 * 풀이 과정:
 * 1. DP를 이용한 피보나치 수열인데... n의 값이 엄청 크게 될 수 있어서 BIGINTER를 활용하였다.
 * 2. 한가지 주의할 점은 n이 0으로 들어올 수도 있기 때문에 예외처리를 해주고 출력해야한다.
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
        BigInteger[] dp = new BigInteger[n + 1];
        if(n == 0){
            dp[0] = BigInteger.ZERO;
        }else{
            dp[0] = BigInteger.ZERO;
            dp[1] = BigInteger.ONE;
            for (int i = 2; i < n+1; i++) {
                dp[i] = dp[i-1].add(dp[i-2]);
            }
        }


        bw.write(dp[n]+"");

        br.close();
        bw.close();
    }



}

