import java.io.*;
import java.util.*;


/**
 * 풀이 과정:
 * - 고민과 풀이:
 * 1. (sum[j] - sum[i-1])%M = 0 공식을 저번처럼 변형하여 탐색하는 문제다
 * 2. sum[j] % M = sum[i-1] % M로 바꿀 수 있는데, 나머지가 같다면 정답 횟수로 체크할 수 있다는 의미다
 * 3. 따라서 누적합을 구한뒤 모두 m으로 모듈러 연산을 해주고 그룹 지어서 개수를 세어준다
 * 4. 이떄, 각 0~m-1까지의 수의 개수를 체크할 배열을 하나 선언하고, 3번 작업을 하며 기록한다
 * 5. 그리고 0~m-1까지 순회하면서 2개씩 그룹짓기 위해, remain[i]C2 연산을 해준다
 * 6. 5번 작업은 remain[i] * (remain[i]-1)/2로 구현하면 된다. 해당 값을 ans에 더해준다
 * 7. 한가지 더 고려할 것이 있는데, 0인 지점은 자기자신으로도 정답이 될 수 있다.
 * 8. 따라서 해당 결과를 ans에 추가로 더해준다. 이때 ans는 int형 범위를 벗어날 수 있으므로 long타입으로 한다
 * 9. 완성한 ans를 출력하면 정답이 된다.
 *
 * - 문제 해결:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[] sum = new long[n+1];
        int[] remain = new int[m];
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i-1] + arr[i];

        }
        long ans = 0;
        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i] % m;
            remain[(int) sum[i]]++;
        }

        for (int i = 0; i < m; i++) {
            ans += (long) remain[i] * (remain[i]-1) / 2;
        }
        ans += remain[0];

        bw.write(ans+"");

        br.close();
        bw.close();
    }

}
