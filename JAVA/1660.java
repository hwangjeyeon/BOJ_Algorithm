import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 1. dp1 에는 각 정삼각형마다 필요한 대포알의 개수, dp2에는 사면체에 가지고 있는 대포알의 총 합을 넣어주었다
 * 2. 각각 점화식은 dp1[i] = dp1[i-1] + i, dp2[i] = dp1[i] + dp2[i-1];이다
 *
 *
 * 해결방법:
 * 3. ans 배열에는 횟수를 담아준다. 이때 최솟값을 담아주어야  하므로 Integer.MAX_VALUE로 초기화한다
 * 4. 2부터 n까지 순회하면서 dp의 값들을 비교한다. 이때 dp[j]의 값이 i보다 크다면 break한다
 * 5. ans[i]에는 ans[i]와 ans[i-dp2[j]] + 1 중 작은 값을 넣어준다. ans[i-dp2[j]]는 현재 구하려는 숫자에서 dp2[j] 크기만큼 뺐을 때의 횟수이고 여기에 사면체를 하나 더 얹어야하니까 1을 더하는 것이다
 * 6. 완성한 ans[n]을 출력하면 정답이 된다.
 *
 * 시간복잡도: O(n*122)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp1 = new int[122];
        int[] dp2 = new int[122];
        dp1[1] = 1;
        dp2[1] = 1;
        for (int i = 2; i < 122; i++) {
            dp1[i] = dp1[i-1] + i;
            dp2[i] = dp1[i] + dp2[i-1];
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 122; j++) {
                if(dp2[j] > i){
                    break;
                }
                ans[i] = Math.min(ans[i], ans[i-dp2[j]]+1);
            }
        }
        bw.write(ans[n] +"");

        br.close();
        bw.close();
    }


}

