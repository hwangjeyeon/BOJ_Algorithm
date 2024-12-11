import java.io.*;
import java.util.*;

/**
 * 풀이 과정:
 * 1. 입력값 최대 크기 떄문에 누적합으로 해결하는 문제다
 * 2. 합산을 구하는데 만약 이전 악보의 난이도가 현재보다 높다면 이전 누적합에 1을 더한 값을 현재 누적합으로 계산하고 아닌 경우 그대로 이전 누적합을 이어받는다
 * 3. 이제 Q만큼 순회를 돌며 누적합의 y지점에서 x지점을 뺀 값을 출력하면 정답이 된다.
 *
 * 해결방법:
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
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = arr[i-1] > arr[i] ? sum[i-1] + 1 : sum[i-1];
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write((sum[y] - sum[x]) + "\n");
        }

        br.close();
        bw.close();
    }

}
