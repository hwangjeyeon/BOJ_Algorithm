import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 이중 포문으로 dp를 활용해서 이전 날짜중에 현재 날짜에 상담이 가능한 시간이면 현재 날짜의 값과그 이전 날짜의 값 합 그리고 현재 dp에 저장된 값중 누가 더 큰지 비교해서 큰 값을 넣는 방법을 선택했다
 * 2. 하지만 이 방법이 91퍼에서 계속 실패하였다.
 * 
 * 해결방법:
 * 1. 첫날에 일한 돈은 다음에 누적된다는 원리로 접근한다. 따라서 현재 진행된 날짜인 i와 pairs[i].time이 퇴사 날짜를 초과하지 않는다면 다음과 같은 점화식을 얻을 수 있다
 * 2. dp[i + pairs[i].time] = Math.max(dp[i+paris[i].time], dp[i] + pairs[i].money);
 * 3. 이어서 dp[i+1] = Math.max(dp[i+1], dp[i]);로 오늘 일한 금액을 다음날 누적시킨다
 * 4. dp[n]을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

class Pair{

    int time;
    int money;

    public Pair(int time, int money) {
        this.time = time;
        this.money = money;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            if(i + pairs[i].time <= n){
                dp[i + pairs[i].time] = Math.max(dp[i + pairs[i].time], dp[i] + pairs[i].money);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }



}

