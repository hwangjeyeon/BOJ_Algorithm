import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 이전 계단 오르기 DP 문제와 유사한 문제이다
 * - 내 두번째 전이 선택되는 경우 vs 내 세번째 전 + 내 직전이 선택되는 경우중 더 큰값을 선택하고 현재의 값을 더해서 dp에 저장하면된다
 * - 하지만 이렇게 하면 예제 입력 1번의 출력값을 충족시키지 못한다.
 * - 이를 위해 힌트를 찾아봤는데, 계단 오르기와의 가장 큰 차이점인 마지막 수를 포함하냐 안 하냐의 차이 때문이었다
 * - 위에서 선택한 결과가 내 직전의 결과보다 작으면 지금의 DP는 이전 DP의 결과를 따라야 한다
 * - 만약 위 조건을 지키지 않는다면 1을 선택하게 되어서 32가 나와 조건을 만족시키지 못하게 된다
 * - 따라서 위 조건에 따라 만족한 점화식으로 출력하면 정답이 된다.
 * - 추가 dp[2]는 n이 1보다 큰 경우에 넣어줘야 한다 아니면 인덱스 예외가 터진다
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {


    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n+1];
        dp[1] = arr[1];
        if(n > 1){
            dp[2] = arr[1] + arr[2];
        }
        for (int i = 3; i < n+1; i++) {
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i]);
        }

        bw.write(dp[n]+"");


        br.close();
        bw.close();
    }

}

