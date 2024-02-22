import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - dp를 이용해서 풀었다.
 * - 또한 조합의 성질을 이용해서 nCr = n-1Cr-1 + n-1Cr인 점을 활용했으며 n==k,k==0일때는 1을 리턴하도록한다
 * - 또한 dp를 이용해서 저장된 값이 있는 경우 (즉 0이 아닐떄를 의마함)  해당 dp의 값을 리턴한다
 * - 마지막으로 재귀함수 호출문에서 문제에서 주어진 10007을 모듈러 연산해준다.
 *
 * 시간복잡도: O(logn)
 * 공간복잡도: O(n^2)
 *
 */


public class Main {

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n+1][k+1];
        int ans = comb(n,k);

        bw.write(ans+"");
        br.close();
        bw.close();
    }

    static int comb(int n, int k){
        if(dp[n][k] > 0){
            return dp[n][k];
        }

        if(n==k || k == 0){
            return dp[n][k] = 1;
        }
        return dp[n][k] = (comb(n-1 , k-1) + comb(n-1, k))%10007;
    }

}

