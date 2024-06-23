import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. 주어진 점화식대로 dp를 활용해서 풀면된다
 * 2. 이때 최대 입력값을 봤을 때, int형은 안되고 long형은 되기 때문에 dp배열 타입을 long 타입으로 지정해서 해결한다.
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
        long[] dp = new long[117];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 117; i++) {
            dp[i] = dp[i-1] + dp[i-3];
        }
        int n = Integer.parseInt(br.readLine());
        bw.write(dp[n] + "");

        br.close();
        bw.close();
    }



}

