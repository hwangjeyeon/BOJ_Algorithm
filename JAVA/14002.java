import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. LIS에 약간의 구현이 추가된 문제다
 * 2. 입력크기가 작아서 이중포문으로 가능한 LIS문제인데, 출력을 하는 방법이 조금 까다롭다
 * 3. 출력 방법은 스택과 역순 탐색이다. 스택을 준비하고 역순탐색하면서 현재 DP가 LIS의 MAX길이랑 같으면 그 값을 스택에 넣고 MAX값을 줄인다
 * 4. 이렇게 하면 역순으로 최대길이의 LIS 부분 수열을 구할 수 있다
 * 5. 최대길이를 출력하고 스택에 있는 모든 값을 출력하면 정답이 된다
 * 6. 이때 LIS의 초기값을 1로 설정하자 아니면 크기가 1일 떄, 0이 출력되어서 틀린다
 *
 * 해결방법:
 *
 * 시간복잡도: O(n^2)
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
        int[] dp = new int[n];
        Stack<Integer> stack = new Stack<>();
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }

        }
        int ans = max;
        for (int i = n-1; i >= 0; i--) {
            if(dp[i] == max){
                stack.push(arr[i]);
                max--;
            }
        }

        bw.write(ans+"\n");
        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }

}
