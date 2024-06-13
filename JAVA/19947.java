import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. dp에는 이전 년도에 선택한 투자 방법에서 얻은 이익을 더한 총 자산을 의미한다
 * 2. dp[0]은 초기자금인 h가 들어갈테고 dp[1]은 1년 투자 밖에 안 되기때문에 해당 방법을 선택해준다
 * 3. 그리고 그리디하게 선택할 수 없는 반례가 존재해서 1년 투자 비용과 3년 투자 비용 5년 투자비용을 모두 체크해서 가장 큰 값으로 현재 값을 취해준다
 *
 * 해결방법:
 * 1. 구현은 2부터 y+1전까지 진행하는데 먼저 현재 dp[i] = dp[i-1] *1.05.를 넣어준다
 * 2. i>=3인 경우 dp[i]에는 현재 dp[i]와 dp[i-3] * 1.2를 비교해서 더 큰 값을 넣어둔다
 * 3. i>=5인 경우 dp[i]에는 현재 dp[i]와 dp[i-5]* 1.35 를 비교해서 더 큰 값을 넣어둔다
 * 4. dp[y]를 출력하면 정답이 된다.
 *
 * 시간복잡도: O(y)
 * 공간복잡도: O(y)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] dp = new int[y+1];
        dp[0] = h;
        dp[1] = h + (int)(h*0.05);
        for (int i = 2; i < y + 1; i++) {
            dp[i] = (int) (dp[i-1] * 1.05);
            if(i >= 3){
                dp[i] = (int) Math.max(dp[i], dp[i-3]*1.2);
            }
            if(i >= 5){
                dp[i] = (int) Math.max(dp[i], dp[i-5]*1.35);
            }
        }
        bw.write(dp[y] + "");

        br.close();
        bw.close();
    }



}

