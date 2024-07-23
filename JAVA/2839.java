import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. dp로 새롭게 풀었다.
 * 2. i%5 == 0을 만족하는 경우 dp[i] = dp[i-5] + 1;
 * 3. i%3 == 0을 만족하는 경우 dp[i] = dp[i-3] + 1;
 * 4. 둘다 불만족하면 dp[i-3]과 dp[i-5]둘다 0이 아닌경우 둘중 작은 것의 + 1한 값을 넣어준다
 * 5. 만약 dp[n]이 0이라면 -1을 출력하고 아니라면 dp[n]을 출력한다.
 * 
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
        int[] dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 6; i < 5001; i++) {
            if(i%5 == 0){
                dp[i] = dp[i-5] + 1;
            }else if(i%3 == 0){
                dp[i] = dp[i-3] + 1;
            }else{
                if(dp[i-3] != 0 && dp[i-5] != 0){
                    dp[i] = Math.min(dp[i-3], dp[i-5])+ 1;
                }
            }
        }

        if(dp[n] == 0){
            bw.write("-1");
        }else{
            bw.write(dp[n]+"");
        }

        br.close();
        bw.close();
    }
}

