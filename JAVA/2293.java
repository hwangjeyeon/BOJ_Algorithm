

import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 *
 *
 * - 문제 해결:
 * 1. dp 문제는 점화식을 잘 뽑아내야하는데 쉽지 않은 문제였다
 * 2. 각 dp 배열의 자릿수는 만들 수 있는 숫자를 의미하도록 정의한다
 * 3. 이때 p1으로 각 자릿수를 만들 수 있는 경우를 더해준다
 * 4. dp[0]은 1로 지정하며, p1부터 k까지 순회하면서 dp[j]에 dp[j-p1]을 더해준다
 * 5. 이렇게 하면, 이전 p1의 값을 활용할 수 있게 된다
 * 6. 완성한 다음 dp[k]를 출력하면 정답이 된다.
 *
 *
 * 시간복잡도: O()
 * 공간복잡도: O()
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        int[] dp = new int[k+1];
        dp[0] = 1;

        for (int i = 1; i < n+1; i++) {
            int p1 = Integer.parseInt(br.readLine());
            for (int j = p1; j < k+1; j++) {
                dp[j] += dp[j - p1];
            }
        }

        bw.write(dp[k]+"");

        br.close();
        bw.close();
    }
}

