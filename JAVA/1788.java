import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 *
 * 해결방법:
 * 1. dp 크기를 두배로 늘려서 최대 입력 절댓값을 0으로 판단하고 그 이전을 음수 이후를 양수로 생각한다
 * 2. 양수 부분은 점화식이 피보나치 수열과 똑같고 음수부분은 dp[i] = (dp[i+2] - dp[i+1]) % 1000000000;과 같은 점화식을 뽑는다
 * 3. 주어진 조건대로 구분하여 정답을 출력한다
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
        long[] dp = new long[2000001];
        dp[1000000] = 0;
        dp[1000001] = 1;
        for (int i = 999999; i >= 0; i--) {
            dp[i] = (dp[i+2] - dp[i+1]) % 1000000000;
        }
        for (int i = 1000002; i < 2000001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        if(dp[n+1000000] < 0){
            bw.write("-1\n");
        }else if(dp[n + 1000000] == 0){
            bw.write("0\n");
        }else{
            bw.write("1\n");
        }
        bw.write(Math.abs(dp[n+1000000])+"");

        br.close();
        bw.close();
    }


}

