import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 피보나치 수열이랑 같은 점화식을 가지고 있다.
 * - dp를 사용해서 시간제한이 짧은 문제를 해결하고 추가로 꼭 문제를 꼼꼼히 읽어서 %15746을 해주자
 *
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        if(n == 1) {
            bw.write(1 + "");
        }else if(n == 2){
            bw.write(2 + "");
        }else{
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }
            bw.write(dp[n] +"");
        }

        br.close();
        bw.close();
    }

}

