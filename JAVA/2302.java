import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 가짓수를 보면 dp로 해결할 수 있는 문제다
 * 2. 먼저 VIP를 제외하고 가능한 가짓수를 생각해보자.
 * 3. 1일때는 1가지, 2일때는 2가지다. 3일때는 3가지고, 4일때는 5가지가 된다
 * 4. 혹시나 하는 마음에 5일대까지 확인해보면 8이된다
 * 5. 따라서 점화식 dp[i] = dp[i-1] + dp[i-2]가 성립된다
 * 6. 이제 vip를 배치하는 경우를 결합해서 생각하자
 * 7. 이 경우는 vip 배치가 오름차순으로 들어오는 경우를 생각해서, 그 좌석을 기준으로 구간을 나눠서 생각해야한다
 * 8. 만약 4라는 위치에 vip가 배치된다면 dp[now - before - 1]로 이전 vip 위치를 이용해 현재 구간의 인원 수를 파악한다
 * 9. 이어서 인원수에 해당하는 가짓수를 ans에 곱해주면된다. 이때 dp를 활용하면 쉽게 구할 수 있다
 * 10. 이렇게 이전 vip 위치를 갱신하며 정답 변수를 갱신하고 완성한 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(m)
 * 공간복잡도: O(1)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int ans = 1;
        int before = 0;
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(br.readLine());
            ans *= dp[now - before -1];
            before = now;
        }
        ans *= dp[n - before];

        bw.write(ans+"");


        br.close();
        bw.close();
    }

}
