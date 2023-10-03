import java.io.*;


/**
 * 풀이 방법: dp 알고리즘으로 풀었습니다.
 * 접근 방법: dp 공부를 위해 이전 11726 문제를 생각해서 접근했습니다
 * 풀이 과정:
 * - DP 방식의 가장 중요한 것은 이것이 DP 방식으로 풀 수 있는지 확인하는 것이 중요합니다.
 * - 따라서 해당 경우의 수를 몇개 해봐서 중복되는 규칙이 존재하는지, 그것으로 점화식을 뽑아낼 수 있는지 확인합니다. -> 해당 과정에 대한 수많은 연습이 필요한 상태
 * - 위 과정을 통해서 규칙을 발견했는데 dp[n] (n>=3)일때 dp[n] = dp[n-1] + 2*dp[n-2]인 것을 확인할 수 있습니다.
 * 1. dp[1], dp[2]를 저장하며, 바텀업 방식으로 dp[n] = (d[n-1] + 2*dp[n-2])%10007을 반복합니다.
 * 2. n이 1보다 큰 경우에만 1을 진행하며 1일 경우 dp[1]=1 과정 후에 1번을 건너뛰고 값을 dp[n]을 출력합니다.
 * 3. 2번의 경우가 아닌 경우 dp[n]을 출력합니다
 *
 * 시간복잡도: O(n) -> for 루프가 n번에 한하여 돌기 때문
 * 공간복잡도: O(n) -> 배열의 크기가 n+1이기 떄문
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n > 1){
            dp[2] = 3;
            for(int i=3; i<n+1; i++){
                dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
            }
        }


        bw.write(dp[n] + "");
        bw.close();

    }
}
