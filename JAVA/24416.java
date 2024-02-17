import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 주어진 의사코드 구현화면 된다. 확실히 DP를 활용하는게 횟수가 적은 것을 확인할 수 있다.
 *
 * 시간복잡도: O(2^n) -> 피보나치, dp -> O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {
    static int[] dp;
    static int count1 = 0;
    static int count2 = 0;
    static int fibonacciBasic(int n){

        if(n == 1 || n == 2){
            count1++;
            return 1;
        }else{
            return (fibonacciBasic(n-1) + fibonacciBasic(n-2));
        }
    }

    static void fibonacciDp(int n){
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            count2++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        fibonacciDp(n);
        fibonacciBasic(n);

        bw.write(count1+" " + count2);

        br.close();
        bw.close();
    }

}

