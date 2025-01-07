import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 자릿수를 DP로 잡는 것이 해결방법인 문제다
 * 2. 주어진 문제의 조건을 잘 읽어보면 1~26까지의 수만이 가짓수로 가능하며, 만약 현재나 바로 이전의 수가 0인 경우는 건너뛰어야한다
 * 3. 이점을 이용해서 먼저 dp[0]을 1로 초기화한다음 탐색을 진행한다
 * 4. 현재 자릿수의 값을 꺼내서 만약 1~9라면 이전 dp값을 합해준다. 그리고 모듈러 연산을 진행한다
 * 5. 이어서 그 이전 자릿수를 확인해야하는데 첫번째 자릿수면 확인 불가능하므로 컨너뛴다
 * 6. 이어서 두번째 자릿수를 꺼낸 뒤, 십의 자리로 바꾸고 나서 첫번쨰 수를 더한다
 * 7. 그리고 그 값이 10~126 사이라면 자신의 2번째 이전의 값을 합산한다. 그리고 이어서 모듈러 연산을 한다
 * 8. 이렇게 완성한 n번째 자리의 dp값을 출력하면 정답이 된다. 어차피 초기값이 0이기 때문에 암호가 잘못된 경우도 0으로 출력한다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(num.length)
 * 공간복잡도: O(num.length)
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] num = br.readLine().toCharArray();
        long[] dp = new long[num.length+1];

        dp[0] = 1;
        for (int i = 1; i <= num.length; i++) {
            int one = Character.getNumericValue(num[i-1]);
            if(one >= 1 && one <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= 1_000_000;
            }
            if(i == 1){
                continue;
            }

            int two = Character.getNumericValue(num[i-2]);
            if(two == 0){
                continue;
            }
            int sum = two*10 + one;
            if(sum >= 10 && sum <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= 1_000_000;
            }

        }

        bw.write(dp[num.length] + "\n");


        br.close();
        bw.close();
    }


}
