import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * 
 *
 * 해결방법:
 * 1. 해결법이 상당히 간단하다. 어떻게 보면 DP문제이면서 아이디어 문제인 것같다
 * 2. i,j,l,k를 각각 dp의 한 인덱스로 보자. 그럼 dp는 크기가 4인 1차원 배열이 나온다
 * 3. i와 l은 최소 j와 k는 최대가 되어야지 최댓값이 나온다
 * 4. 그렇다면 dp[0]은 입력값들을 받으면서 dp[0]와 입력값을 음수값을 전환했을 때의 값중 더 큰 값을 넣어준다
 * 5. i는 최소가 되어야하며, 빼는 수가 될 것이기 때문이다
 * 6. 이어서 dp[1]은 현재 dp[1]의 값과 이전 dp[0]에 현재 입력값을 더한 경우 중 더 큰 값을 넣어준다
 * 7. 2와 3도 똑같이 진행한다. 주의할점은 역순으로 진행해야한다. 왜냐하면 3은 2에 영향을 받고 있고 2는 1에 영향을, 1은 0에 영향을 받고 있기 때문이다
 * 8. 0은 입력값에 영향을 받는데 입력값은 고정되어 있다. 따라서 dp의 값이 영향 받는 것을 피하기 위해 뒤에서부터 dp를 갱신하자
 * 9. dp의 초기값은 나올 수 있는 가장 작은 수로 초기화한다. 1000000이 최대 입력값이니 -1000000한 값이 최소값이 될 것이다. 따라서 -1000000으로 dp를 초기화한다
 * 10. 이렇게 했을 때 dp[3]을 출력하면 정답이 된다
 * 11. 문제의 제목에 주어진 식과 dp를 활용하는 아이디어로 풀면 정말 쉽게 풀 수 있는 문제였다.
 * 12. dp에 대한 연습을 더하면서 고난이도 dp의 식을 더 빨리 뽑을 수 있도록 연습하자!
 * 
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[4];
        for (int i = 0; i < 4; i++) {
            dp[i] = -1000000;
        }

        for (int i = 0; i < n; i++) {
            dp[3] = Math.max(dp[3], dp[2] + arr[i]);
            dp[2] = Math.max(dp[2], dp[1] - arr[i]);
            dp[1] = Math.max(dp[1], dp[0] + arr[i]);
            dp[0] = Math.max(dp[0], -arr[i]);
        }

        bw.write(dp[3] + "");

        br.close();
        bw.close();
    }

}
