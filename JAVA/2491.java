import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. N이 크기 때문에 DP를 써야한다
 * 2. 커지는 경우와 작아지는 경우를 모두 구해야하므로 DP배열을 두개 선언하고, 최초값은 1로 초기화한뒤, 이전보다 이상 혹은 이하인 경우 각각의 DP에 값을 갱신한다
 * 3. 이어서 N만큼 순회를 돌며, ans에 ans와 최대 최소 dp를 비교하여 가장 큰 값으로 갱신한다
 * 4. 완성된 ans를 출력하면 정답이 된다.
 *
 * 해결방법:
 *
 * 시간복잡도: O(n)
 * 공간복잡도: O(n)
 *
 */


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        maxDp[0] = 1;
        minDp[0] = 1;
        for (int i = 1; i < n; i++) {
            maxDp[i] = 1;
            minDp[i] = 1;
            if(arr[i] >= arr[i-1]){
                maxDp[i] = maxDp[i-1] + 1;
            }
            if(arr[i] <= arr[i-1]){
                minDp[i] = minDp[i-1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(maxDp[i], minDp[i]));
        }

        bw.write(ans+"");

        br.close();
        bw.close();

    }
}
