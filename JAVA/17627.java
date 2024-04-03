import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. 제곱했을 때, 5만이하로 나오는 수는 223이 최대이다.
 * 2. 최대 4개까지 가능하니 4중 포문을 돌리자. 223^4니까 시간제한안에 문제를 해결할 수 있다
 * 3. 만약 세 수를 더했을 때 같은 수가 있으면 i,j,k를 봐서 0이 아니면 ans++해주고 그 결과를 출력하고 종료한다.
 *
 *
 * - 문제 해결:
 *
 *
 * 시간복잡도: O(223^4)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[224];
        for (int i = 1; i < 224; i++) {
            dp[i] = (int)Math.pow(i,2);
        }

        int n = Integer.parseInt(br.readLine());
        int ans = 1;
        for (int i = 0; i < 224; i++) {
            for (int j = 0; j < 224; j++) {
                for (int k = 0; k < 224; k++) {
                    for (int l = 0; l < 224; l++) {
                        if(n == dp[i] + dp[j] + dp[k] + dp[l]){
                            if(i != 0) {
                                ans++;
                            }
                            if(j!=0){
                                ans++;
                            }
                            if(k!=0){
                                ans++;
                            }
                            bw.write(ans+"");
                            br.close();
                            bw.close();
                            return;
                        }
                    }
                }
            }
        }
        br.close();
        bw.close();
    }
}

