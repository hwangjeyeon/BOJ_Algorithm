import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. dp를 이용하는 문제다. 1,2,3까지 채워주고 4부터 n까지 탐색한다
 * 2. i-1, i-3, i-4의 합이 0보다 크면 0이고 아니면 1로 한다
 * 3. 만약 n이 0이면 상근이가 이기고 아니면 창영이가 이긴다
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
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            if(dp[i-1] + dp[i-3] + dp[i-4] > 0){
                dp[i] = 0;
            }else{
                dp[i] = 1;
            }
        }
        if(dp[n] == 0 ){
            bw.write("SK");
        }else{
            bw.write("CY");
        }


        br.close();
        bw.close();
    }

}
