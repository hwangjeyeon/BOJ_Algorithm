import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. 이중 포문으로 현재의 위치에서 i+j의 위치에 dp[i+j]와 dp[i] + 1을 비교하여 더 작은 값을 넣어준다
 * 2. 최종적으로 dp[n-1]의 값이 Integer.MAX_VALUE이면 -1이고 아니면 해당 횟수를 출력하면 된다
 *
 * 해결방법:
 * 1. 자꾸 27%에서 틀려서 찾아봤는데, Integer.MAX_VALUE에서 +1을 하는 경우가 있어서 발생하는 문제였다
 * 2. 따라서 long타입으로 dp를 바꾸고, 최댓값보다 커지면 continue로 스킵하도록 변경하여 해결하였다.
 *
 * 시간복잡도: O(n * arr[i])
 * 공간복잡도: O(n)
 *
 */




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if(dp[i] >= Integer.MAX_VALUE){
                continue;
            }
            for (int j = 1; j <= arr[i]; j++) {
                if(i+j < n){
                    dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                }
            }
        }
        if(dp[n-1] >= Integer.MAX_VALUE){
            dp[n-1] = -1;
        }
        bw.write(dp[n-1]+"");
        br.close();
        bw.close();
    }

}

