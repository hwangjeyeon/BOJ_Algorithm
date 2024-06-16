import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 브루트 포스로 풀었다. 규칙이 그냥 하나씩 떼어서 더하면 최대값이 나온다.
 * 2. 수학적으로 계산하면 다음과 같이 더 쉽게 풀 수 있다. (n*(n-1)/2)하면 된다
 * 3. dp로도 풀 수 있다. dp[n] = (n-1) + dp[n-1]이라는 점화식이 나온다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(1)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = n; i > 1; i--) {
            ans += (i-1);
        }
        bw.write(ans+"");

        br.close();
        bw.close();
    }



}

